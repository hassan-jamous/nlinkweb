package com.nab.nlinkweb.stepdefinition.integration;

import com.nab.nlinkweb.Application;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@SpringBootTest
public class MyStepdefs {
    @When("^the client calls /endpoint1")
    public void theClientCallsBaeldung() throws Throwable {
        System.out.println("asdf");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int arg0) throws Throwable {
        System.out.print("asdfasdfasfd");

    }

    @And("^the client receives server version hello$")
    public void theClientReceivesServerVersionHello() throws Throwable {
        System.out.print("asdfasdfasfd");

    }


}
