package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.daoImpl.ReimDaoImpl;


public class getAllEmployeeReimbursementsByStatusServlet extends HttpServlet{

		private static final long serialVersionUID = 1L;

		public static ReimDaoImpl reimDAO = new ReimDaoImpl();
		
		public static Reimbursement reimburse = new Reimbursement();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			System.out.println("IN DOGET this working?"); // request information that is being sent from
															// the client is being passed into here, and then
															// being passed into the request helper's method
															// called "process"
			req.getRequestDispatcher(process(req, res));
		}
	
		
		public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException, JsonProcessingException  {
			System.out.println("IN PROCESS"); 
			System.out.println("SETTING PARAMETERS"); 
			String reimStatusIdconvert = req.getParameter("reimbursestatus");
			int reimStatusId = Integer.parseInt(reimStatusIdconvert);//converting String reinStatusIdconvert to an int, via parseInt method
			reimburse.setReimStatusId(reimStatusId);
			reimburse.setReimauthorId(LogInServlet.check.getUserId());
			int reimauthorId = reimburse.getReimauthorId();
			System.out.println("PARAMETERS SET");
			
			try {
				System.out.println("IN TRY");
			System.out.println(reimDAO.getAllEmployeeReimbursementsByStatus(reimStatusId, reimauthorId));
			
			//Json
			res.getWriter().write(new ObjectMapper().writeValueAsString(reimDAO.getAllEmployeeReimbursementsByStatus(reimStatusId, reimauthorId)));
			}
			catch(NullPointerException e) {
				System.out.println("IN CATCH");
				System.out.println("NO REIMBURSEMENTS");
			}
			
		
			return null;
			
		}

}
