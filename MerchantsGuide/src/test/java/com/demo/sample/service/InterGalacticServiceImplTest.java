package com.demo.sample.service;

import static org.junit.Assert.assertEquals;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.sample.util.InterGalacticConverter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterGalacticServiceImplTest {
	private static final Logger LOGGER = Logger.getLogger(InterGalacticServiceImplTest.class.getName());

	private InterGalacticServiceImpl interGalacticServiceImpl;

	@MockBean
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
	}

	@After
	public void tearDown() throws Exception {
		this.interGalacticServiceImpl = null;
	}

	@Test
	public void testQueryMetalsAndDirts() {
		LOGGER.log(Level.INFO, "Test testQueryMetalsAndDirts");		

		Mockito.when(interGalacticConverter.romanToDecimal("XLII")).thenReturn(42);
		this.interGalacticServiceImpl.setInterGalacticConverter(this.interGalacticConverter);
		String response = interGalacticServiceImpl.queryMetalsAndDirts("how much is pish tegj glob glob ?");
		
		assertNotNull(response);
		assertEquals("pish tegj glob glob is 42", response);
	}
	
	@Test
	public void testQueryMetalsAndDirtsSilver() {
		LOGGER.log(Level.INFO, "Test testQueryMetalsAndDirtsSilver");		

		Mockito.when(interGalacticConverter.romanToDecimal("IV")).thenReturn(4);
		this.interGalacticServiceImpl.setInterGalacticConverter(this.interGalacticConverter);
		String response = interGalacticServiceImpl.queryMetalsAndDirts("how many Credits is glob prok Silver ?");
		
		assertNotNull(response);
		assertEquals("glob prok SILVER is 68 Credits", response);
	}
	
	@Test
	public void testQueryMetalsAndDirtsGold() {
		LOGGER.log(Level.INFO, "Test testQueryMetalsAndDirtsGold");		

		Mockito.when(interGalacticConverter.romanToDecimal("IV")).thenReturn(4);
		this.interGalacticServiceImpl.setInterGalacticConverter(this.interGalacticConverter);
		String response = interGalacticServiceImpl.queryMetalsAndDirts("how many Credits is glob prok Gold ?");
		
		assertNotNull(response);
		assertEquals("glob prok GOLD is 57800 Credits", response);
	}
	
	@Test
	public void testQueryMetalsAndDirtsIron() {
		LOGGER.log(Level.INFO, "Test testQueryMetalsAndDirtsIron");		

		Mockito.when(interGalacticConverter.romanToDecimal("IV")).thenReturn(4);
		this.interGalacticServiceImpl.setInterGalacticConverter(this.interGalacticConverter);
		String response = interGalacticServiceImpl.queryMetalsAndDirts("how many Credits is glob prok Iron ?");
		
		assertNotNull(response);
		assertEquals("glob prok IRON is 784 Credits", response);
	}

}
