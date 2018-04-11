package com.nab.nlinkweb.cucumber.configuration;
import com.nab.nlinkweb.cucumber.factory.Factory;
import com.nab.nlinkweb.cucumber.interfaces.TestPreparation;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/integrationTest/resources", tags = "@Component",
        glue = "com.nab.nlinkweb.stepdefinition")
public class CucumberComponentTest {

    public static TestPreparation testPreparation = Factory.giveMeTestPreparation("Component");

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
