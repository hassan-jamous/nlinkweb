package com.nab.nlinkweb.cucumber.configuration;

import com.nab.nlinkweb.cucumber.component.CommonObjects;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class GlobalHooks {
    @Autowired
    private CommonObjects commonObjects;

    @Before
    public void beforeAll() {
        commonObjects.reInitialize();
    }
}
