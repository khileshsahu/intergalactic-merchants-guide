package com.demo.sample.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sample.model.AppRequest;
import com.demo.sample.model.AppResponse;
import com.demo.sample.service.InterGalacticService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@Api(value="intergalacticUnitConversion", description="Operations related to price of metals and dirts")
public class InterGalacticController {
	
	@Autowired
	private InterGalacticService interGalacticService;
	
	@ApiOperation(value = "Query for prices of gold and dirts",response = AppRequest.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Performed query successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@PostMapping(path="/query", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public AppResponse query(@RequestBody AppRequest request) {
		AppResponse appResponse = new AppResponse();
		String response = interGalacticService.queryMetalsAndDirts(request.getQuery());
		appResponse.setMessage(response);
		return appResponse;
	}
}
