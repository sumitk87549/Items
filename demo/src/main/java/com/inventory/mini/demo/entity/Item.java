package com.inventory.mini.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="quantity")
	private int quantity;

	public Item() {
	}
	
	public Item(int id, String name, String description, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}
	
	public Item(String name, String description, int quantity) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity > 0 && quantity <=100)
		this.quantity = quantity;
		else if(quantity <= 0){
			this.quantity = 1;
		}
		else {
			this.quantity = 100;
		}
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity + "]";
	}
	
	
}
