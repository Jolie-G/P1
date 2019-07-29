package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}

	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		session.invalidate();//session
		LogInServlet.check.setFirstname("");
		LogInServlet.check.setLastname("");
		LogInServlet.check.setPassword("");
		LogInServlet.check.setUserId(0);
		LogInServlet.check.setRoleId(0);
		
		res.sendRedirect("LogInMain.html");

		return null;
	}
}
