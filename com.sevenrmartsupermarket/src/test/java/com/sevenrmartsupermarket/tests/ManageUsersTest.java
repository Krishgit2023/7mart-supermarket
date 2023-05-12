package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class ManageUsersTest extends Base {

	LoginPage loginpage;
	ManageUsersPage manageUsersPage;

	@Test(groups = "Sanity")
	public void verifySearchUser() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.searchUser("Tester", "7766554433", "#$%^^&&@gmail.com", "Active");
		String expectedAlertMessage = "Tester 7766554433\n#$%^^&&@gmail.com\nUser id : 334\nDetails\n01-May-2023 Active";
		String actualAlertMessage = manageUsersPage.getUserSearchResult();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@Test(groups = "Smoke")
	public void verifyUserStatusChangingFunctionality() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.clickOnDeactivationButton("Abhiramkrishnakumarsreenatest d");
		String expectedAlertMessage = "×\nAlert!\nUser Status Changed Successfully";
		String actualAlertMessage = manageUsersPage.getUserCreationSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyDeleteUser() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.clickOnDeleteUserButton("Tester");
		String expectedAlertMessage = "×\nAlert!\nUser Informations Deleted Successfully";
		String actualAlertMessage = manageUsersPage.getUserCreationSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test(groups = "Smoke")
	public void verifyPassword() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.clickOnPasswordButton("Anjaly A");
		boolean actualResult = (manageUsersPage.is_PasswordDisplayed());
		Assert.assertTrue(actualResult);

	}

}
