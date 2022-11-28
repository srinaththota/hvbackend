package com.universitywest.assignment.backend.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.universitywest.assignment.backend.entity.Person;

import aj.org.objectweb.asm.Type;

@Repository
public class PersonDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Person> findAll(){
		
		return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper(Person.class));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Person findById(int id){
		return (Person) jdbcTemplate.queryForObject("select * from Person where id=?", new Object[] {id}, new BeanPropertyRowMapper(Person.class));
	}
	
	
	public int deleteById(int id){
		return  jdbcTemplate.update("delete from Person where id=?", new Object[] {id});
	}
	
	public int insert(Person person){
		int count = jdbcTemplate.queryForObject("select count(*) from Person", Integer.class);
		System.out.println("count in the table is "+count);
		count++;
		return  jdbcTemplate.update("insert into Person(id,name)"+" values(?,?)", new Object[] {count,person.getName()});
	}
	
	public int update(Person person){
		System.out.println("checjing here "+person.getName());
		return  jdbcTemplate.update("update Person set name=? where id=?", new Object[] {person.getName(),person.getId()});
	}
	
	
	
}
