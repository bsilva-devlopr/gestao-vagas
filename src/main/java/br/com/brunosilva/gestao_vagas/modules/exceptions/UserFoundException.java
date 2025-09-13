package br.com.brunosilva.gestao_vagas.modules.exceptions;

public class UserFoundException extends RuntimeException {

  public UserFoundException() {
    super("Usuário já existe");
  }

}
