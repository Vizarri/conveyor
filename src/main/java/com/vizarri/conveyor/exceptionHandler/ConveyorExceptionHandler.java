package com.vizarri.conveyor.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConveyorExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<ConveyorException> conveyorBasicHandleException(ConveyorException conveyorException){
        ConveyorException exception = new ConveyorException();
        exception.setInfo(conveyorException.getInfo());
        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }
}
