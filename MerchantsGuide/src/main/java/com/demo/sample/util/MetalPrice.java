package com.demo.sample.util;

public enum MetalPrice {
	SILVER(17),
	GOLD(14450),
	IRON(196);
	
	private int value;
	
	public int getValue() {
		return this.value;
	}
	
	private MetalPrice(final int value) {
		this.value = value;
	}
}
