package com.inventory.mini.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.mini.demo.entity.Item;

@Repository
public class ItemDAOJpaImpl implements ItemDAO {
	
	private EntityManager entityManager;
		
	@Autowired
	public ItemDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Item> findAll() {
		
		Query theQuery = entityManager.createQuery("from Item");
		
		List<Item> list = theQuery.getResultList();
					
		
		return list;
	}

	@Override
	@Transactional
	public Item findById(int id) {
		// TODO Auto-generated method stub
		
		Item item = entityManager.find(Item.class, id);
		return item;
	}

	@Override
	@Transactional
	public void save(Item item) {
		// TODO Auto-generated method stub
		Item item2 = entityManager.merge(item);
		
		item.setId(item2.getId());
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub

		Query qry= entityManager.createQuery("delete from item where id=:itemid");
		
		qry.setParameter("itemid", id);
		
		qry.executeUpdate();
	}

}
