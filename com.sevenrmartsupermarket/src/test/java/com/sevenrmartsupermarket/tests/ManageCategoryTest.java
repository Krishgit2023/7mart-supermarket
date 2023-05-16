package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageCategoryPage;
import com.sevenrmartsupermarket.pages.ManageContentPage;

public class ManageCategoryTest extends Base {

	ManageCategoryPage manageCategoryPage;
	LoginPage loginPage;

	@Test
	public void verifyNewCategoryCreation() {
		loginPage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginPage.loginUtility();
		manageCategoryPage.createNewCategory("Heavy duty Dress", "website.jpg");
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageCategoryPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

	@Test
	public void verifyCategorySearch() {
		loginPage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginPage.loginUtility();
		manageCategoryPage.searchForCategory("Small Marble Chair");
		boolean actualResult = (manageCategoryPage.is_SearchResultDisplayed());
		Assert.assertTrue(actualResult);
	}

	@Test
	public void verifyNewSubCategoryCreation() {
		loginPage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginPage.loginUtility();
		manageCategoryPage.createNewsubCategory("Electronics", "Mobile", "website.jpg");
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageCategoryPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@Test
	public void verifySubCategoryDeleteFunctionality() {
		loginPage = new LoginPage(driver);
		manageCategoryPage = new ManageCategoryPage(driver);
		loginPage.loginUtility();
		manageCategoryPage.clickOnManageCategory();
		manageCategoryPage.clickOnSubCategory();
		manageCategoryPage.clickOnDeleteSubCategoryButton("Zucchini");
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = manageCategoryPage.getSuccessAlert();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

}
