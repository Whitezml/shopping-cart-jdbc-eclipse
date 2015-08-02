package com.ct.java.project.jdbc.dao;

import java.util.List;

import com.ct.java.project.jdbc.domain.Item;

public interface ItemDao {

	public Item findItemById(long id); 
	
	public List<Item> findAllItems(); 
	
	
	
}
