package com.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.db.DB;
import com.test.model.User;

public class UserDaoImpl implements UserDao {
	
	  @Override
	public void userSignup(User u) {
		String sql = "insert into user(fname,lname,username,password)values(?,?,?,?)";
		try {
			PreparedStatement pstm = DB.getDb().prepareStatement(sql);
			pstm.setString(1, u.getFname());
			pstm.setString(2, u.getLname());
			pstm.setString(3, u.getUsername());
			pstm.setString(4, u.getPassword());
			
			pstm.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	  
	  @Override
	public User userLogin(String un, String psw) {

		  String sql ="select * from user where username ='"+un+"' and password='"+psw+"' ";
		  
		  try {
			Statement  stm = DB.getDb().createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			 if(rs.next()) {
				 User u = new User();
				 
				 u.setId(rs.getInt("id"));
				 u.setFname(rs.getString("fname"));
				 u.setLname(rs.getString("lname"));
				 u.setUsername(rs.getString("username"));
				 u.setPassword(rs.getString("password"));
				 
				 return u ;
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		  
		return null;
	}

	@Override
	public List<User> getAllUser() {
		List<User>  ulist = new ArrayList<>();
		String sql ="select * from user ";
		try {
			Statement stm = DB.getDb().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				ulist.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ulist;
	}
}
