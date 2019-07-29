package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoImpl.UserDaoImpl;

public class GetAllUsersServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	static UserDaoImpl udao = new UserDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}

	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		System.out.println("In GetAllUsers");
		
		//Json!
		res.getWriter().write(new ObjectMapper().writeValueAsString(udao.GetAllUsers()));
		System.out.println("GotAllUsers");
	
		return null;
	}
	
	
}
