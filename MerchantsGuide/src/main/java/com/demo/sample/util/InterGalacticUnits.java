package com.demo.sample.util;

public enum InterGalacticUnits {
	GLOB("I"),
	PROK("V"),
	PISH("X"),
	TEGJ("L");
	
	private String value;
	
	public String getValue() {
		return this.value;
	}
	
	private InterGalacticUnits(String value) {
		this.value = value;
	}
}
