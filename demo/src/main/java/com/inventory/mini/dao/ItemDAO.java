package com.inventory.mini.dao;

import java.util.List;

import com.inventory.mini.entity.Item;


public interface ItemDAO {
	
	public List<Item> findAll();
	
	public Item findById(int id);
	
	public void save(Item item);
	
	public void deleteById(int id);
}
