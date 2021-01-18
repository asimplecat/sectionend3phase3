package com.hcl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hcl.model.User;

public class AutheticationTest {

	@BeforeEach
	public void setup() {
			Authentication.userList.add(User.builder().name("dani").email("dani@email").build());
			Authentication.userList.add(User.builder().name("altaf").email("altaf@email").build());
			Authentication.userList.add(User.builder().name("nick").email("nick@email").build());
	}
	
	@Test
	public void testLogin() {
		Authentication au = new Authentication();
		assertEquals(true , au.login("dani" , "dani@email"));
	}
	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(false, authentication.login("jake", "pass"));
	}
	
	@Test
	public void testId() {
		Authentication authentication = new Authentication();
		assertEquals(true , authentication.login("altaf", "altaf@email"));
		assertEquals("altaf@email" , authentication.getEmail());
	}
	
	@Test
	public void testLogout() {
		Authentication au = new Authentication();
		
		assertEquals(true , au.login("altaf" , "altaf@email"));
	
		au.logout();
		
		assertEquals(null, au.getEmail());
		
	}
}
