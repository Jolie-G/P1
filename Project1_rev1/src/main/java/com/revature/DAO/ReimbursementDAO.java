package com.revature.DAO;

import java.util.List;

import com.revature.beans.ManagerTeam;
import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	//inserting reimbursement form into the database
	public Reimbursement createReimbursement(int author, int reimstatus , String receiptimage);
	
	public List<Reimbursement> getAllEmployeeReimbursementsByStatus(int reimStatusId, int reimauthorId);
	
	public  List<Reimbursement> getAllReimbursements();
	
	public void editReimbursementsbyUserID(int reimStatusId, int resolverid,int reimId);
	
	public List<ManagerTeam> ViewAllManaged();
	
	

}
