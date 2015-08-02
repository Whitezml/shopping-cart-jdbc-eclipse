package com.ct.java.project.jdbc.dao;

import java.util.List;

import com.ct.java.project.jdbc.domain.Item;
import com.ct.java.project.jdbc.domain.Person;

public interface PersonItemDao {
		
		public List<Item> findAllItemsByPersonId(Person person);

		public boolean removeItemFromCart(long itemId, Person person);


		public boolean addItemtoCart(long itemId, Person person);
	
}
