package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageUsersPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user']")
	private WebElement manageUserElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	private List<WebElement> nameElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[5]/td[6]/a[1]")
	private List<WebElement> actionLockElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[\"+i+\"]/td[6]/a[2]")
	private List<WebElement> actionDeleteElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchUserButtonElement;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchNameElement;
	@FindBy(xpath = "//input[@id='ph']")
	private WebElement searchPhoneNumberElement;
	@FindBy(xpath = "//input[@id='ut']")
	private WebElement searchEmailElement;
	@FindBy(xpath = "//select[@id='st']")
	private WebElement searchStatusElement;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchButtonElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody")
	private WebElement searchResultElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]//i[@class='fa fa-angle-double-down']")
	private WebElement passwordElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr//div[@class='profile-info-name']")
	private WebElement passwordResultElement;

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageUsers() {
		manageUserElement.click();
	}

	public void clickOnDeactivationButton(String name) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalUtility.GetTextOfElements(nameElement);
		int i;
		for (i = 0; i < userNames.size(); i++) {
			if (name.equals(userNames.get(i))) {
				i++;
				break;
			}
		}
		WebElement deactivateButton = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i + "]/td[6]/a[1]"));
		pageUtility.scroll_and_click(deactivateButton);
	}

	public String getUserCreationSuccessAlert() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(successAlertElement);
	}

	public void clickOnDeleteUserButton(String name) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalUtility.GetTextOfElements(nameElement);
		int i;
		for (i = 0; i < userNames.size(); i++) {
			if (name.equals(userNames.get(i))) {
				i++;
				break;
			}
		}
		WebElement deleteButton = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i + "]/td[6]/a[2]"));
		pageUtility.scroll_and_click(deleteButton);
		pageUtility.action_acceptAlert(deleteButton);

	}

	public void inputUserName(String userName) {
		searchNameElement.sendKeys(userName);
	}

	public void inputPhonenumber(String phoneNumber) {
		searchPhoneNumberElement.sendKeys(phoneNumber);
	}

	public void inputEmail(String email) {
		searchEmailElement.sendKeys(email);
	}

	public void clickOnSearchButton() {
		searchButtonElement.click();
	}

	public void searchUser(String usersName, String phoneNumber, String email, String userType) {
		pageUtility = new PageUtility(driver);
		searchUserButtonElement.click();
		inputUserName(usersName);
		inputPhonenumber(phoneNumber);
		inputEmail(email);
		pageUtility.select_ByVisibleText(userType, searchStatusElement);
		clickOnSearchButton();
	}

	public String getUserSearchResult() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(searchResultElement);
	}

	public void clickOnPasswordButton(String name) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalUtility.GetTextOfElements(nameElement);
		int i = 0;
		for (i = 0; i < userNames.size(); i++) {
			if (name.equals(userNames.get(i))) {
				i++;
				break;
			}
		}
		WebElement passwordButton = driver
				.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i
						+ "]/td[3]//i[@class='fa fa-angle-double-down']"));

		pageUtility.scroll_and_click(passwordButton);

	}

	public boolean is_PasswordDisplayed() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(passwordElement);

	}

}
