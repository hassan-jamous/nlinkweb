package com.nab.nlinkweb.cucumber.configuration;

import com.nab.nlinkweb.cucumber.factory.Factory;
import com.nab.nlinkweb.cucumber.interfaces.TestPreparation;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/integrationTest/resources",
        glue = "com.nab.nlinkweb.stepdefinition")
public final class CucumberTest {
    private static TestPreparation testPreparation = Factory.giveMeTestPreparation(getCucumberTag());

    private CucumberTest() {

    }

    public static String getCucumberTag() {
        return System.getProperties().getProperty("cucumber.options").replaceAll(".*@", "");
    }

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
