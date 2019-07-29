package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoImpl.UserDaoImpl;

public class GetUserByIDServlet extends HttpServlet {

static UserDaoImpl udao = new UserDaoImpl(); 
	private static final long serialVersionUID = 1L;
	
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
		
		int userid =LogInServlet.check.getUserId();
		
		System.out.println(" PARAMETERS SET"); 
		
		System.out.println(udao.getUserInfo(userid));
		
		//Json
		res.getWriter().write(new ObjectMapper().writeValueAsString(udao.getUserInfo(userid)));
		
		
		return null;
	}
	
	

}
