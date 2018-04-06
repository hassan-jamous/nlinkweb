package com.nab.nlinkweb.controllers;


import com.nab.nlinkweb.domain.restdomain.Adviser;
import com.nab.nlinkweb.domain.restdomain.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/advisers")
public class AdviserController {

    @RequestMapping(method = DELETE, value = "/{adviserId}", headers = "API-VERSION=1")
    public ResponseEntity<Adviser> deleteAdviser(@PathVariable Long adviserId) {
        return new ResponseEntity<>(new Adviser(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = GET, value = "/{adviserId}", headers = "API-VERSION=1")
    public ResponseEntity<Adviser> loadAdviser(@PathVariable Long adviserId) {
        return Optional.of(new Adviser())
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = GET, value = "/{adviserId}/clients")
    public ResponseEntity<List<Client>> loadAdviserClients(@PathVariable Long adviserId) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client());
        clients.add(new Client());

        return new ResponseEntity<>(clients, HttpStatus.NOT_FOUND);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{adviserId}/clients/{clientId}")
    public ResponseEntity<Client> loadSingleAdviserClient(@PathVariable Long adviserId,
                                                          @PathVariable Long clientId,
                                                          @RequestHeader("API-VERSION") String version) {

        if (version.equals("1")) {

        } else {

        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{adviserId}/clients")
    public ResponseEntity<Client> addClientToAdviser(@PathVariable Long adviserId, @RequestBody Client c) {
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
