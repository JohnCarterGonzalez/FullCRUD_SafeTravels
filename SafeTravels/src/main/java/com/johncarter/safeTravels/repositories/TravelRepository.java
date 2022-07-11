package com.johncarter.safeTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.johncarter.safeTravels.models.Travel;

public interface TravelRepository extends CrudRepository<Travel, Long>{
	//retrieves all the travels form the database
	List<Travel> findAll();
	
	//this method finds travels with descriptions containing the search string
	List<Travel> findByDescriptionContaining(String search);
	
	//this method counts how many titles contain a certain string
	Long countByNameContaining(String search);
	
	//this method deletes a book that starts with a specific title
	Long deleteByNameStartingWith(String search);
}
