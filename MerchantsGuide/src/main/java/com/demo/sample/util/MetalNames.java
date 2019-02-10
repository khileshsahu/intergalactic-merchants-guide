package com.demo.sample.util;

public enum MetalNames {
	SILVER("SILVER"),
	GOLD("GOLD"),
	IRON("IRON");
	
	private String value;
	
	public String getValue() {
		return this.value;
	}
	
	private MetalNames(String value) {
		this.value = value;
	}
}
