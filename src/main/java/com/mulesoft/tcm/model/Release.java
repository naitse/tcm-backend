package com.mulesoft.tcm.model;

import java.util.Date;
import java.util.List;

public class Release {

	
	public int id;
	public String name;
	public Date start;
	public Date end;
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
	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
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
