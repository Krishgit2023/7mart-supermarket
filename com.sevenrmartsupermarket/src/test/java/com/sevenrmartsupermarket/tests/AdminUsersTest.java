package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	AdminUsersPage adminUsersPage;

	@Test(groups = "Smoke")
	public void verifyAdminUsers() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		adminUsersPage.createUser("usersName10", "password9", "Staff");
		String actualAlertMessage = adminUsersPage.getAlertMessage();
		String expectedAlertMessage = "Alert!";
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@Test(enabled = true)
	public void verifySuccessUserCreationAlert() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		String user = "User1" + GeneralUtility.getTimeStamp();
		adminUsersPage.createUser(user, "password9", "Staff");
		String expectedAlertMessage = "×\r\n" + "Alert!\r\n" + "User Created Successfully";
		String actualAlertMessage = adminUsersPage.getSuccessMessage();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test(groups = "Sanity")
	public void verifyUserStatusChangingFunctionality() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		adminUsersPage.clickOnDeactivationButton("krish_mg");
		System.out.println(adminUsersPage.getUserActionAlertMessage());
	}

	@Test
	public void verifyDeleteUser() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		adminUsersPage.clickOnDeleteUserButton("usersName11");
		System.out.println(adminUsersPage.getUserActionAlertMessage());
	}
}
