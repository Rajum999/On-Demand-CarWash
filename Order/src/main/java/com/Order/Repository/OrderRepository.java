package com.Order.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Order.Model.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}