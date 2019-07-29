package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.daoImpl.ReimDaoImpl;

public class ManagerGetAllReimByStatusServlet extends HttpServlet  {

	static ReimDaoImpl reimDao = new ReimDaoImpl(); 
	static List<Reimbursement> reim = null;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}
	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String authidconvert = req.getParameter("userId");
		String statusidconvert = req.getParameter("status");
		
		
		int authorid = Integer.parseInt(authidconvert); //converting string authid and statusid  to int via the parseint method 
		int statusid = Integer.parseInt(statusidconvert);
		
		
		//Json
		res.getWriter().write(new ObjectMapper().writeValueAsString(reimDao.getAllEmployeeReimbursementsByStatus(statusid, authorid)));
		return null;
		
	}
}
