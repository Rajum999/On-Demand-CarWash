package com.Admin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Admin.Models.Ratings;
import com.Admin.repository.RatingRepository;

public class RatingService {
	
	@Autowired
	RatingRepository ratingRepository;
	
	public String saverating(Ratings rating) {
		ratingRepository.save(rating);
		return " Thanks for Your Valuable feedback";
	
	}


	public List<Ratings> getuser() {
		
		return ratingRepository.findAll();
	}


}
