package com.training.tests.pack3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.training.UserAccountService;

@DisplayName("Test UserAccountService")
public class UserAccountServiceTest {

	private UserAccountService userAccountService;

	@BeforeEach
	public void setUp() {
		userAccountService = new UserAccountService();
	}

	@Nested
	@DisplayName("Test Login")
	class AuthenticateTest {

		@Test
		@DisplayName("Test authenticate with correct credentials")		
		public void autheticate_Should_Return_True_WhenCredentialsAreValid() {

			assertTrue(userAccountService.authenticate("anna.parker@gmail.com", "anna@123"));
		}

		@Test
		@DisplayName("Test authenticate with wrong credentials")
		public void authenticate_Should_Return_False_WhenCredentialsAreIncorrect() {

			assertFalse(userAccountService.authenticate("kathy.sierra@gmail.com", "kathy123"));
		}

		@Test
		@DisplayName("Test authenticate when empty username or password is provided")		
		public void autheticate_Should_Throw_Exception_WhenEmptyUsernameOrPasswordIsProvided() {

			assertThrows(IllegalArgumentException.class, () -> userAccountService.authenticate("", "alex@123"));
		}
	}

	@Nested
	@DisplayName("Test ResetPasswordLink")
	class ResetPasswordLinkTest {

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
	}

	@Nested
	@Tag("feature-3")
	class ChangePasswordTest {

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

			assertThrows(IllegalArgumentException.class,
					() -> userAccountService.changePassword("anna.parker@gmail.com", "anna@123", ""));
		}
	}

	@AfterEach
	public void tearDown() {
		userAccountService = null;
	}
}
