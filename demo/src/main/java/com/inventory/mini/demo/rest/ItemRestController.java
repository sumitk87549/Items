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

import com.inventory.mini.demo.dao.ItemDAO;
import com.inventory.mini.demo.entity.Item;


@RestController
@RequestMapping("/api")
public class ItemRestController {
	
	private ItemDAO itemdao;

	@Autowired
	public ItemRestController(ItemDAO theItemdao) {
		itemdao = theItemdao;
	}
	
	
	@GetMapping("/items")
	public List<Item> findAll(){
		return itemdao.findAll();
	}
	
	
	@GetMapping("/items/{itemId}")
	public Item getItem(@PathVariable int itemId) {
		Item item = itemdao.findById(itemId);
		
		if(item == null) {
			throw new RuntimeException("Id not found - " +itemId);
		}
		
		return item;
	}
	
	
	@PostMapping("/items")
	public Item addItem(@RequestBody Item item) {
		
		item.setId(0);
		
		itemdao.save(item);
		
		return item;
	}
	
	@PutMapping("/items")
	public Item updateItem(@RequestBody Item item) {
		
		itemdao.save(item);
		
		return item;
	}
	
	@DeleteMapping("/items/{itemId}")
	public String deleteItem(@PathVariable int itemId) {
		
		Item item = itemdao.findById(itemId);
		
		if(item == null)
				throw new RuntimeException("Employee id not found - "+itemId);
		
		itemdao.deleteById(itemId);
		
		return "Deleted Successfully";
	}

	
	
}
