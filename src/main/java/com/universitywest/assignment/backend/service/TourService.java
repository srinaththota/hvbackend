package com.universitywest.assignment.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universitywest.assignment.backend.dao.TourDao;
import com.universitywest.assignment.backend.entity.Tour;

@Service
public class TourService {

	@Autowired
	TourDao tourDao;
	
	public String saveTour(Tour tour) {
		
		tourDao.insert(tour);
		return "Success";
	}
	
	public Tour findById(int id) {
		return tourDao.findById(id);
	}
}
