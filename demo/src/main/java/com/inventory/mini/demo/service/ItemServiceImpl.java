package com.inventory.mini.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.mini.demo.InventoryApplication;
import com.inventory.mini.demo.entity.Item;
import com.inventory.mini.demo.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemRepository itemRepository;
    private static final Logger logger = LogManager.getLogger(ItemService.class);
	
	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;

		 logger.warn("Service Initialized***********************");
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
        logger.info("An Item Added or Updated!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(theId);
		 logger.info("An Item DeletedXXXXXXXXXXXXXXXX");

	}

}
