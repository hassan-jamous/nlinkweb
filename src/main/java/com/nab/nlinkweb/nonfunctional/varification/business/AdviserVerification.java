package com.nab.nlinkweb.nonfunctional.varification.business;


import com.nab.nlinkweb.domain.restdomain.Adviser;
import com.nab.nlinkweb.nonfunctional.exceptions.VerificationException;

public class AdviserVerification {
    public boolean verifyAdviserInformation (Adviser adviser) {
        if (adviser.getFirstName() == null) {
            throw new VerificationException();
        }
        return true;
    }
}
