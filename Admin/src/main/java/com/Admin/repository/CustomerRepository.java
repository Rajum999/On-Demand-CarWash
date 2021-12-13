package com.Admin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Admin.Models.Customer;


public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}
