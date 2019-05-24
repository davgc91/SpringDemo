package com.demo.spring.data.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.data.entity.Persona;
import com.demo.spring.data.service.DataServiceH2;

@RestController
@RequestMapping(value="/persona")
public class MainController {
	
	@Autowired
	DataServiceH2 dataServiceH2;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Persona> getPersona(@PathVariable int id) {
		Optional<Persona> response = dataServiceH2.getPersona(id);
		
		if(response.isPresent()) {
			return new ResponseEntity<Persona>(response.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}

	}
	

	@PostMapping(path="/set", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Persona setPersona(@RequestBody Persona persona) {
		
		Persona response = null;
		response = dataServiceH2.setPersona(persona);
		return response;
	}


	@PutMapping(path="/update", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
		
		Persona response = null;
		response = dataServiceH2.updatePersona(persona);
		if(response != null) {
			return new ResponseEntity<Persona>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Persona> deletePersona(@PathVariable int id) {
		
		dataServiceH2.deletePersona(id);
		return new ResponseEntity<Persona>(HttpStatus.OK);
	}


}
