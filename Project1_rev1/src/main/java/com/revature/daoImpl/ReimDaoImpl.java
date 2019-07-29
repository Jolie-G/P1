package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.ReimbursementDAO;
import com.revature.beans.ManagerTeam;
import com.revature.beans.Reimbursement;
import com.revature.connection.ConnFactory;

public class ReimDaoImpl implements ReimbursementDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	
	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = cf.getConnection()) {
			System.out.println("BEFORE PREPARED BLOCK");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM REIMBURSEMENT");
			System.out.println("AFTER PREPARED BLOCK");
			System.out.println("BEFORE RESULT SET BLOCK");
			ResultSet rs = ps.executeQuery();
			 System.out.println("AFTER RESULT SET BLOCK");
			 while (rs.next()) {
					
					reimbursements.add(new Reimbursement(rs.getInt("REIM_ID"), rs.getInt("REIM_AUTHOR_ID"),
							rs.getInt("REIM_RESOLVER_ID"), rs.getInt("REIM_STATUS_ID"), rs.getString("RECEIPT_IMAGE")));
				}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		System.out.println("Return result");
		return reimbursements;
	}

	@Override
	public Reimbursement createReimbursement(int author, int reimstatus, String receiptimage) {

		System.out.println("BEFORE TRY BLOCK");

		try (Connection conn = cf.getConnection()) {
			System.out.println("BEFORE PREPARED BLOCK");
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO REIMBURSEMENT ( REIM_AUTHOR_ID, REIM_STATUS_ID, RECEIPT_IMAGE) VALUES (?,?,?)");
			System.out.println("AFTER PREPARED BLOCK");
			ps.setInt(1, author);
			ps.setInt(2, reimstatus);
			ps.setString(3, receiptimage);
			System.out.println("BEFORE EXECUTE SET BLOCK");

			ps.executeUpdate();
			System.out.println("AFTER EXECUTE SET BLOCK");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAllEmployeeReimbursementsByStatus(int reimStatusId, int reimauthorId) {
		System.out.println("BEFORE TRY BLOCK");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try (Connection conn = cf.getConnection()) { // connecting to database

			System.out.println("BEFORE PREPARED BLOCK");
			// passing the sql statement into the child of prepared statement
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM REIMBURSEMENT WHERE REIM_STATUS_ID = ? AND REIM_AUTHOR_ID = ?");
			System.out.println("AFTER PREPARED BLOCK");
			ps.setInt(1, reimStatusId);//set  puts the parameter into the ? marks
			ps.setInt(2, reimauthorId);
			System.out.println("BEFORE RESULT SET BLOCK");
			ResultSet rs = ps.executeQuery();
			System.out.println("AFTER RESULT SET BLOCK");
			while (rs.next()) {
				System.out.println("Return result");
				reimbursements.add(new Reimbursement(rs.getInt("REIM_ID"), rs.getInt("REIM_AUTHOR_ID"),
						rs.getInt("REIM_RESOLVER_ID"), rs.getInt("REIM_STATUS_ID"), rs.getString("RECEIPT_IMAGE")));
			}

		} catch (SQLException e) {
			System.out.println("IN CATCH");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		System.out.println("return reimbursements");
		return reimbursements;
	}

	@Override
	public void editReimbursementsbyUserID(int reimStatusId, int resolverid , int reimId) {
		System.out.println("BEFORE TRY BLOCK");
		try (Connection conn = cf.getConnection()) { // connecting to database

			System.out.println("BEFORE PREPARED BLOCK");
			// passing the sql statement into the child of prepared statement
			PreparedStatement ps = conn.prepareStatement( //passing the sql statement into the child
					//of prepared statement 
					"UPDATE REIMBURSEMENT SET REIM_STATUS_ID= ?, REIM_RESOLVER_ID=? WHERE REIM_ID=?");
			System.out.println("AFTER PREPARED BLOCK");
			ps.setInt(1, reimStatusId);
			ps.setInt(2, resolverid);
			ps.setInt(3, reimId);
			System.out.println("BEFORE RESULT SET BLOCK");
			ps.executeQuery();
			System.out.println("AFTER RESULT SET BLOCK");
	
		} catch (SQLException e) {
			System.out.println("IN CATCH");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
	
	
	}

	@Override
	public List<ManagerTeam> ViewAllManaged() {
		System.out.println("BEFORE TRY BLOCK");
		List<ManagerTeam> managed = new ArrayList<ManagerTeam>();
		try (Connection conn = cf.getConnection()) { // connecting to database

			System.out.println("BEFORE PREPARED BLOCK");
			// passing the sql statement into the child of prepared statement
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Manager_Employee_Pairing");
			System.out.println("AFTER PREPARED BLOCK");
			System.out.println("BEFORE RESULT SET BLOCK");
			ResultSet rs = ps.executeQuery();
			System.out.println("AFTER RESULT SET BLOCK");
			while (rs.next()) {
				System.out.println("Return result");
				managed.add(new ManagerTeam(rs.getInt("Team_ID"), rs.getInt("SUPER_MANAGER_ID"),
						rs.getInt("MANAGER_ID"), rs.getInt("EMPLOYEE_ID")));
			}

		} catch (SQLException e) {
			System.out.println("IN CATCH");
			System.err.println(e.getMessage());
			System.err.println("SQL State: " + e.getSQLState());
			System.err.println("Error code: " + e.getErrorCode());
		}
		System.out.println("return reimbursements");
		return managed;
	}

}


