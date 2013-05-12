package com.mulesoft.tcm.model;

import java.util.List;

public class Release {

	
	public int id;
	public String name;
	public List<Iteration> iterations;
	
	int getId() {
		return id;
	}
	
	void setId(int id) {
		this.id = id;
	}
	
	String getName() {
		return name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	List<Iteration> getIterations() {
		return iterations;
	}
	
	void setIterations(List<Iteration> iterations) {
		this.iterations = iterations;
	}
}
