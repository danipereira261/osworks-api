package com.algaworks.osworks.api.handler;

import com.algaworks.osworks.api.exception.ClientNotFoundException;
import com.algaworks.osworks.api.exception.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErroResponse> clientNotFound(ClientNotFoundException e) {

        //new e set
        //ErroResponse er = new ErroResponse();
        //er.setMessage(e.getMessage());

        //new injetando construtor
        //ErroResponse er2 = new ErroResponse(e.getMessage());

        //return new ResponseEntity<>(new ErroResponse(e.getMessage()), HttpStatus.NOT_FOUND);

        //Retorno de um Builder de um objeto
        return new ResponseEntity<>(
                ErroResponse
                        .builder()
                        .message(e.getMessage())
                        .build(),
                HttpStatus.NOT_FOUND);
    }
}



