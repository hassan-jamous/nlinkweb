package com.nab.nlinkweb.exceptions;

public class UnexpectedResponseValueException extends RuntimeException {
    public UnexpectedResponseValueException() {
        super();
    }
    public UnexpectedResponseValueException(String s) {
        super(s);
    }
    public UnexpectedResponseValueException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public UnexpectedResponseValueException(Throwable throwable) {
        super(throwable);
    }
}
