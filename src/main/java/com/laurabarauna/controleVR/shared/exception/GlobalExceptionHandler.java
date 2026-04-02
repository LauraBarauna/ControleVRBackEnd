package com.laurabarauna.controleVR.shared.exception;

import com.laurabarauna.controleVR.shared.exception.custom.UsernameUniqueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        ErrorResponse response = new ErrorResponse("Validation failed", errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(UsernameUniqueException.class)
    public ResponseEntity<ErrorResponse> handleUsernameUniqueException(UsernameUniqueException ex) {
        Map<String, String> errors = new HashMap<>();

        errors.put("username", ex.getMessage());

        ErrorResponse response = new ErrorResponse("Username already exists", errors);

        return ResponseEntity.badRequest().body(response);
    }

}
