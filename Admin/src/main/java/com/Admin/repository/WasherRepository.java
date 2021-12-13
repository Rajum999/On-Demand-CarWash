package com.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Admin.Models.Washer;

public interface WasherRepository extends MongoRepository<Washer, Integer> {

}
