package com.ct.java.project.jdbc.service;

import com.ct.java.project.jdbc.domain.Person;

/**
 * Define store interface
 * @author christophe
 *
 */
public interface Store {

	void displayItemsInStore();

	void removeItemFromCart(long itemId, Person person);

	void showItemsCart(Person person);

	boolean register(Person person);

	Person authenticatePerson(String username, String password);

	void addItemToCart(long itemId, Person person);

}
