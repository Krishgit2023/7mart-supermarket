package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.base.DataProviders;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageSliderPage;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base {

	LoginPage loginPage;
	PushNotificationPage pushnotificationpage;

	@Test(dataProvider = "Push Notification Data", dataProviderClass = DataProviders.class)
	public void verifyPushNotifications(String title, String description) {
		loginPage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationPage(driver);
		loginPage.loginUtility();
		pushnotificationpage.sendPushNotification(title, description);
		String expectedAlertMessage = "Alert!";
		String actualAlertMessage = pushnotificationpage.getUserActionAlertMessage();
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
	}

}
