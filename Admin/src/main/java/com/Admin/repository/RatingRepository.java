package com.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Admin.Models.Ratings;

public interface RatingRepository extends MongoRepository<Ratings, Integer> {

}
