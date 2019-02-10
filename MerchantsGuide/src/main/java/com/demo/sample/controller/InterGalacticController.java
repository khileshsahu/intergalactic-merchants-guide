package com.demo.sample.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sample.model.AppRequest;
import com.demo.sample.model.AppResponse;
import com.demo.sample.service.InterGalacticService;

@RestController
@RequestMapping("/api")
public class InterGalacticController {
	
	@Autowired
	private InterGalacticService interGalacticService;
	
	@PostMapping(path="/query", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public AppResponse query(@RequestBody AppRequest request) {
		AppResponse appResponse = new AppResponse();
		String response = interGalacticService.queryMetalsAndDirts(request.getQuery());
		appResponse.setMessage(response);
		return appResponse;
	}
}
