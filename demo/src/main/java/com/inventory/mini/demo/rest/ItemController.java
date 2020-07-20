package com.inventory.mini.demo.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.mini.demo.entity.Item;
import com.inventory.mini.demo.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

	private ItemService itemService;
	
	public ItemController(ItemService theEmployeeService) {
		itemService = theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Item> theItems = itemService.findAll();
		
		// add to the spring model
		theModel.addAttribute("item", theItems);
		
		return "items/list-items";
	}
	
	@GetMapping("/addForm")
	public String showAddForm(Model model) {
		Item itemX = new Item();
		
		model.addAttribute("item",itemX);
		
		return "items/add-form";
	}
	
	@PostMapping("/save")
	public String saveItem(@ModelAttribute("item") Item theItem) {
		
		itemService.save(theItem);
		
		return "redirect:/items/list";
	}
	
	@GetMapping("/updateForm")
	public String showUpdateForm(@RequestParam("itemId") int id, Model model) {
		Item itemx = itemService.findById(id);
		
		model.addAttribute("item", itemx);
		
		return "/items/add-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("itemId") int id) {
		
		itemService.deleteById(id);
		
		return "redirect:/items/list";
	}
}
