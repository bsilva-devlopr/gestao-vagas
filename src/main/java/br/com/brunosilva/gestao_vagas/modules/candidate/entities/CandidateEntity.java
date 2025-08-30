package br.com.brunosilva.gestao_vagas.modules.candidate.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;

  @Pattern(regexp = "^[A-Za-z0-9._]+$", message = "O nome de usuário só pode conter letras, números, ponto e underline, sem espaços")
  private String username;

  @Email(message = "Insira um e-mail válido")
  private String email;

  @Length(min = 10, max = 100, message = "A senha deve ter entre 10 a 100 caracteres")
  private String password;
  private String description;
  private String curriculum;

}
