package com.ct.java.project.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ct.java.project.jdbc.dao.PersonItemDao;
import com.ct.java.project.jdbc.domain.Item;
import com.ct.java.project.jdbc.domain.Person;
import com.ct.java.project.jdbc.utils.ConnectionUtil;

public class PersonItemDaoImpl implements PersonItemDao {
	private ConnectionUtil util = ConnectionUtil.getUtil();
	
	


	@Override
	public List<Item> findAllItemsByPersonId(Person person) {
		 
		List <Item> items = new ArrayList<Item>(); 
		Item item;
		String query = "SELECT pi.p_id, i.id,  i.name, i.price FROM person_item pi INNER JOIN item i ON pi.i_id = i.id AND pi.p_id = ?";
		
		try(Connection conn = util.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);){
			
			ps.setLong(1, person.getId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				item = new Item(rs.getLong("ID"), rs.getString("NAME"), rs.getFloat("PRICE"));
				
				items.add(item);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return items; 
	}

	@Override
	public boolean removeItemFromCart(long itemId, Person person) {
		boolean success; 
		String query = "DELETE FROM PERSON_ITEM WHERE  P_ID = ? AND I_ID = ?";// WHERE ROWNUM <= 1
		
		
		try(Connection conn = util.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);){
			
			ps.setLong(1, person.getId());
			ps.setLong(2, itemId);
			
			int result = ps.executeUpdate();
			
			if(result==1)
				return true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addItemtoCart(long itemId, Person person) {
		boolean success; 
		String query = "INSERT INTO PERSON_ITEM (P_ID,I_ID) VALUES (?,?)";
		
		try(Connection conn = util.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);){
			
			ps.setLong(1, person.getId());
			ps.setLong(2, itemId);
			
			int result = ps.executeUpdate();
			
			if(result==1)
				return true; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


}
