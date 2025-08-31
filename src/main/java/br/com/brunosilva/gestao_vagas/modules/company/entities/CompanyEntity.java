package br.com.brunosilva.gestao_vagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Pattern(regexp = "^[A-Za-z0-9._]+$", message = "O nome de usuário só pode conter letras, números, ponto e underline, sem espaços")
  private String username;

  @Email(message = "Insira um e-mail válido")
  private String email;

  @Length(min = 10, max = 100, message = "A senha deve ter entre 10 a 100 caracteres")
  private String password;
  private String website;
  private String name;
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
