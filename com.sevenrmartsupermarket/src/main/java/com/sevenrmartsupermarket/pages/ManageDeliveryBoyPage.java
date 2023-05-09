package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;

	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	private WebElement manageDeliveryBoyElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameElement;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailElement;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberElement;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressElement;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButtonElement;
	@FindBy(xpath = "//h5[contains(text(),' Alert!')]")
	private WebElement userCreationAlertMessageElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	private List<WebElement> tableNameElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr//div[@class='profile-info-name']")
	private List<WebElement> passwordResultElement;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageDeliverBoy() {
		manageDeliveryBoyElement.click();
	}

	public void clickOnNewButton() {
		newButtonElement.click();
	}

	public void inputName(String name) {
		nameElement.sendKeys(name);
	}

	public void inputEmail(String email) {
		emailElement.sendKeys(email);
	}

	public void inputPhoneNumber(String phoneNumber) {
		phoneNumberElement.sendKeys(phoneNumber);
	}

	public void inputAddress(String address) {
		addressElement.sendKeys(address);
	}

	public void inputUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	public void inputPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void createUser(String name, String email, String phoneNumber, String address, String userName,
			String password) {
		clickOnManageDeliverBoy();
		clickOnNewButton();
		inputName(name);
		inputEmail(email);
		inputPhoneNumber(phoneNumber);
		inputAddress(address);
		inputUserName(userName);
		inputPassword(password);
	}

	public void clickOnSaveButton() {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		pageUtility.scroll_and_click(saveButtonElement);
	}

	public String getUserActionAlertMessage() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(userCreationAlertMessageElement);
	}
	
	public void clickOnPasswordButton(String name) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalUtility.GetTextOfElements(tableNameElement);
		int i = 0;
		for (i = 0; i < userNames.size(); i++) {
			if (name.equals(userNames.get(i))) {
				i++;
				break;
			}
		}
		WebElement passwordButton = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["+i+"]/td[7]"));

		pageUtility.scroll_and_click(passwordButton);

	}
	
	public List<String> getPassword() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.GetTextOfElements(passwordResultElement);
	}
	
	

}
