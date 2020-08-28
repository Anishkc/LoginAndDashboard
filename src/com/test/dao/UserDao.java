package com.test.dao;


import java.util.List;

import com.test.model.User;

public interface UserDao {
	
  void userSignup(User u ); 
	  
  User userLogin(String un, String psw);
  
  List<User>  getAllUser();
  
  
  
  
  
}
