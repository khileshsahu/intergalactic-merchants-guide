package com.demo.sample.service;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.sample.util.InterGalacticConverter;

@RunWith(SpringRunner.class)
public class InterGalacticServiceImplTest {
	private static final Logger LOGGER = Logger.getLogger(InterGalacticServiceImplTest.class.getName());

	private InterGalacticServiceImpl interGalacticServiceImpl;

	private InterGalacticConverter interGalacticConverter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.interGalacticServiceImpl = new InterGalacticServiceImpl();
		this.interGalacticConverter = new InterGalacticConverter();
	}

	@After
	public void tearDown() throws Exception {
		this.interGalacticServiceImpl = null;
		this.interGalacticConverter = null;
	}

	@Test
	public void testQueryMetalsAndDirts() {
		LOGGER.log(Level.INFO, "Test testQueryMetalsAndDirts");		

		Mockito.when(interGalacticConverter.romanToDecimal("XLII")).thenReturn(42);
		this.interGalacticServiceImpl.setInterGalacticConverter(this.interGalacticConverter);
		String response = interGalacticServiceImpl.queryMetalsAndDirts("how much is pish tegj glob glob ?");
		
		assertNotNull(response);
		System.out.println("------------------" + response);
	}

}
