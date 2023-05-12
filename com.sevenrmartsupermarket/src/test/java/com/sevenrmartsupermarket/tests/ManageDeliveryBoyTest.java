package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermarket.pages.ManageUsersPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base {

	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginPage;

	@Test(dataProvider = "New DeliveryBoy User Creation Data", dataProviderClass = DataProviders.class)
	public void verifyDeliveryBoyNewUserCreations(String name, String email, String phoneNumber, String address,
			String userName, String password) {
		name = name + GeneralUtility.getTimeStamp();
		userName = userName + GeneralUtility.getTimeStamp();
		loginPage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.loginUtility();
		managedeliveryboypage.clickOnManageDeliverBoy();
		managedeliveryboypage.createUser(name, email, phoneNumber, address, userName, password);
		managedeliveryboypage.clickOnSaveButton();
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = managedeliveryboypage.getUserActionAlertMessage();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);

	}

	@Test
	public void verifySearchDeliveryListBoy() {
		loginPage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.loginUtility();
		managedeliveryboypage.clickOnManageDeliverBoy();
		managedeliveryboypage.searchListDeliveryBoy("Edmond", "test123@gmail.com", "1-449-599-4256");
		boolean actualResult = (managedeliveryboypage.is_SearchResultDisplayed());
		Assert.assertTrue(actualResult);

	}

}
