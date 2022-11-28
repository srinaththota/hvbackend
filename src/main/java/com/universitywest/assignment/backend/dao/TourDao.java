package com.universitywest.assignment.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.universitywest.assignment.backend.entity.Person;
import com.universitywest.assignment.backend.entity.Tour;

@Repository
public class TourDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insert(Tour tour){
		int count = jdbcTemplate.queryForObject("select count(*) from Tour", Integer.class);
		System.out.println("count in the table is "+count);
		count++;
		return  jdbcTemplate.update("insert into Tour(id,name,person_id)"+" values(?,?,?)", new Object[] {count,tour.getName(),tour.getPerson().getId()});
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public Tour findById(int id){
		return (Tour) jdbcTemplate.queryForObject("select * from Tour where id=?", new Object[] {id}, new BeanPropertyRowMapper(Tour.class));
	}
}
