package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoImpl.UserDaoImpl;

public class UpdateEmployeeInfoServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
static UserDaoImpl udao = new UserDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}

	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("GETTING PARAMETERS");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String password = req.getParameter("password");
		int userid = LogInServlet.check.getUserId();
		System.out.println("PARAMETERS SET");
		System.out.println("UPDATE ATTEMPTED");
		udao.updateEmployee( firstname, lastname, password, userid);
		System.out.println("UPDATE COMPLETE");
		
		System.out.println("UPDATE DISPLAY INFORMATION");
		
		//Json
		res.getWriter().write(new ObjectMapper().writeValueAsString(udao.getUserInfo(userid)));
		System.out.println("INFORMATION DISPLAYED");
		return null;
		
	}

}
