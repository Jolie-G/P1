package com.revature.test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Users;
import com.revature.daoImpl.UserDaoImpl;

public class P1ver_1_test {
	static UserDaoImpl udao = null;
	public static Users user = new Users(1004, "Jim", "Wongo", "pass", 1);
	
	
	@Before()
	public void setUpBeforeTest() throws Exception {
		udao = new UserDaoImpl();
	}

	@Test()
	public void setUpTest() throws Exception {
		int userId = 1004;

		assertEquals("I expect this to run afoul", user, udao.getUserInfo(userId));
	}

}
