package com.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Admin.Models.Admin;

public interface AdminRepository extends MongoRepository<Admin, Integer> {

}
