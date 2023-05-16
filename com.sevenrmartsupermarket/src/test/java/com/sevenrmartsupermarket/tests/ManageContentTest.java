package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContentPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageContentTest extends Base {

	ManageContentPage manageContentPage;
	LoginPage loginPage;

	@Test
	public void verifyNewPageCreation() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		String Title = "Title" + GeneralUtility.getTimeStamp();
		String PageName = "Page" + GeneralUtility.getTimeStamp();
		loginPage.loginUtility();
		manageContentPage.addNewPages(Title, "Test123", PageName, "website.jpg");
		String expectedAlertMessage = "×\nAlert!\nPage Created Successfully";
		String actualAlertMessage = manageContentPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test // to do
	public void verifyEditPageFunctionality() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		manageContentPage.editPage();
	}

	@Test
	public void verifyDeletePageFunctionality() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		manageContentPage.clickOnManageContent();
		manageContentPage.clickOnManagePage();
		manageContentPage.clickOnDeleteUserButton("dfvd");
		String expectedAlertMessage = "×\nAlert!\nPage Deleted Successfully";
		String actualAlertMessage = manageContentPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);  // add message
	}

	@Test
	public void verifyFooterTextUpdation() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		manageContentPage.updateFooterText();
		String expectedAlertMessage = "×\nAlert!\nFooter Text Updated Successfully";
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
		String expectedAlertMessage = "×\nAlert!\nNews Created Successfully";
		String actualAlertMessage = manageContentPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

}
