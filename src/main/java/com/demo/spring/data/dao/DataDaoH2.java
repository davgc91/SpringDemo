package com.demo.spring.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.demo.spring.data.entity.Persona;

public interface DataDaoH2 extends CrudRepository<Persona, Integer>{

}
