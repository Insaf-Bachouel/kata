package com.bank.kata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = InvalidAmountException.class)
    public ResponseEntity<String> invalidAmountException(InvalidAmountException invalidAmountException) {
        return new ResponseEntity<String>("Not a valid amount", HttpStatus.BAD_REQUEST);
    }
    
	@ExceptionHandler(value = NotEnoughFundsException.class)
    public ResponseEntity<String> invalidAmountException(NotEnoughFundsException notEnaughFunds) {
        return new ResponseEntity<String>("Not enaough funds in the account", HttpStatus.BAD_REQUEST);
    }
}
