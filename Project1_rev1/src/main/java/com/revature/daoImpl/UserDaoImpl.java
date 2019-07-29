package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.DAO.UserDAO;
import com.revature.beans.Users;
import com.revature.connection.ConnFactory;

public class UserDaoImpl implements UserDAO {

	public static ConnFactory cf = ConnFactory.getInstance();//Singleton ...ensures only ever one of 
															//'them' at a time

	public Users getUserLogin(String name, String password) {
		System.out.println("BEFORE TRY BLOCK");
		try (Connection conn = cf.getConnection()) { //connecting to database

			System.out.println("BEFORE PREPARED BLOCK");
			//passing the sql statement into the child of prepared statement
			PreparedStatement ps = conn.prepareStatement("SELECT USER_ID, FIRSTNAME, LASTNAME, PASSWORD_PASS, ROLE_ID "
					+ "FROM USER_TABLE WHERE FIRSTNAME = ? AND PASSWORD_PASS = ?"); 
			System.out.println("AFTER PREPARED BLOCK");
			ps.setString(1, name);//passing  information into DB
			ps.setString(2, password);
			System.out.println("BEFORE RESULT SET BLOCK");
			ResultSet rs = ps.executeQuery();
			System.out.println("AFTER RESULT SET BLOCK");
			if (rs.next()) {
				System.out.println("Return result");
				return new Users(rs.getInt("USER_ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getString("PASSWORD_PASS"), rs.getInt("ROLE_ID"));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}
	

	public Users CreateNewEmp(String firstname, String lastname, String password, int roleId) {
		
		System.out.println("BEFORE TRY BLOCK");
		try (Connection conn = cf.getConnection()) {
			System.out.println("BEFORE PREPARED BLOCK");
			PreparedStatement ps = conn.prepareStatement( //passing the sql statement into the child
															//of prepared statement 
					"INSERT INTO USER_TABLE (FIRSTNAME, LASTNAME, PASSWORD_PASS, ROLE_ID) VALUES ( ?,?,?,?)");
			System.out.println("AFTER PREPARED BLOCK");
			//passing  information into DB
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, password);
			ps.setInt(4, roleId);
			System.out.println("BEFORE RESULT SET BLOCK");
			ps.executeUpdate(); // sends the SQL statement to the DB 
			System.out.println("AFTER RESULT SET BLOCK");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}

	public Users getUserModel() {
		System.out.println("BEFORE TRY BLOCK");
		try (Connection conn = cf.getConnection()) { //connecting to database

			System.out.println("BEFORE PREPARED BLOCK");
			//passing the sql statement into the child of prepared statement
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER_TABLE"); 
			System.out.println("AFTER PREPARED BLOCK");
			System.out.println("BEFORE RESULT SET BLOCK");
			ResultSet rs = ps.executeQuery();
			System.out.println("AFTER RESULT SET BLOCK");
			if (rs.next()) {
				System.out.println("Return result");
				return new Users(rs.getInt("USER_ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getString("PASSWORD_PASS"), rs.getInt("ROLE_ID"));
}

			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}


	@Override
	public Users getUserInfo(int userId) {
		System.out.println("BEFORE TRY BLOCK");
		try (Connection conn = cf.getConnection()) { //connecting to database

			System.out.println("BEFORE PREPARED BLOCK");
			//passing the sql statement into the child of prepared statement
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER_TABLE WHERE USER_ID = ?"); 
			ps.setInt(1, userId);//passing  information into DB
			System.out.println("AFTER PREPARED BLOCK");
			System.out.println("BEFORE RESULT SET BLOCK");
			ResultSet rs = ps.executeQuery();
			System.out.println("AFTER RESULT SET BLOCK");
			if (rs.next()) {
				System.out.println("Return result");
				return new Users(rs.getInt("USER_ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getString("PASSWORD_PASS"), rs.getInt("ROLE_ID"));
}

			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}


	@Override
	public void updateEmployee(String firstname, String lastname, String password, int userid) {
		System.out.println("BEFORE TRY BLOCK");
		try (Connection conn = cf.getConnection()) {
			System.out.println("BEFORE PREPARED BLOCK");
			PreparedStatement ps = conn.prepareStatement( //passing the sql statement into the child
															//of prepared statement 
					"UPDATE USER_TABLE SET FIRSTNAME=?, LASTNAME=?, PASSWORD_PASS=? WHERE USER_ID=?");
				
			System.out.println("AFTER PREPARED BLOCK");
			//passing  information into DB
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, password);
			ps.setInt(4, userid);
			System.out.println("BEFORE RESULT SET BLOCK");
			ps.executeUpdate(); // sends the SQL statement to the DB 
			System.out.println("AFTER RESULT SET BLOCK");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}

	}


	@Override
	public List<Users> GetAllUsers() {
		List<Users> users = new ArrayList<Users>();
		System.out.println("BEFORE TRY BLOCK");
		try (Connection conn = cf.getConnection()) {
			System.out.println("BEFORE PREPARED BLOCK");
			PreparedStatement ps = conn.prepareStatement( //passing the sql statement into the child
													 "Select * From User_Table");
				
			System.out.println("AFTER PREPARED BLOCK");
			//passing  information into DB
			System.out.println("BEFORE RESULT SET BLOCK");
			ResultSet rs = ps.executeQuery(); // sends the SQL statement to the DB 
			System.out.println("AFTER RESULT SET BLOCK");

			while (rs.next()) {
				System.out.println("Return result");
				 	users.add(new Users(rs.getInt("USER_ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getString("PASSWORD_PASS"), rs.getInt("ROLE_ID")));
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return users;

	}

}

