package com.nab.nlinkweb.nonfunctional.exceptions;

public class InputValidationException extends RuntimeException {
    public InputValidationException() {
        super();
    }
    public InputValidationException(String s) {
        super(s);
    }
    public InputValidationException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public InputValidationException(Throwable throwable) {
        super(throwable);
    }
}