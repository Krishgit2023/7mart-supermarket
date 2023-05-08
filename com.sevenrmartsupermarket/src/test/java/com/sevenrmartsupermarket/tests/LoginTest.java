package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {

	LoginPage loginpage;

	@Test
	public void verfiyLogo() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		String actualLogoText = loginpage.getLogoText();
		String expectedLogoText = "7rmart supermarket";
		Assert.assertEquals(actualLogoText, expectedLogoText);
	}

	@Test
	public void verifyLoginFunctionality() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();
		String expectedProfileName = "Admin";
		String actualProfileName = loginpage.getProfileText();
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}

	@Test
	public void verifyLoginInvalidLoginErrorMessage() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility("avbshj", "dffhjg");
		String actualErrorMessage = loginpage.getErrorMessage();
		String expectedErrorMessage = "Alert!";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

	}

	@Test
	public void verifyRememberCheckBox() {
		loginpage = new LoginPage(driver);
		boolean actualResult = loginpage.is_RememberCheckBoxDisplayed();
		Assert.assertTrue(actualResult);
	}

	@Test
	public void verifySignInButtonEnabled() {
		loginpage = new LoginPage(driver);
		boolean actualResult = loginpage.is_SignInButtonEnabled();
		Assert.assertTrue(actualResult);
	}

}
