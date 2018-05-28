package br.com.aguiar.merchant.controller;

import br.com.aguiar.merchant.model.ErrorResponse;
import br.com.aguiar.merchant.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(annotations = Controller.class)
public class AdviceController {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        ErrorResponse err = new ErrorResponse(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Not found", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

//    @ExceptionHandler(DataIntegrityException.class)
//    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
//
//        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Integridade de dados", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
//
//        ValidationError err = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", e.getMessage(), request.getRequestURI());
//        for (FieldError x : e.getBindingResult().getFieldErrors()) {
//            err.addError(x.getField(), x.getDefaultMessage());
//        }
//        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
//    }
//
//    @ExceptionHandler(AuthorizationException.class)
//    public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
//
//        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(), "Acesso negado", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
//    }
//
//    @ExceptionHandler(FileException.class)
//    public ResponseEntity<StandardError> file(FileException e, HttpServletRequest request) {
//
//        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro de arquivo", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//    }
//
//    @ExceptionHandler(AmazonServiceException.class)
//    public ResponseEntity<StandardError> amazonService(AmazonServiceException e, HttpServletRequest request) {
//
//        HttpStatus code = HttpStatus.valueOf(e.getErrorCode());
//        StandardError err = new StandardError(System.currentTimeMillis(), code.value(), "Erro Amazon Service", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(code).body(err);
//    }
//
//    @ExceptionHandler(AmazonClientException.class)
//    public ResponseEntity<StandardError> amazonClient(AmazonClientException e, HttpServletRequest request) {
//
//        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro Amazon Client", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//    }
//
//    @ExceptionHandler(AmazonS3Exception.class)
//    public ResponseEntity<StandardError> amazonS3(AmazonS3Exception e, HttpServletRequest request) {
//
//        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Erro S3", e.getMessage(), request.getRequestURI());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
//    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception e, HttpServletRequest request) {
        ErrorResponse err = new ErrorResponse(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error", e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(err, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
