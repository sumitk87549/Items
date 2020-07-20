package com.inventory.mini.demo.service;

import java.util.List;

import com.inventory.mini.demo.entity.Item;

public interface ItemService {

public List<Item> findAll();
	
	public Item findById(int theId);
	
	public void save(Item theEmployee);
	
	public void deleteById(int theId);
}
