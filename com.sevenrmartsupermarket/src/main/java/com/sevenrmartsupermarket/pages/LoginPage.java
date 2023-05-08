package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fileinputstream;
	GeneralUtility generalUtility;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNamElement;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinButtonElement;
	@FindBy(xpath = "//div[@class='info']")
	private WebElement profileNameElement;
	@FindBy(xpath = "//label[@for='remember']")
	private WebElement rememberCheckBox;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement invalidLoginErrorMessage;
	@FindBy(xpath = "//span[@class='brand-text font-weight-light']")
	private WebElement sevenMartLogo;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileinputstream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNamElement.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickonSignInButton() {
		signinButtonElement.click();
	}

	public String getErrorMessage() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(invalidLoginErrorMessage);
	}

	public void loginUtility(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickonSignInButton();
	}

	public void loginUtility() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickonSignInButton();
	}

	public String getProfileText() {
		GeneralUtility generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(profileNameElement);
	}

	public String getLogoText() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(sevenMartLogo);
	}

	public boolean is_RememberCheckBoxDisplayed() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(rememberCheckBox);

	}

	public boolean is_SignInButtonEnabled() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_enabled(signinButtonElement);

	}

}
