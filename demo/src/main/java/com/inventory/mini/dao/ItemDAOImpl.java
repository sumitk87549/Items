package com.inventory.mini.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.mini.entity.Item;

public class ItemDAOImpl implements ItemDAO {

	private EntityManager entityManager;
	
	
	@Autowired
	public ItemDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	@Transactional
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Item> qry = currentSession.createQuery("from item", Item.class);
		
		List<Item> items = qry.getResultList();
		
		return items;
	}



	@Override
	@Transactional
	public Item findById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Item item = session.get(Item.class, id);
		
		return item;
	}



	@Override
	@Transactional
	public void save(Item item) {
		// TODO Auto-generated method stub
		Session	session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(item);
		
	}



	@Override
	@Transactional
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Query qry = session.createQuery("delete from item where id=:itemId");
		
		qry.setParameter("itemId", id);
		
		qry.executeUpdate(); 	
		
	}

}
