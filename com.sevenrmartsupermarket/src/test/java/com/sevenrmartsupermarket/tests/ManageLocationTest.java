package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageLocationPage;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageLocationTest extends Base {

	ManageLocationPage manageLocationPage;
	LoginPage loginPage;

	@Test
	public void verifyNewLocationCreation() {
		loginPage = new LoginPage(driver);
		manageLocationPage = new ManageLocationPage(driver);
		loginPage.loginUtility();
		manageLocationPage.createNewLocation("Lake Thelma", "500");
		String expectedAlertMessage = "×\nAlert!\nLocation Created Successfully";
		String actualAlertMessage = manageLocationPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test
	public void verifyLocationSearch() {
		loginPage = new LoginPage(driver);
		manageLocationPage = new ManageLocationPage(driver);
		loginPage.loginUtility();
		manageLocationPage.searchLocation();
		boolean actualResult = (manageLocationPage.is_SearchResultDisplayed());
		Assert.assertTrue(actualResult);

	}

}
