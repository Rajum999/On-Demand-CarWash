package com.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Admin.Models.WashPacks;

public interface WashPackRepository extends MongoRepository<WashPacks, Integer> {

}
