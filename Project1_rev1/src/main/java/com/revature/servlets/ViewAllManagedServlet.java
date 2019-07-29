package com.revature.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.daoImpl.ReimDaoImpl;

public class ViewAllManagedServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	static ReimDaoImpl reimDao = new ReimDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}
	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
	
		res.getWriter().write(new ObjectMapper().writeValueAsString(reimDao.ViewAllManaged()));
		return null;
		
	}

}
