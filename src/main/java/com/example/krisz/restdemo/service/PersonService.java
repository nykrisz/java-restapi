package com.example.krisz.restdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.krisz.restdemo.model.Person;
import com.example.krisz.restdemo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person create(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}
	
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	
	public Person update(String id, String firstName, String lastName, int age) {
		Person p = personRepository.findBy_id(id);
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		
		return personRepository.save(p);
	}
	
	public void deleteAll() {
		personRepository.deleteAll();
	}
	
	public void delete(String id) {
		Person p = personRepository.findBy_id(id);
		personRepository.delete(p);
	}
}
