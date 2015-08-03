package com.ct.java.project.jdbc.dao;

import java.util.List;

import com.ct.java.project.jdbc.domain.Item;
import com.ct.java.project.jdbc.domain.Person;
/**
 * Define PersonItem dao
 * @author christophe
 *
 */
public interface PersonItemDao {
		
		List<Item> findAllItemsByPersonId(Person person);

		boolean removeItemFromCart(long itemId, Person person);

		boolean addItemtoCart(long itemId, Person person);
	
}
