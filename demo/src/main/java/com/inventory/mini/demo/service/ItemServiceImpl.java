package com.inventory.mini.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.mini.demo.entity.Item;
import com.inventory.mini.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;

	
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Item findById(int theId) {
		Optional<Item> result = itemRepository.findById(theId);
		
		Item theItem= null;
		
		if (result.isPresent()) {
			theItem= result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theItem;
	}

	@Override
	public void save(Item theItem) {
		// TODO Auto-generated method stub
		itemRepository.save(theItem);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(theId);
	}

}
