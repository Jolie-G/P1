package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoImpl.ReimDaoImpl;

public class ApproveandDenyServlet extends HttpServlet {


	
	static ReimDaoImpl reimDAO = new ReimDaoImpl();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}

	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String reimidconvert = req.getParameter("reimid");
		String statusIDconvert = req.getParameter("statusid");
		
		int reimid = Integer.parseInt(reimidconvert);
		int statusid = Integer.parseInt(statusIDconvert);
		int resolverid = LogInServlet.check.getUserId();
		reimDAO.editReimbursementsbyUserID( statusid, resolverid, reimid);
		
		res.sendRedirect("AdminSuccess.html");
		return null;
	}
}