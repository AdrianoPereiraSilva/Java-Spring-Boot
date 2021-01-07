package br.com.project.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.project.springboot.model.Person;
import br.com.project.springboot.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
		
	public Person create (Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		
		Person personReturn = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No Records for this ID!"));
		
		personReturn.setFirstName(person.getFirstName());
		personReturn.setLastName(person.getLastName());
		personReturn.setAddress(person.getAddress());
		personReturn.setGender(person.getGender());
		
		repository.save(personReturn);
		
		return personReturn;
	}
	
	public void delete(Long id) {
		Person personReturn = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records for this ID!"));		
		repository.delete(personReturn);
	}

	public Person findById(Long id) {		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Records for this ID!"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();		
	}
	
}
