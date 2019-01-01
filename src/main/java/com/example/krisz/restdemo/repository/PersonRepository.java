package com.example.krisz.restdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.krisz.restdemo.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String>{
	public Person findBy_id(String _id);
}
