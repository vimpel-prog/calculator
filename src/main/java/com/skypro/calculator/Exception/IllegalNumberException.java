package com.skypro.calculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST) 
public class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String s) {
        super(s);
    }
}
