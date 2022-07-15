package com.johncarter.safetravels.controllers;

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

import com.johncarter.safetravels.models.TravelExpenses;
import com.johncarter.safetravels.services.TravelExpensesService;

@Controller
public class HomeController {
	@Autowired 
	private TravelExpensesService tService;
	
	/*
	 * GET routes
	 */
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("expenses/edit/{id}")
	public String editExpenses(@PathVariable("id") Long id, Model m) {
		TravelExpenses tE = tService.findExpense(id);
		m.addAttribute("texpenses", tE);
		return "editExpenses.jsp";
	}
	
	@GetMapping("/expenses")
	public String tExpenses(@ModelAttribute("texpenses") TravelExpenses tE, Model m) {
		m.addAttribute("texpenses", tService.all());
		return "dashboard.jsp";
	}
	
	@GetMapping("/epxenses/{id}")
	public String showExpenses(@PathVariable("id") Long id, Model m) {
		m.addAttribute("texpenses", tService.findExpense(id));
		return "showExpenses.jsp";
	}
	
	
	/*
	 * POST routes
	 */
	
	@PostMapping("/expenses/create")
	public String createTravelExpense(@Valid @ModelAttribute("texpenses") TravelExpenses tE, Model m, BindingResult result) {
		if(result.hasErrors()) {
			m.addAttribute("texpenses", tService.all());
			return "editExpenses.jsp";
		}
		tService.createExpense(tE);
		return "redirect:/expenses";
	}
	
	@PutMapping("/expenses/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("texpenses") TravelExpenses tE, BindingResult result, Model m) {
		if (result.hasErrors()) {
			m.addAttribute("travels", tService.all());
			return "editExpenses.jsp";
		}
		
		tService.updateExpense(tE);
		
		return "redirect:/expenses";
	}
	
	
	@DeleteMapping("expenses/{id}")
	public String delete(@PathVariable("id") Long id) {
		tService.delete(id);
		return "redirect:/expenses";
	}
	
	
}