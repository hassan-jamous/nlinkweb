package com.nab.nlinkweb.cucumber.configuration;
import com.nab.nlinkweb.cucumber.factory.Factory;
import com.nab.nlinkweb.cucumber.interfaces.TestPreparation;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.Enumeration;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/integrationTest/resources",
        glue = "com.nab.nlinkweb.stepdefinition")
public class CucumberTest {

    public static String getCucumberTag(){
        return System.getProperties().getProperty("cucumber.options").replaceAll(".*@","");
    }
    public static TestPreparation testPreparation = Factory.giveMeTestPreparation(getCucumberTag());

    @BeforeClass
    public static void prepare() {
        testPreparation.prepareTestData();
        testPreparation.initializeTest();
    }

    @AfterClass
    public static void end() {
        testPreparation.endTest();
    }
}
