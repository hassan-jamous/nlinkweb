package com.nab.nlinkweb.cucumber;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/integrationTest/resources", tags = "@Component",
        glue = "com.nab.nlinkweb.stepdefinition.component")
public class CucumberComponentTest {
}
