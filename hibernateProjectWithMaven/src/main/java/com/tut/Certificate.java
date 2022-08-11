package com.tut;

import javax.persistence.Embeddable;

/*
 * This is a class which has two field 
 * Any class uses this class's object then both field will be added in that class's table
 * */
@Embeddable
public class Certificate {

	private String cource;
	private String duration;
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certificate(String cource, String duration) {
		super();
		this.cource = cource;
		this.duration = duration;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
