package com.inventory.mini.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventory.mini.demo.entity.Item;
import com.inventory.mini.demo.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemRestController {
	
	private ItemService itemService;

	
	@Autowired
	public ItemRestController(ItemService theItemdao) {
		itemService = theItemdao;
	}
	
	
	@GetMapping("/items")
	public List<Item> findAll(){
		return itemService.findAll();
	}
	
	
	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable int itemId) {
		Item item = itemService.findById(itemId);
		
		
		if(item == null) {
			throw new RuntimeException("Item id not found - " + itemId);
		}
		
		return item;
	}
	
	
	
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		
		item.setId(0);
		
		itemService.save(item);
		
		return item;
	}
	
	@PutMapping("/items")
	public Item updateItem(@RequestBody Item item) {
		
		itemService.save(item);
		
		return item;
	}
	
	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable int itemId) {
		
		
		Item item = itemService.findById(itemId);
		
		if(item == null) {
			throw new RuntimeException("Item id not found - "+itemId);	
		}
		
		itemService.deleteById(itemId);		
		
		return "Deleted Successfully";
	}

	
	
}
