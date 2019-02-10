package com.demo.sample.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = InterGalacticController.class, secure = false)
public class InterGalacticControllerTest {
	
	private static final Logger LOGGER = Logger.getLogger( InterGalacticControllerTest.class.getName() );
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testInterGalacticController() {
		LOGGER.log(Level.FINE, "Creating InterGalacticController");
		new InterGalacticController();
	}

}
