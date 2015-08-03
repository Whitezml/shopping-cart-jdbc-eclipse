package com.ct.java.project.jdbc.dao;

import com.ct.java.project.jdbc.domain.Person;
/**
 * Define Person dao
 * @author christophe
 *
 */
public interface PersonDao {

	//Find person by username
	Person find(String username); 
	
	//Register person
	boolean register (Person person); 
	
}

