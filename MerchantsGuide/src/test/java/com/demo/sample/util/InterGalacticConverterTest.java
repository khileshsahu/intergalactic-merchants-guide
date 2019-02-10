/**
 * 
 */
package com.demo.sample.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Khileshwar Sahu
 *
 */
@RunWith(SpringRunner.class)
public class InterGalacticConverterTest {
	
	private static final Logger LOGGER = Logger.getLogger( InterGalacticConverterTest.class.getName() );
	
	private InterGalacticConverter interGalacticConverter; 

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.interGalacticConverter = new InterGalacticConverter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.interGalacticConverter = null;
	}

	@Test
	public void testConvertRomanNumberToDecimal() {
		LOGGER.log(Level.FINE, "Test testConvertRomanNumberToDecimal {}", "MMVI");
		int response = interGalacticConverter.romanToDecimal("MMVI");
		
		assertNotNull(response);
		assertEquals(2006, response);
	}
	
	@Test
	public void testSmallerValuePrecedesLarger() {
		LOGGER.log(Level.FINE, "Test testSmallerValuePrecedesLarger {}", "MCMXLIV");
		int response = interGalacticConverter.romanToDecimal("MCMXLIV");
		
		assertNotNull(response);
		assertEquals(1944, response);
	}
	
	@Test
	public void testInterGalacticToRoman() {
		LOGGER.log(Level.FINE, "Test testInterGalacticToRoman {}", "PISH");
		String response = interGalacticConverter.interGalacticToRoman("PISH");
		
		assertNotNull(response);
		assertEquals("X", response);
	}
}
