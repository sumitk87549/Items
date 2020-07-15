package com.inventory.mini.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.mini.dao.ItemDAO;
import com.inventory.mini.entity.Item;


@RestController
@RequestMapping("/api")
public class ItemRestController {

	public ItemDAO itemdao;

	@Autowired
	public ItemRestController(ItemDAO itemdao) {
		this.itemdao = itemdao;
	}
	
	
	@GetMapping("/items")
	public List<Item> findAll(){
		return itemdao.findAll();
	}
	
	
	@GetMapping("/items/{id}")
	public Item getItem(@PathVariable int itemId) {
		Item item = itemdao.findById(itemId);
		
		if(item == null) {
			throw new RuntimeException("Id not found - " +itemId);
		}
		
		return item;
	}

	
	
}
