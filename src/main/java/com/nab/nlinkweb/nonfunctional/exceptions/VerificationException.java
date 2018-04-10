package com.nab.nlinkweb.nonfunctional.exceptions;

public class VerificationException extends RuntimeException {
    public VerificationException() {
        super();
    }
    public VerificationException(String s) {
        super(s);
    }
    public VerificationException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public VerificationException(Throwable throwable) {
        super(throwable);
    }
}
