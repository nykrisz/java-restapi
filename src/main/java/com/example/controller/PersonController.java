package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@RestController
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public Person createPerson(@Valid @RequestBody Person person) {
		person.setId(ObjectId.get().toHexString());
		personRepository.save(person);
		return person;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable("id") String id) {
		return personRepository.findBy_id(id);
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable("id") String id, @Valid @RequestBody Person person) {
		person.setId(id);
		personRepository.save(person);
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		personRepository.delete(personRepository.findBy_id(id));
	}
	
	@RequestMapping("/deleteAll")
	public void deleteAll() {
		personRepository.deleteAll();
	}
}
