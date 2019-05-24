package com.demo.spring.test;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.spring.data.dao.DataDaoH2;
import com.demo.spring.data.entity.Persona;
import com.demo.spring.data.service.impl.DataServiceH2Impl; 

@RunWith(SpringJUnit4ClassRunner.class)
public class MockitoTest {

	@InjectMocks
	DataServiceH2Impl dataServiceH2;
	
	@Mock
	DataDaoH2 dataDaoH2;
	
	@Test
	public void getPersonaTest() {
		dataServiceH2.getPersona(1);
		verify(dataDaoH2).findById(1);
	}
	
	@Test
	public void setPersonaTest() {
		Persona p = new Persona();
		p.setIdPersona(6);
		p.setNombre("Nombre Test");
		p.setSexo("F");
		p.setNacionalidad("MX");
		p.setFechaNacimiento(new Date());
		p.setTelefono("5547136984");
		p.setEmail("email@email.com");
		dataServiceH2.setPersona(p);
		verify(dataDaoH2).save(p);
	}
	
	@Test
	public void updatePersonaTest() {
		Persona p = new Persona();
		p.setIdPersona(6);
		p.setNombre("Nombre Test Updated");
		p.setSexo("F");
		p.setNacionalidad("MX");
		p.setFechaNacimiento(new Date());
		p.setTelefono("5547136984");
		p.setEmail("email@email.com");
		dataServiceH2.updatePersona(p);
	}
	
	@Test
	public void deletePersonaTest() {
		dataServiceH2.deletePersona(6);
		verify(dataDaoH2).deleteById(6);
	}
	
}
