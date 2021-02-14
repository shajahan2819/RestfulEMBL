package com.embl.RestfulEmbl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embl.RestfulEmbl.exception.ResourceNotFoundException;
import com.embl.RestfulEmbl.model.Person;
import com.embl.RestfulEmbl.repository.PersonRepository;

import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiOperation(value = "/api/v1/persons", tags = "Person Controller")
@RestController
@RequestMapping("api/v1")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@ApiOperation(value = "Fetch all Persons", response = Iterable.class)
	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
	
	@ApiOperation(value = "Get Person by ID", response = Person.class)
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		return ResponseEntity.ok().body(person);
	}

	@ApiOperation(value = "Insert Person Record", response = Person.class)
	@PostMapping("/persons")
	public Person createPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@ApiOperation(value = "Update Person Record", response = Person.class)
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId, @RequestBody Person personDetails) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		person.setFirstName(personDetails.getFirstName());
		person.setLastName(personDetails.getLastName());
		person.setAge(personDetails.getAge());
		person.setFavouriteColour(personDetails.getFavouriteColour());
		final Person updatedPerson = personRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
	}
	
	@ApiOperation(value = "Remove a Person", response = Person.class)
	@DeleteMapping("/persons/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)	throws ResourceNotFoundException {
		Person person = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		personRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
