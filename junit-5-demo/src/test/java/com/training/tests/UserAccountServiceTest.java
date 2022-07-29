package com.training.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.training.UserAccountService;

public class UserAccountServiceTest {
	
	private UserAccountService userAccountService;
	
	@BeforeEach
	public void setUp() {
		userAccountService = new UserAccountService();
	}
	
	@Test
	public void autheticate_Should_Return_True_WhenCredentialsAreValid() {
			
		assertTrue(userAccountService.authenticate("anna.parker@gmail.com", "anna@123"));
	}
	
	@Test
	public void authenticate_Should_Return_False_WhenCredentialsAreIncorrect() {
		
		assertFalse(userAccountService.authenticate("kathy.sierra@gmail.com", "kathy123"));
	}
	
	@Test
	public void autheticate_Should_Throw_Exception_WhenEmptyUsernameOrPasswordIsProvided() {
		
		assertThrows(IllegalArgumentException.class, () -> userAccountService.authenticate("", "alex@123"));
	}
	
	@Test
	public void resetPasswordLink_Should_Return_True_WhenEmailIsAlreadyRegistered() {
			
		assertTrue(userAccountService.resetPasswordLink("jason.taylor@gmail.com"));
	}
	
	@Test
	public void resetPasswordLink_Should_Return_False_WhenEmailIsNotAlreadyRegistered() {
		
		assertFalse(userAccountService.resetPasswordLink("bryan.bash@gmail.com"));
	}
	
	@Test
	public void resetPasswordLink_Should_Throw_Exception_WhenEmptyEmailIsProvided() {
		
		assertThrows(IllegalArgumentException.class, () -> userAccountService.resetPasswordLink(""));
	}
	
	@Test
	public void changePassword_Should_Return_True_WhenCredentialsAreCorrect_And_OldPasswordAndNewPasswordAreNotSame() {
		
		assertTrue(userAccountService.changePassword("anna.parker@gmail.com", "anna@123", "annaparker123"));
	}
	
	@Test
	public void changePassword_Should_Return_False_WhenCredentialsAreCorrect_And_OldPasswordAndNewPasswordAreSame() {
		
		assertFalse(userAccountService.changePassword("anna.parker@gmail.com", "anna@123", "anna@123"));
	}
	
	@Test
	public void changePassword_Should_Return_False_WhenWrongCredentialsAreProvided() {
		
		assertFalse(userAccountService.changePassword("jason.taylor@gmail.com", "jason123", "jasontaylor123"));
	}
	
	@Test
	public void changePassword_Should_Throw_Exception_When_OldPasswordOrNewPasswordIsEmpty() {
		
		assertThrows(IllegalArgumentException.class, () -> userAccountService.changePassword("anna.parker@gmail.com", "anna@123", ""));
	}
	
	
	@AfterEach
	public void tearDown() {
		userAccountService = null;
	}
}









