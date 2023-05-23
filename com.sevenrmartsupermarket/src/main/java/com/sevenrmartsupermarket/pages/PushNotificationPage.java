package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class PushNotificationPage {
	WebDriver driver;
	LoginPage loginpage;
	GeneralUtility generalUtility;

	public PushNotificationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@class='nav-item']//p[contains(text(),'Push Notifications')]")
	private WebElement pushNotificationElement;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleElement;
	@FindBy(xpath = "//input[@id='description']")
	private WebElement descriptionElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement sendButtonElement;
	@FindBy(xpath = "//h5[contains(text(),' Alert!')]")
	private WebElement successAlertElement;

	public String getUserActionAlertMessage() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(successAlertElement);
	}

	public void sendPushNotification(String title, String description) {
		pushNotificationElement.click();
		titleElement.sendKeys(title);
		descriptionElement.sendKeys(description);
		sendButtonElement.click();

	}

}
