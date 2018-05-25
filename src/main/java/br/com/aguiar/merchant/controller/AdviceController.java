package br.com.aguiar.merchant.controller;

import br.com.aguiar.merchant.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
public class AdviceController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        errorResponse.setMessage(ex.getMessage());
        return new ResponseEntity<>(errorResponse, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
