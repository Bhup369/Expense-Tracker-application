package com.mongo.tech.springbootmongodbtutorial.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mongo.tech.springbootmongodbtutorial.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense,String> {
	
	@Query("{'name': ?0}")
	public Optional<Expense> findByName(String name);
}
