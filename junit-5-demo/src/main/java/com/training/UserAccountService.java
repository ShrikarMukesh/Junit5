package com.training;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.training.model.User;

public class UserAccountService {

	private List<User> users;

	public UserAccountService() {
		users = new ArrayList<>();

		users.add(new User("anna.parker@gmail.com", "anna@123"));
		users.add(new User("bob.martin@gmail.com", "bob@123"));
		users.add(new User("alex.browning@gmail.com", "alex@123"));
		users.add(new User("jason.taylor@gmail.com", "jason@123"));
		users.add(new User("george.king@gmail.com", "george@123"));
		users.add(new User("kathy.sierra@gmail.com", "kathy@123"));
	}

	public boolean authenticate(String email, String password) {

		if (StringUtils.isBlank(email) || StringUtils.isBlank(password))    
			throw new IllegalArgumentException("Username or password should not be empty.");
		
//		for (User user : users) {
//			if (user.getEmail().equals(email) && user.getPassword().equals(password))
//				return true;
//		}
//		return false;
		
		return users.stream()
		                   .anyMatch(user -> user.getEmail().equals(email) && user.getPassword().equals(password));
	}

	public boolean resetPasswordLink(String email) {
		
		if (StringUtils.isBlank(email)) 
			throw new IllegalArgumentException("Email should not be empty.");
		
		return users.stream()
		        		   .anyMatch(user -> user.getEmail().equals(email));
	}

	public boolean changePassword(String email, String oldPassword, String newPassword) {
		
		if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)) 
			throw new IllegalArgumentException("OldPassword or NewPassword Should not be empty.");
		
		for (User user: users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(oldPassword)) {
			    if (! oldPassword.equals(newPassword)) {
			    	user.setPassword(newPassword);
			    	return true;
			    }
			    return false;			    
			}			
		}	
	
		return false;
	}

}











