package com.universitywest.assignment.backend.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="persons", cascade=CascadeType.ALL)
	private Collection<Tour> tours=new ArrayList<>();
	
	
	public Person() {
		super();
	}
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Collection<Tour> getTours() {
		return tours;
	}
	public void setTours(Collection<Tour> tours) {
		this.tours = tours;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
