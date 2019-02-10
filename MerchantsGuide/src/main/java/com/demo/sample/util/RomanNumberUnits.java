package com.demo.sample.util;

public enum RomanNumberUnits {
	
	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000);
	
	private int value;
	
	public int getValue() {
		return this.value;
	}
	
	private RomanNumberUnits(int value) {
		this.value = value;
	}

}
