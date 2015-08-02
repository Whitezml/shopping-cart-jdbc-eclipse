package com.ct.java.project.jdbc.dao;

import com.ct.java.project.jdbc.domain.Person;

public interface PersonDao {

	//Find person by username
	public Person find(String username); 
	//Register person
	public boolean register (Person person); 
	
}

