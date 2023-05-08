package com.sevenrmartsupermarket.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;
import com.sevenrmartsupermarket.utilities.ScreenShot;

public class ManageUsersTest extends Base {

	LoginPage loginpage;
	ManageUsersPage manageUsersPage;
	//ScreenShot screenShot;

	@Test(groups = "Smoke")
	public void verifyUserStatusChangingFunctionality() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.clickOnDeactivationButton("Abhiramkrishnakumarsreenatest d");
	}

	@Test(groups = {"Smoke","Sanity"})
	public void verifyDeleteUser() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.clickOnDeleteUserButton("abc1 Bala");
	}

	@Test(groups = "Sanity")
	public void verifySearchUser() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		//screenShot = new ScreenShot();
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.searchUser("Shabana Sulthana S L", "9567396119", "shabanassl@gmail.com", "Active");
		System.out.println(manageUsersPage.getSearchResult());
		
	}

	@Test(groups = "Smoke")
	public void verifyPassword() {
		loginpage = new LoginPage(driver);
		manageUsersPage = new ManageUsersPage(driver);
		loginpage.loginUtility();
		manageUsersPage.clickOnManageUsers();
		manageUsersPage.clickOnPasswordButton("Tester");
		System.out.println(manageUsersPage.getPassword());

	}

}
