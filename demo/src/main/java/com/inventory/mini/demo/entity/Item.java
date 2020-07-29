package com.inventory.mini.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	public Item(String name, String description, int quantity) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity > 0 && quantity <= 100)
			this.quantity = quantity;
		else if (quantity <= 0) {
			this.quantity = 1;
		} else {
			this.quantity = 100;
		}
	}

}
