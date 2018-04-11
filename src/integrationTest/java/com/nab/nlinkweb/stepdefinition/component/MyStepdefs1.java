package com.nab.nlinkweb.stepdefinition.component;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.nab.nlinkweb.Application;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MyStepdefs1 {

    @Autowired
    private MockMvc mockMvc;

    WireMockServer x = new WireMockServer(wireMockConfig()
            .port(8089)
            .httpsPort(8443)
            .notifier(new ConsoleNotifier(true)));


    ResultActions resultActions;



    @When("^the client calls /")
    public void theClientCallsBaeldung() throws Throwable {
        x.start();
        configureFor("localhost",x.port());
        stubFor(post(urlEqualTo("/stockquote.asmx"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));
        resultActions = this.mockMvc.perform(get("/soapTest"));
        x.stop();
    }

    @Then("^the client receives status code of (\\d+)$")
    public void theClientReceivesStatusCodeOf(int arg0) throws Throwable {
        resultActions.andExpect(status().isOk());

    }

    @And("^the client receives server version hello$")
    public void theClientReceivesServerVersionHello() throws Throwable {
        resultActions.andExpect(content().string(containsString("asdf3")));

    }

}
