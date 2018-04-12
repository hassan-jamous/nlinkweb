package com.nab.nlinkweb.cucumber.component;


import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.nab.nlinkweb.cucumber.interfaces.TestPreparation;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class ComponentTestPreparation implements TestPreparation {
    private static WireMockServer wireMockServer;

    @Override
    public void prepareTestData() {

    }

    @Override
    public void initializeTest() {
        wireMockServer = new WireMockServer(wireMockConfig()
                .port(8089)
                .httpsPort(8443)
                .notifier(new ConsoleNotifier(true)));

        wireMockServer.start();
        configureFor("localhost", wireMockServer.port());
        stubFor(post(urlEqualTo("/stockquote.asmx"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));

    }

    @Override
    public void endTest() {
        wireMockServer.stop();
    }
}
