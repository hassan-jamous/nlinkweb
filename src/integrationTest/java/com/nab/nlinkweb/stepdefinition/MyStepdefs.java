package com.nab.nlinkweb.stepdefinition;

import com.nab.nlinkweb.Application;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyStepdefs {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @Then("^the client receives status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int statusCode) throws Throwable {
        assertEquals(statusCode, response.getStatusCodeValue());
    }

    @And("^the client receives server version hello$")
    public void theClientReceivesServerVersionHello() throws Throwable {
        assertEquals("INFOasdf3", response.getBody());
    }

    @When("^the client calls home page$")
    public void theClientCallsHomePage() throws Throwable {
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/",
                String.class);
    }

    @When("^the client calls soap test page$")
    public void theClientCallsSoapTestPage() throws Throwable {
        response = this.restTemplate.getForEntity("http://localhost:" + port + "/soapTest",
                String.class);
    }
}
