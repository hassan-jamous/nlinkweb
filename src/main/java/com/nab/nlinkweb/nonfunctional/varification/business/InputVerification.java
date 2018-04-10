package com.nab.nlinkweb.nonfunctional.varification.business;


import com.nab.nlinkweb.nonfunctional.exceptions.InputValidationException;
import com.nab.nlinkweb.nonfunctional.varification.util.StringVerification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InputVerification {
    public void verifyRequestInput(String input) {
        if (StringVerification.isLongerThanX(input, 5)) {
            throw new InputValidationException();
        }
    }
}
