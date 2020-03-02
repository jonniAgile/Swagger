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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "People management system", description = "Register system of people")
public class ServicePeople {
	private Map<Integer,Person> people;
	public ServicePeople() {
		people = new HashMap<>();		
	}
	@ApiOperation(value = "Add new person")
	@PutMapping("/put/{idPerson}")
	public Person putPerson(@ApiParam(value = "Number of identification", required = true) 
	@PathVariable int idPerson, @RequestBody Person person) {
		people.put(idPerson, person);
		return person;
	}
	@ApiOperation(value = "Get a person by Id")
	@GetMapping("/get")
	public Person getPerson(@ApiParam(value = "Number of identification stored in database", required = true) 
	@RequestParam("idPerson") int idPerson ) {
		return people.get(idPerson);
	}
	@ApiOperation(value = "Update available person")
	@PostMapping("/post")
	public Person postPerson(@RequestBody Person idPerson) {
		Random r = new Random();
		people.put(r.nextInt(), idPerson);
		return idPerson;
	}
	@ApiOperation(value = "Delete a person")
	@DeleteMapping("/delete/{idPerson}")
	public String deletePerson(@ApiParam(value = "Number Id from which person will delete from database", required = true)
	@PathVariable int idPerson){
		try {
			people.remove(idPerson);
		} catch (Exception e) {
			return "Error";
		}
		return "Successful";
	}	
}
