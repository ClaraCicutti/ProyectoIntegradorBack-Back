package com.dh.clinica.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalException {

    final static Logger logger = Logger.getLogger(GlobalException.class);

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorResource(BadRequestException exception) {
        logger.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> procesarErrorBadRequest(ResourceNotFoundException exception) {
        logger.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
