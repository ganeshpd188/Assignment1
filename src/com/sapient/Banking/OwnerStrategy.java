package com.sapient.Banking;

public interface OwnerStrategy {
	boolean isForeign();
	int fee();
	String toString();
	}