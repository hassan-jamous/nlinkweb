package com.nab.nlinkweb.nonfunctional.interfaces;

import com.nab.nlinkweb.domain.restdomain.Adviser;
import com.nab.nlinkweb.domain.restdomain.Client;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


public interface AdviserFunctions {


    ResponseEntity<Adviser> deleteAdviser(String adviserId);

    @ApiOperation(value = "loadAdviser",response = Adviser.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    ResponseEntity<Adviser> loadAdviser(String adviserId);

    ResponseEntity<List<Client>> loadAdviserClients(Long adviserId);

    ResponseEntity<Client> loadSingleAdviserClient(Long adviserId,
                                                   Long clientId,
                                                   String version);

    ResponseEntity<Client> addClientToAdviser(Long adviserId, Client c);
}
