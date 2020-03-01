package com.example.swagger.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.Person;

@RestController
public class ServicePeople {
	private Map<Integer,Person> people;
	public ServicePeople() {
		people = new HashMap<>();		
	}
	@PutMapping("/put/{idPerson}")
	public Person putPerson(@PathVariable int idPerson, @RequestBody Person person) {
		people.put(idPerson, person);
		return person;
	}
	@GetMapping("/get")
	public Person getPerson(@RequestParam("idPerson") int idPerson ) {
		return people.get(idPerson);
	}
	@PostMapping("/post")
	public Person postPerson(@RequestBody Person idPerson) {
		Random r = new Random();
		people.put(r.nextInt(), idPerson);
		return idPerson;
	}
	@DeleteMapping("/delete/{idPerson}")
	public String deletePerson(@PathVariable int idPerson){
		try {
			people.remove(idPerson);
		} catch (Exception e) {
			return "Error";
		}
		return "Successful";
	}
	
}
