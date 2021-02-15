package com.embl.RestfulEmbl.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.embl.RestfulEmbl.exception.ResourceNotFoundException;
import com.embl.RestfulEmbl.model.Person;
import com.embl.RestfulEmbl.repository.PersonRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PersonControllerTest {

	@Autowired
	PersonController personController;

	@Mock
	PersonRepository personRepository;

	@Test
	void testGetAllPersons() {

		List<Person> list = new ArrayList<Person>();

		list.add(new Person(new Long("1"), "Mohamed", "Shajahan", "Green", 35));
		list.add(new Person(new Long("2"), "Rosie", "Binns", "Red", 37));
		list.add(new Person(new Long("3"), "John", "Wakefield", "Blue", 35));

		when(personRepository.findAll()).thenReturn(list);

		List<Person> personList = personController.getAllPersons();

		assertEquals(3, personList.size());

	}

	@Test
	void testGetPersonById() throws NumberFormatException, ResourceNotFoundException {

		when(personRepository.findById(new Long("1")))
				.thenReturn(Optional.of(new Person(new Long("1"), "Mohamed", "Shajahan", "Green", 35)));

		ResponseEntity<Person> person = personController.getPersonById(new Long("1"));

		assertEquals("Mohamed", person.getBody().getFirstName());
		assertEquals("Shajahan", person.getBody().getLastName());
		assertEquals("Green", person.getBody().getFavouriteColour());
		assertEquals(35, person.getBody().getAge());

	}

	@Test
	void testCreatePerson() {
		Person person = new Person(1, "Mohamed", "Shajahan", "Green", 35);
		assertEquals(person, personController.createPerson(person));
		
	}

	@Test
	void testUpdatePerson() throws NumberFormatException, ResourceNotFoundException {

		when(personRepository.findById(new Long("1"))).thenReturn(Optional.of(new Person(new Long("1"), "Mohamed", "Shajahan", "Green", 35)));

		ResponseEntity<Person> person = personController.getPersonById(new Long("1"));
		person.getBody().setFirstName("Kevin");
		
		assertEquals(person, personController.updatePerson(new Long("1"),person.getBody()));
		
	}

	@Test
	void testDeletePerson() {
		
		when(personRepository.findById(new Long("1"))).thenReturn(Optional.of(new Person(new Long("1"), "Mohamed", "Shajahan", "Green", 35)));

		try {
			ResponseEntity<Person> person = personController.getPersonById(new Long("1"));
						
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			System.out.println(response);
			assertEquals(response, personController.deletePerson(new Long("1")));
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
