package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	PageUtility pageUtility;

	@FindBy(xpath = "//li[18]//a[@class=' nav-link']//i[1]")
	private WebElement adminUsersElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameElement;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordElement;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeElement;
	@FindBy(xpath = "//div[@class='card-footer center']//button[@type='submit']")
	private WebElement saveButtonElement;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement alertElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[5]/td[5]/a[1]")
	private List<WebElement> actionLockElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	private List<WebElement> nameElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement userActionAlertMessageElement;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminUsers() {
		adminUsersElement.click();
	}

	public void clickOnNewButton() {
		newButtonElement.click();
	}

	public void inputUserName(String userName) {
		userNameElement.sendKeys(userName);
	}

	public void inputPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickOnSaveButton() {
		saveButtonElement.click();
	}

	public void createUser(String usersName, String password, String userType) {
		pageUtility = new PageUtility(driver);
		clickOnNewButton();
		inputUserName(usersName);
		inputPassword(password);
		pageUtility.select_ByVisibleText(userType, userTypeElement);
		clickOnSaveButton();
		getAlertMessage();

	}

	public String getAlertMessage() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(alertElement);

	}

	public String getSuccessMessage() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(successAlertElement);
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
				By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i + "]/td[5]/a[1]"));
		pageUtility.scroll_and_click(deactivateButton);
	}

	public String getUserActionAlertMessage() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(userActionAlertMessageElement);
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
				By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i + "]/td[5]/a[3]"));
		pageUtility.scroll_and_click(deleteButton);
		pageUtility.action_acceptAlert(deleteButton);

	}

}
