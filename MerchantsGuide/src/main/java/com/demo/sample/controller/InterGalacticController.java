package com.demo.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InterGalacticController {

	@GetMapping("/hello")
	public String sayHello() {
		System.out.println("Saying hello");
		return "Hello";
	}
}
