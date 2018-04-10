package com.nab.nlinkweb.nonfunctional.varification.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringVerification {
    public boolean isLongerThanX(String input, int requiredNumber) {
        return input.length() > requiredNumber;
    }
}
