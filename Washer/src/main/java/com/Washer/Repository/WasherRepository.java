package com.Washer.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Washer.Model.Washer;

public interface WasherRepository extends MongoRepository<Washer, Integer> {

}