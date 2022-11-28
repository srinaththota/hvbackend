package com.universitywest.assignment.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.universitywest.assignment.backend.entity.Person;
import com.universitywest.assignment.backend.entity.Tour;
import com.universitywest.assignment.backend.service.PersonService;
import com.universitywest.assignment.backend.service.TourService;

@RestController
public class TourController {

	@Autowired
	TourService tourService;
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(value="/addtour",method=RequestMethod.POST)
	public String addTour(@RequestBody Tour tour) {
	System.out.println("Reached here");
		int id=tour.getPerson().getId();
		System.out.println("id is "+id);
		Person person=personService.findById(id);
		tour.setPerson(person);
		tourService.saveTour(tour);
		
		return "success";
	}
}
