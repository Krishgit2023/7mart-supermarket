package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContentPage;
import com.sevenrmartsupermarket.pages.ManageSliderPage;

public class ManageSliderTest extends Base {

	ManageSliderPage manageSliderPage;
	LoginPage loginPage;

	@Test
	public void verifyNewSliderCreation() {
		loginPage = new LoginPage(driver);
		manageSliderPage = new ManageSliderPage(driver);
		loginPage.loginUtility();
		manageSliderPage.createNewSlider("website.jpg", "https://grocerysevenmart.com");
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageSliderPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test
	public void verifySliderUpdation() {
		loginPage = new LoginPage(driver);
		manageSliderPage = new ManageSliderPage(driver);
		loginPage.loginUtility();
		manageSliderPage.editSlider();
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageSliderPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

}
