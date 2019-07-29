package com.revature.DAO;

import java.util.List;

import com.revature.beans.Users;

public interface UserDAO {
		
	public Users getUserInfo(int userId);
	
	public Users getUserLogin(String username, String password);
	
	public Users CreateNewEmp(String firstname,  String Lastname, String password, int role);
	
	public void updateEmployee( String firstname, String lastname, String password, int userid);
	public List<Users> GetAllUsers();


}
