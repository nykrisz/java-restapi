package com.example.krisz.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.krisz.restdemo.model.Person;
import com.example.krisz.restdemo.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
		Person p = personService.create(firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String firstName) {
		return personService.getByFirstName(firstName); 
	}
	
	@RequestMapping("/getAll")
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam String id, @RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
		Person p = personService.update(id,firstName, lastName, age);
		return p.toString();
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		personService.delete(id);
		return "User Deleted";
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "All records has been deleted";
	}
}
