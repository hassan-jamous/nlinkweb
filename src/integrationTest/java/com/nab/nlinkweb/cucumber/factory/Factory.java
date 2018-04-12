package com.nab.nlinkweb.cucumber.factory;


import com.nab.nlinkweb.cucumber.component.ComponentTestPreparation;
import com.nab.nlinkweb.cucumber.component.IntegrationTestPreparation;
import com.nab.nlinkweb.cucumber.interfaces.TestPreparation;

public final class Factory {

    private Factory() {

    }
    public static TestPreparation giveMeTestPreparation(String tag) {
        if (tag.equals("Integration")) {
            return new IntegrationTestPreparation();
        } else if (tag.equals("Component")) {
            return new ComponentTestPreparation();
        } else {
            throw new RuntimeException("We accept Integration or Component, Wrong input to factory");
        }
    }
}
