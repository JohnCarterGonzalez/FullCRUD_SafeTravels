package com.johncarter.safeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johncarter.safeTravels.models.TravelExpense;
import com.johncarter.safeTravels.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	// returns all the travels
    public List<TravelExpense> allTravels() {
        return travelRepo.findAll();
    }
    // creates a travel
    public TravelExpense create(TravelExpense t) {
        return travelRepo.save(t);
    }
    
    // updates a travel
    public TravelExpense update(TravelExpense t) {
    	return travelRepo.save(t);
    }
    
    
    // retrieves a travel
    public TravelExpense findTravel(Long id) {
        Optional<TravelExpense> oT = travelRepo.findById(id);
        if(oT.isPresent()) {
            return oT.get();
        } else {
            return null;
        }
    }
    
    public void delete(Long id) {
    	travelRepo.deleteById(id);
    }
}
