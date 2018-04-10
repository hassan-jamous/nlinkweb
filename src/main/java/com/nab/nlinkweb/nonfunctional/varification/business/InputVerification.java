package com.nab.nlinkweb.nonfunctional.varification.business;


import com.nab.nlinkweb.nonfunctional.exceptions.InputValidationException;
import com.nab.nlinkweb.nonfunctional.varification.util.StringVerification;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InputVerification {

    public static final int STRING_LENGTH = 10;

    public void verifyRequestInput(String input) {
        if (StringVerification.isLongerThanX(input, STRING_LENGTH)) {
            throw new InputValidationException();
        }
    }
}
