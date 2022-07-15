package com.johncarter.safeTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.johncarter.safeTravels.models.TravelExpense;

public interface TravelRepository extends CrudRepository<TravelExpense, Long>{
	//retrieves all the travels from the database
	List<TravelExpense> findAll();
}
