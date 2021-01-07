package br.com.project.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.springboot.model.Person;
import br.com.project.springboot.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping("/{id}")
	public Person findbyId(@PathVariable("id") Long id) {		
		return service.findById(id);	
	}
		
	@GetMapping
	public List<Person> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {		
		return service.create(person);
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) {		
		return service.update(person);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
}