package com.demo.spring.data.service;

import java.util.Optional;

import com.demo.spring.data.entity.Persona;

public interface DataServiceH2 {
	
	public Optional<Persona> getPersona(int id);
	
	public Persona setPersona(Persona persona);

	public Persona updatePersona(Persona persona);
	
	public void deletePersona(int id);
}
