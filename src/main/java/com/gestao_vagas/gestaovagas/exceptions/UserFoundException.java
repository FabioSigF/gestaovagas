package com.gestao_vagas.gestaovagas.exceptions;

public class UserFoundException extends RuntimeException{
  public UserFoundException(){
    super("Usuário já existe.");
  }
}
