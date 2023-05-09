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
	
	@Test(dataProvider = "New User Creation", dataProviderClass = DataProviders.class)
	public void verifyDeliveryBoyNewUserCreation(String name, String email, String phoneNumber, String address, String userName,
			String password) {
		name = name+GeneralUtility.getTimeStamp();
		userName = userName+GeneralUtility.getTimeStamp();
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
	
	@Test(enabled = true) // pending task - need to check for assertion
	public void verifyPassword() {
		loginPage = new LoginPage(driver);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		loginPage.loginUtility();
		managedeliveryboypage.clickOnManageDeliverBoy();
		managedeliveryboypage.clickOnPasswordButton("Tester");
		System.out.println(managedeliveryboypage.getPassword());
		

	}

}
