package com.demo.spring.data.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.data.dao.DataDaoH2;
import com.demo.spring.data.entity.Persona;
import com.demo.spring.data.service.DataServiceH2;

@Service
public class DataServiceH2Impl implements DataServiceH2 {
	
	@Autowired
	DataDaoH2 dataDaoH2;

	@Override
	public Optional<Persona> getPersona(int id) {
	
		Optional<Persona> response = dataDaoH2.findById(id);
		return response;
	}

	@Override
	public Persona setPersona(Persona persona) {
		Persona response = dataDaoH2.save(persona);
		return response;
	}

	@Override
	public Persona updatePersona(Persona persona) {
		Persona res = null;
		Optional<Persona> response = dataDaoH2.findById(persona.getIdPersona());
		if(response.isPresent()) {
			res = dataDaoH2.save(persona);
		}
		return res;
	}

	@Override
	public void deletePersona(int id) {
		dataDaoH2.deleteById(id);
	}

}
