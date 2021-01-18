package com.hcl;

import java.util.ArrayList;
import java.util.HashSet;
//import java.util.set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.hcl.model.User;

public class Authentication {
	public static ArrayList<User> userList = new ArrayList<>();
	
		
		
		private User currentSessionUser = null;
		
		public boolean login(String uname, String pass) {
			AtomicBoolean userExists = new AtomicBoolean(false);
			
			userList.stream().filter(x -> x.getName().equals(uname) && x.getEmail().equals(pass)).findFirst()
			.ifPresent(x -> {
				userExists.set(true);
				currentSessionUser = x;
			});
			
			
			return userExists.get();
		}


		public void logout() {
			currentSessionUser = null;
		}
		
		public String getEmail() {
			if (currentSessionUser == null) {
				return null;
			}
			return currentSessionUser.getEmail();
		}
		
		
		

}
