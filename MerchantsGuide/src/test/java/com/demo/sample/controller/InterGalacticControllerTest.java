package com.demo.sample.controller;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.sample.service.InterGalacticService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = InterGalacticController.class, secure = false)
public class InterGalacticControllerTest {

	private static final Logger LOGGER = Logger.getLogger(InterGalacticControllerTest.class.getName());

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InterGalacticService interGalacticService;
	

	@Test
	public void testInterGalacticController() throws Exception {
		LOGGER.log(Level.FINE, "Creating InterGalacticController");
		String query = "how many Credits is glob prok Silver ?";
		String requestJson = "{\"query\":\"how many Credits is glob prok Silver ?\"}";
		String response = "{\"message\":\"glob prok SILVER is 68 Credits\"}";
		
		Mockito.when(interGalacticService.queryMetalsAndDirts(query)).thenReturn(response);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/query").accept(
				MediaType.APPLICATION_JSON).content(requestJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		LOGGER.log(Level.INFO, result.getResponse().getContentAsString());
		assertNotNull(result);
	}

}
