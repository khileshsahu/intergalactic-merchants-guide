package com.demo.sample.util;

import org.springframework.stereotype.Service;

@Service("interGalacticConverter")
public class InterGalacticConverter {

	public int romanToDecimal(String numStr) {
		int result = 0;

		for (int i = 0; i < numStr.length(); i++) {
			int num1 = decimalValue(numStr.charAt(i));

			if (i + 1 < numStr.length()) {
				int num2 = decimalValue(numStr.charAt(i + 1));

				if (num1 >= num2) {
					result = result + num1;
				} else {
					result = result + num2 - num1;
					i++;
				}
			} else {
				result = result + num1;
				i++;
			}
		}

		return result;
	}
	
	public String interGalacticToRoman(String igStr) {
		return romanValue(igStr);
	}
	
	private int decimalValue(char romanChar) {		
		switch(romanChar) {
		case 'I':
			return RomanNumberUnits.I.getValue();
		case 'V':
			return RomanNumberUnits.V.getValue();
		case 'X':
			return RomanNumberUnits.X.getValue();
		case 'L':
			return RomanNumberUnits.L.getValue();
		case 'C':
			return RomanNumberUnits.C.getValue();
		case 'D':
			return RomanNumberUnits.D.getValue();
		case 'M':
			return RomanNumberUnits.M.getValue();
		default:
			return -1;
		}
	}
	
	private String romanValue(String igStr) {
		switch(igStr.toUpperCase()) {
		case "GLOB":
			return InterGalacticUnits.GLOB.getValue();
		case "PROK":
			return InterGalacticUnits.PROK.getValue();
		case "PISH":
			return InterGalacticUnits.PISH.getValue();
		case "TEGJ":
			return InterGalacticUnits.TEGJ.getValue();
		default:
			return null;
		}
	}

}
