package com.luisfelipe.biblioteca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandler {

  @ExceptionHandler(LivroNaoEncontradoException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String, Object> tratarLivroNaoEncontrado(LivroNaoEncontradoException ex){
    Map<String, Object> erro = new HashMap<>();

    erro.put("Mensagem", ex.getMessage());
    erro.put("Code", HttpStatus.NOT_FOUND.value());

    return erro;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, Object> methodArgumentNotValid(MethodArgumentNotValidException ex) {
    Map<String, Object> erro = new HashMap<>();

    erro.put("Code", HttpStatus.BAD_REQUEST.value());
    erro.put("Mensagem", ex.getBindingResult().getFieldError().getDefaultMessage());

    return erro;
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, Object> messageNotReadableException(HttpMessageNotReadableException ex){
    Map<String, Object> erro = new HashMap<>();

    erro.put("Code", HttpStatus.BAD_REQUEST.value());
    erro.put("Mensagem","JSON inválido! Verifique os dados enviados.");

    return erro;
  }

}
