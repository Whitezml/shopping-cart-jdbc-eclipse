package com.ct.java.project.jdbc.service;

import java.util.List;

import com.ct.java.project.jdbc.dao.ItemDao;
import com.ct.java.project.jdbc.dao.PersonDao;
import com.ct.java.project.jdbc.dao.PersonItemDao;
import com.ct.java.project.jdbc.dao.impl.ItemDaoImpl;
import com.ct.java.project.jdbc.dao.impl.PersonDaoImpl;
import com.ct.java.project.jdbc.dao.impl.PersonItemDaoImpl;
import com.ct.java.project.jdbc.domain.Item;
import com.ct.java.project.jdbc.domain.Person;

public class FairfaxStore implements Store{
	private ItemDao iDao = new ItemDaoImpl();
	private PersonDao pDao = new PersonDaoImpl();
	private PersonItemDao piDoa = new PersonItemDaoImpl();
	
	@Override
	public void displayItemsInStore() {
		
		List<Item> items = iDao.findAllItems();
		for(Item i : items){
			System.out.println(i);
		}
		
	}

	@Override
	public void addItemToCart(long itemId, Person person) {
		piDoa.addItemtoCart(itemId, person);
		
		
	}

	@Override
	public void removeItemFromCart(long itemId, Person person) {
		piDoa.removeItemFromCart(itemId, person);
		
	}

	@Override
	public void showItemsCart(Person person) {
		List<Item> items = piDoa.findAllItemsByPersonId(person);
		for(Item i : items){
			System.out.println(i);
		}
		
	}

	@Override
	public boolean register(Person person) {
		
		return pDao.register(person);
	}

	@Override
	public Person authenticatePerson(String username, String password) {

		Person person = pDao.find(username);
		if(person==null)
			return null;
		else{
			if(person.getPassword()!=null&&person.getPassword().equals(password)){
				return person;
			}
			else{
				return null; 
			}
		}
	}


	

}
