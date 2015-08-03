package com.ct.java.project.jdbc.dao;

import java.util.List;

import com.ct.java.project.jdbc.domain.Item;
/**
 * Define Item dao
 * @author christophe
 *
 */
public interface ItemDao {

	Item findItemById(long id);

	List<Item> findAllItems();

}
