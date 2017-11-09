package com.diegolirio.robotonmars.apis.v1.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RobotControllerApiRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value=Exception.class)
    protected ResponseEntity<?> handle500(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Ocorreu um erro ao utilizar o serviço, por favor tente novamente mais tarde!";
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

}
