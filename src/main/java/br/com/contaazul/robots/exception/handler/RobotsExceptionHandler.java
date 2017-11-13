package br.com.contaazul.robots.exception.handler;

import br.com.contaazul.robots.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RobotsExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> businessExceptionHandler() {
        return ResponseEntity.badRequest().body(String.format("%d %s", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase()));
    }

}
