package com.johncarter.safetravels.repositories;

import java.util.List;



import org.springframework.data.repository.CrudRepository;

import com.johncarter.safetravels.models.TravelExpenses;

public interface TravelExpensesRepository extends CrudRepository<TravelExpenses, Long>{
	List<TravelExpenses> findAll();

}
