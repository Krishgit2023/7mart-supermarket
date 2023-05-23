package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContentPage;
import com.sevenrmartsupermarket.utilities.FakerUtility;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageContentTest extends Base {

	ManageContentPage manageContentPage;
	LoginPage loginPage;

	@Test
	public void verifyNewPageCreation() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		String Title = "Title" + FakerUtility.getTitle();
		String PageName = "Page" + FakerUtility.getTitle();
		loginPage.loginUtility();
		manageContentPage.addNewPages(Title, "Test123", PageName, "website.jpg");
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageContentPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Page created Successfully");
	}

	@Test
	public void verifyDeletePageFunctionality() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		manageContentPage.clickOnManageContent();
		manageContentPage.clickOnManagePage();
		manageContentPage.clickOnDeleteUserButton("dfvd");
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageContentPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "Page Deleted Succesfully");
	}

	@Test
	public void verifyFooterTextUpdation() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		manageContentPage.updateFooterText();
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageContentPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test
	public void verifyNewsCreation() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		String news = "News" + GeneralUtility.getTimeStamp();
		manageContentPage.createNews(news);
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageContentPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

}
