package com.ct.java.project.jdbc.service;

import com.ct.java.project.jdbc.domain.Person;

public interface Store {
	
	public void displayItemsInStore();
	
	public void removeItemFromCart(long itemId, Person person); 
	
	public void showItemsCart(Person person);
	
	public boolean register (Person person); 
	
	public Person authenticatePerson(String username, String password);

	public void addItemToCart(long itemId, Person person); 
	


}
