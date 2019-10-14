package com.cartorgon.drsbe.model;

public interface Beverage {
	long getId();
	void setId(long id);
	String getName();
	void setName(String name);
	int getGraduation();
	void setGraduation(int graduation);
}