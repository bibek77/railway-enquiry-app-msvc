package com.github.bibek77.railwayenquiry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author bibek
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<ExceptionResponse> exception(DataNotFoundException exception) {
        ExceptionResponse errors = new ExceptionResponse();
        errors.setMessage(exception.getMessage());
        errors.setDescription(exception.getDescription());
        errors.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ServerErrorException.class)
    public ResponseEntity<ExceptionResponse> exception(ServerErrorException exception) {
        ExceptionResponse errors = new ExceptionResponse();
        errors.setMessage(exception.getMessage());
        errors.setDescription(exception.getDescription());
        errors.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
