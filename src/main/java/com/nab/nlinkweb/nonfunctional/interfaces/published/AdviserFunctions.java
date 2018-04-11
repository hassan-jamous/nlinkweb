package com.nab.nlinkweb.nonfunctional.interfaces.published;

import com.nab.nlinkweb.domain.restdomain.Adviser;
import com.nab.nlinkweb.domain.restdomain.Client;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdviserFunctions {


    ResponseEntity<Adviser> deleteAdviser(String adviserId);

    @ApiOperation(value = "loadAdviser", response = Adviser.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = "Successfully retrieved list"),
    }
    )
    ResponseEntity<Adviser> loadAdviser(String adviserId);

    ResponseEntity<List<Client>> loadAdviserClients(Long adviserId);

    ResponseEntity<Client> loadSingleAdviserClient(Long adviserId,
                                                   Long clientId,
                                                   String version);

    ResponseEntity<Client> addClientToAdviser(Long adviserId, Client c);
}
