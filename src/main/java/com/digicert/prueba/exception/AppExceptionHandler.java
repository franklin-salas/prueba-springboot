package com.digicert.prueba.exception;

import com.digicert.prueba.dto.response.ErrorMessage;
import com.digicert.prueba.dto.response.ValidationErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handleValidationErrorException(MethodArgumentNotValidException ex, WebRequest webRequest){

        Map<String, String> errors = new HashMap<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        }

        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);

        String defaultMessage = objectError.getDefaultMessage();
        ValidationErrors validationErrors = new ValidationErrors(defaultMessage, errors, new Date(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(validationErrors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage( ex.getMessage(), new Date(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleException(Exception ex, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage( ex.getMessage(),new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
