package com.universitywest.assignment.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universitywest.assignment.backend.dao.PersonDao;
import com.universitywest.assignment.backend.entity.Person;
import com.universitywest.assignment.backend.entity.Tour;
import com.universitywest.assignment.backend.repo.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonDao personDao;
	
	@Autowired
	TourService tourService;
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> findAll(){
		return personDao.findAll();
	}
	
	public Person findById(int id) {
		return personDao.findById(id);
	}
	
	public int deleteById(int id) {
		return personDao.deleteById(id);
	}
	
	public int insertPerson(Person person) {
		return personDao.insert(person);
	}
	
	public int updatePerson(Person person) {
		return personDao.update(person);
	}
	
	public Person savePerson(Person person) {
		
		Person newPerson=new Person();
		newPerson.setName(person.getName());
		
		newPerson.getTours()
		.addAll(person
				.getTours()
				.stream()
				.map(t->{
					Tour t1=tourService.findById(t.getId());
					System.out.println(t1.getName());
					t1.getPersons().add(newPerson);
					return t1;
				}).collect(Collectors.toList())
				);
				
		return personRepository.save(newPerson);
		
	}
}
