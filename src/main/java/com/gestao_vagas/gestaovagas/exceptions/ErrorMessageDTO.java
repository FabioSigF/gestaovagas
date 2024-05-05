package com.gestao_vagas.gestaovagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //cria construtor com argumentos
public class ErrorMessageDTO {
  private String message;
  private String field;
}
