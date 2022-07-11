package com.johncarter.safeTravels.controllers;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.johncarter.safeTravels.models.Travel;
import com.johncarter.safeTravels.services.TravelService;

@Controller
public class HomeControllers {
	
	@Autowired
	private TravelService travels;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/travels";
	}
	
	@GetMapping("/travels")
	public String travels(@ModelAttribute("travel") Travel travel, Model m) {
		
	
		m.addAttribute("travel", travels.allTravels());
		
		return "index.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model m) {
		m.addAttribute("travel", travels.findTravel(id));
		m.addAttribute("travel", travels.allTravels());
		
		return "edit.jsp";
	}
	
	@GetMapping("/travels/{id}")
	public String show(@PathVariable("id") Long id, Model m) {
		m.addAttribute("travel", travels.allTravels());
		
		//System.out.println("Platform Solution");
		return "show.jsp";
	}
	
	@PostMapping("/travels")
	public String create(@Valid @ModelAttribute("travel") Travel travel , BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("expenses", travels.allTravels());
			return "index.jsp";
		}
		// System.out.println("TEST");
		travels.create(travel);
		
		return "redirect:/travels";
	}
	
	@PutMapping("/travels/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("travels", travels.allTravels());
			return "edit.jsp";
		}
		
		travels.update(travel);
		
		return "redirect:/travels";
	}	
	
	@DeleteMapping("/travels/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		travels.delete(id);
		
		return "redirect:/travels";
	}
}
