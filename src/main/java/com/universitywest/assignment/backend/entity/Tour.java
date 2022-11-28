package com.universitywest.assignment.backend.entity;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tour {

	@Id
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	private Person person;
	public Person getPerson() {
		return person;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Person_Tour")
	private Collection<Person> persons=new ArrayList<>();
	
	
	public Collection<Person> getPersons() {
		return persons;
	}
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	public Tour() {
		super();
	}

	public Tour(int id, String name,Person person) {
		super();
		this.id = id;
		this.name = name;
		this.person=person;
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
