package br.com.project.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.project.springboot.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {	
	
	@GetMapping("/{id}")
	public Person findbyId(@PathVariable("id") Long id) {		
		return new Person();	
	}
		
	@GetMapping
	public List<Person> findAll() {
		List<Person> listPerson = new ArrayList<Person>();
		return listPerson;
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {		
		return new Person();
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) {		
		return new Person();		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		
	}
	
}