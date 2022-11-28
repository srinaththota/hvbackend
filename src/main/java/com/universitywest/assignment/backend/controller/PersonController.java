package com.universitywest.assignment.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.universitywest.assignment.backend.entity.Person;
import com.universitywest.assignment.backend.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getAllPersons(){
		return personService.findAll();
	}
	
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable String id) {
		System.out.println(id);
		return personService.findById(Integer.parseInt(id));
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable int id) {
		personService.deleteById(id);
		return "Person has been deleted successfully";
	}
	
	@RequestMapping(value = "/addperson", method = RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Person person) {
		
		personService.insertPerson(person);
		return "Person has been inserted successfully";
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestBody Person person) {
		
		personService.updatePerson(person);
		return "Person has been Updated successfully";
	}
	
	@RequestMapping(value = "/saveperson", method = RequestMethod.POST)
	@ResponseBody
	public String save(@RequestBody Person person) {
		System.out.println(person.getName());
		System.out.println(person.getTours());
		personService.savePerson(person);
		return "Person has been saved successfully";
	}
	
	
}
