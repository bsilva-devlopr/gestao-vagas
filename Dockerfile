# -------------------------------------
# Build stage
# -------------------------------------
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copia primeiro o pom para aproveitar cache
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Agora copia o restante
COPY src ./src

# Build do projeto
RUN mvn clean package -DskipTests


# -------------------------------------
# Runtime stage
# -------------------------------------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
EXPOSE 8080

# Copia o JAR gerado
COPY --from=build /app/target/gestao_vagas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
