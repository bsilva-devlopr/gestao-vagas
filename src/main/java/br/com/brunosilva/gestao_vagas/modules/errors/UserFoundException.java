package br.com.brunosilva.gestao_vagas.modules.errors;

public class UserFoundException extends RuntimeException {

  public UserFoundException() {
    super("Usuário já existe");
  }

}
