package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationPage {
	WebDriver driver;
	LoginPage loginpage;
	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Push Notifications')]")
	private WebElement pushNotification;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickPushNotification() {
		loginpage = new LoginPage(driver);
		loginpage.loginUtility();

	}

}
