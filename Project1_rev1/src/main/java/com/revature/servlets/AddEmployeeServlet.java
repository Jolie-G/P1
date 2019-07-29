package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Users;
import com.revature.daoImpl.UserDaoImpl;

public class AddEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static UserDaoImpl dao = new UserDaoImpl();
	public static Users u2 = new Users();
	public static Users u = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("IN DOPOST this working?");// receiving personal information that should be
														// delivered with post
		req.getRequestDispatcher(process(req, res));
		// information within the same page
	}

	public static String process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("in newemp");
		System.out.println(" parameters attempeted");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String password = req.getParameter("password");
		String roleIdConvert = req.getParameter("role_id");
		int roleId = Integer.parseInt(roleIdConvert);

		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(password);
		System.out.println(roleId);

		System.out.println(" parameters contained");
		System.out.println(" setting parameters ");
		u2.setFirstname(firstname);
		u2.setLastname(lastname);
		u2.setPassword(password);
		u2.setRoleId(roleId);

		System.out.println(" parameters set");

		u = dao.CreateNewEmp(u2.getFirstname(), u2.getLastname(), u2.getPassword(), u2.getRoleId());

		System.out.println(" after dao");

		res.sendRedirect("AdminSuccess.html");
		return null;

	}

}
