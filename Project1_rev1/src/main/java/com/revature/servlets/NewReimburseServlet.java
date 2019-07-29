package com.revature.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Reimbursement;
import com.revature.beans.Users;
import com.revature.daoImpl.ReimDaoImpl;
import com.revature.daoImpl.UserDaoImpl;

public class NewReimburseServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	static Reimbursement reim = new Reimbursement();
	static Reimbursement newreim = null;
	Users user = new Users();
	UserDaoImpl udao = new UserDaoImpl();
	static ReimDaoImpl reimdao = new ReimDaoImpl();
	static int newreim_status_id = 1;
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");//receiving personal information that should be 
													//delivered with post
		req.getRequestDispatcher(process(req, res));//forwarded to change 
											//information within the same page
	}
	
	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("in newreim");
		System.out.println(" parameters attempeted");
			String newReceiptImage = req.getParameter("receiptimage");
			
reim.setReimauthorId(LogInServlet.check.getUserId());
int author = reim.getReimauthorId();
System.out.print(LogInServlet.check.getUserId());

reim.setReimStatusId(newreim_status_id);
int reimstatus = reim.getReimStatusId();

reim.setReceiptImage(newReceiptImage);
String receiptimage = reim.getReceiptImage();
		
			System.out.println(" parameters set");
			
			newreim = reimdao.createReimbursement(author, reimstatus , receiptimage);
			
			System.out.println(" after dao");

			int role = LogInServlet.check.getRoleId();
					if (role > 1)
					{
						res.sendRedirect("AdminSuccess.html");
					}
			
					else
					{
						res.sendRedirect("EmployeeSuccess.html");
					}
	
			 return null;
		
	}

}