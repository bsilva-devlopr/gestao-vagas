FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-21-jdk maven

COPY . .
RUN mvn clean install -DskipTests

# -----------------------------
# Imagem final (runtime)
# -----------------------------
FROM eclipse-temurin:21-jre-alpine
EXPOSE 8091

COPY --from=build /target/gestao_vagas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
