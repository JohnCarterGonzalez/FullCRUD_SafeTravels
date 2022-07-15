package com.johncarter.safeTravels.controllers;
import com.johncarter.safeTravels.models.TravelExpense;
import com.johncarter.safeTravels.services.TravelService;
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

@Controller
public class HomeControllers {
	
	@Autowired
	private TravelService t;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/travels";
	}
	
	@GetMapping("/travels")
	public String travels(@ModelAttribute("travel") TravelExpense trav, Model m) {
		m.addAttribute("travel", t.allTravels());
		return "index.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model m) {
		m.addAttribute("travel", t.findTravel(id));
		m.addAttribute("travel", t.allTravels());
		return "edit.jsp";
	}
	
	@GetMapping("/travels/{id}")
	public String show(@PathVariable("id") Long id, Model m) {
		m.addAttribute("travel", t.allTravels());
		return "show.jsp";
	}
	
	@PostMapping("/travels")
	public String create(@Valid @ModelAttribute("travel") TravelExpense trav, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("expenses", t.allTravels());
			return "index.jsp";
		}
		t.create(trav);
		return "redirect:/travels";
	}
	
	@PutMapping("/travels/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("travel") TravelExpense trav, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("travels", t.allTravels());
			return "edit.jsp";
		}
		
		t.update(trav);
		
		return "redirect:/travels";
	}	
	
	@DeleteMapping("/travels/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		t.delete(id);
		
		return "redirect:/travels";
	}
}
