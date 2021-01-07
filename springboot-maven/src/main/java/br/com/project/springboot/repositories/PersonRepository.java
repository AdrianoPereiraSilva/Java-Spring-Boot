package br.com.project.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.project.springboot.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
