package com.Customer.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.Customer.Model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer>{

}
