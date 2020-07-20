package com.inventory.mini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.mini.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
