package com.ct.java.project.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ct.java.project.jdbc.dao.ItemDao;
import com.ct.java.project.jdbc.domain.Item;
import com.ct.java.project.jdbc.utils.ConnectionUtil;

public class ItemDaoImpl implements ItemDao{
	
	private ConnectionUtil util = ConnectionUtil.getUtil();

	@Override
	public Item findItemById(long id) {
		Item item=null;
		String query = " SELECT * FROM ITEM WHERE ID = ? ";
		try(Connection conn = util.getConnection(); 
			PreparedStatement preparedStatement = conn.prepareStatement(query);){
			
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				item = new Item (
						resultSet.getLong("ID"),
						resultSet.getString("NAME"),
						resultSet.getFloat("PRICE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public List<Item> findAllItems() {
		List<Item> items = new ArrayList<Item> ();
		Item item=null;
		String query = " SELECT * FROM ITEM ";
		try(Connection conn = util.getConnection(); 
			PreparedStatement preparedStatement = conn.prepareStatement(query);){
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				item = new Item (
						resultSet.getLong("ID"),
						resultSet.getString("NAME"),
						resultSet.getFloat("PRICE"));
				items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

}

