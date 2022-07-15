package com.johncarter.safetravels.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.johncarter.safetravels.models.TravelExpenses;
import com.johncarter.safetravels.repositories.TravelExpensesRepository;

@Service
public class TravelExpensesService {
	private final TravelExpensesRepository trepo;
	
	public TravelExpensesService(TravelExpensesRepository trepo) {
		this.trepo = trepo;
	}
	
	//return all travel expenses
	public List<TravelExpenses> all() {
		return trepo.findAll();
	}
	
	//create a travel expense
	public TravelExpenses createExpense(TravelExpenses tE) {
		return trepo.save(tE);
	}
	
	//updates a travel expense
	public TravelExpenses updateExpense(TravelExpenses tE) {
		return trepo.save(tE);
	}
	
	public void delete(Long id) {
		trepo.deleteById(id);
	}
	
	//retrieve a travel expense
	public TravelExpenses findExpense(Long id) {
		Optional<TravelExpenses> optExpense = trepo.findById(id);
		if(optExpense.isPresent()) {
			return optExpense.get();
		} else {
			return null;
		}
	}

	
	
}
