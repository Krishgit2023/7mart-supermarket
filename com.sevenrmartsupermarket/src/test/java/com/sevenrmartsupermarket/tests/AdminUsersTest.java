package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	LoginPage loginpage;
	AdminUsersPage adminUsersPage;

	@Test(dataProvider = "New Admin User Creation", dataProviderClass = DataProviders.class)
	public void verifyAdminUserCreation(String usersName, String password, String userType) {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		usersName = usersName + GeneralUtility.getTimeStamp();
		adminUsersPage.createAdminUser(usersName, password, userType);
		String expectedAlertMessage = "×\nAlert!\nUser Created Successfully";
		String actualAlertMessage = adminUsersPage.getUserCreationSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
		//edit this to another test
		adminUsersPage.clickOnLogout();
		loginpage.loginUtility(usersName, password);
		String expectedProfileName = usersName;
		String actualProfileName = loginpage.getProfileText();
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	@Test
	public void verifyExistingAdminUserAlert() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		adminUsersPage.createAdminUser("Krishna", "K@123", "Staff");
		String expectedAlertMessage = "×\nAlert!\nUsername already exists.";
		String actualAlertMessage = adminUsersPage.getExistingUserAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@Test(groups = "Sanity")
	public void verifyUserStatusChangingFunctionality() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		adminUsersPage.clickOnDeactivationButton("News User1");
		String expectedAlertMessage = "×\nAlert!\nUser Status Changed Successfully";
		String actualAlertMessage = adminUsersPage.getUserCreationSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test
	public void verifyDeleteUserFunctionality() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		adminUsersPage.clickOnDeleteUserButton("AdminUser10_05_2023_01_23_08");
		String expectedAlertMessage = "×\nAlert!\nUser Deleted Successfully";
		String actualAlertMessage = adminUsersPage.getUserCreationSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@Test
	public void verifySearchUserFunctionality() {
		loginpage = new LoginPage(driver);
		adminUsersPage = new AdminUsersPage(driver);
		loginpage.loginUtility();
		adminUsersPage.clickOnAdminUsers();
		adminUsersPage.searchAdminUser("News User1", "Staff");
		boolean actualResult = (adminUsersPage.is_SearchResultDisplayed());
		Assert.assertTrue(actualResult);
	}

}
