package com.runas.api.Error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Trata exceções dos controladores
@RestControllerAdvice
public class ErrorHandler{
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorModel> handle(MethodArgumentNotValidException e){
        List<ErrorModel> erros = new ArrayList<>();
        List<FieldError> fields = e.getBindingResult().getFieldErrors();

        fields.forEach(campo -> {
            String mensagem = campo.getDefaultMessage();
            ErrorModel erro = new ErrorModel(campo.getField(), mensagem);
            erros.add(erro);
        });

        return erros;
    }
}
