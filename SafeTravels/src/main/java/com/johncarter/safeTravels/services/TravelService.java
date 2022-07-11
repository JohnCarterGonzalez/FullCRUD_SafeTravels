package com.johncarter.safeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johncarter.safeTravels.models.Travel;
import com.johncarter.safeTravels.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	// returns all the travels
    public List<Travel> allTravels() {
        return travelRepo.findAll();
    }
    // creates a travel
    public Travel create(Travel t) {
        return travelRepo.save(t);
    }
    
    // updates a travel
    public Travel update(Travel t) {
    	return travelRepo.save(t);
    }
    
    
    // retrieves a travel
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepo.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    
    public void delete(Long id) {
    	travelRepo.deleteById(id);
    }
}
