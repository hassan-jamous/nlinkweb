package com.nab.nlinkweb.nonfunctional.interfaces.published;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.http.HttpStatus;

public interface GeneralFunction {

    @ApiOperation(value = "View a list of available products", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = "Successfully retrieved list")
    })
    String home();

    double soap();

    double hystrix();

    double exception();
}
