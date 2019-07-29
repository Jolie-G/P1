package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;

import com.revature.beans.Users;
import com.revature.daoImpl.UserDaoImpl;

public class LogInServlet extends HttpServlet {

	public static UserDaoImpl dao = new UserDaoImpl();
	public static Users check = null;

	 static  Logger log = Logger.getLogger(LogInServlet.class);

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}

	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("firstname");
		String password = req.getParameter("password");

		

		try {
			//log4j
			log.info("going into try");
			log.info(check = dao.getUserLogin(username, password));
			check = dao.getUserLogin(username, password);
			
		
			System.out.println("entering try catch");
			System.out.println(check.getFirstname());
			System.out.println(check.getPassword());

			//Session
			req.getSession().setAttribute("loggeduser", check); 
			req.getSession().setAttribute("loggedpassword", password);		
			
			if ((check.getFirstname().equals(username)) && (check.getPassword().equals(password))) {

				System.out.println(" so close");

				if (check.getRoleId() > 1) {
					System.out.println(" you are an admin");
					res.sendRedirect("AdminSuccess.html");

				} else {
					System.out.println(" you are an employee");
					res.sendRedirect("EmployeeSuccess.html");
				}
			}
		}

		catch (NullPointerException e) {
			System.out.println("in catch");
			// return "unsuccessfulLogin.html";
			res.sendRedirect("UnsuccessfulLogIn.html");
		}
		return null;
	}
}
