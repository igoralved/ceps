package com.example.acessingdatajpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CEPRepository extends CrudRepository<CEP, Long> {

	CEP findByCampo(String campo);
	
}
