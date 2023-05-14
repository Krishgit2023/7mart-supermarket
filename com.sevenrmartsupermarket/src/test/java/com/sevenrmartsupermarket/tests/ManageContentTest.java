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
		String actualAlertMessage = manageContentPage.getPageCreationSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}
	
	@Test
	public void verifyEditPageFunctionality() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		manageContentPage.editPage();
		
	}
	
	@Test
	public void verifyDeletePageFunctionality() {
		
	}

}
