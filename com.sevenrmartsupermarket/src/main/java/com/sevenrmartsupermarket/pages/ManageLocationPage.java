package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class ManageLocationPage {

	WebDriver driver;
	GeneralUtility generalUtility;
	Select select;

	@FindBy(xpath = "//p[contains(text(),'Manage Location')]")
	private WebElement manageLocationElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "//select[@id='country_id']")
	private WebElement countryElement;
	@FindBy(xpath = "//select[@id='st_id']")
	private WebElement stateElement;
	@FindBy(xpath = "//input[@id='location']")
	private WebElement locationElement;
	@FindBy(xpath = "//input[@id='delivery']")
	private WebElement deliveryChargeElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButtonElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchLocationButtonElement;
	@FindBy(xpath = "//select[@id='country_id']")
	private WebElement searchCountryElement;
	@FindBy(xpath = "//select[@id='st_id']")
	private WebElement searchStateElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	private WebElement searchResultElement;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageLocation() {
		manageLocationElement.click();
	}

	public void clickOnNewButton() {
		newButtonElement.click();
	}

	public void inputCountry() {
		select = new Select(countryElement);
		select.selectByVisibleText("United Kingdom");
	}

	public void inputState() {
		select = new Select(stateElement);
		select.selectByVisibleText("Belfast");
	}

	public void inputLocation(String location) {
		locationElement.sendKeys(location);
	}

	public void inputDeliveryCharge(String deliveryCharge) {
		deliveryChargeElement.sendKeys(deliveryCharge);
	}

	public void clickOnSaveButton() {
		submitButtonElement.click();
	}

	public String getSuccessAlert() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(successAlertElement);
	}

	public void createNewLocation(String location, String deliveryCharge) {
		clickOnManageLocation();
		clickOnNewButton();
		inputCountry();
		inputState();
		inputLocation(location);
		inputDeliveryCharge(deliveryCharge);
		clickOnSaveButton();
	}

	public void clickOnSearchLocationButton() {
		searchLocationButtonElement.click();
	}

	public void inputSearchCountry() {
		select = new Select(searchCountryElement);
		select.selectByVisibleText("United Kingdom");
	}

	public void inputSearchState() {
		select = new Select(searchStateElement);
		select.selectByVisibleText("Aberdeen");
	}

	public void searchLocation() {
		clickOnManageLocation();
		clickOnSearchLocationButton();
		inputSearchCountry();
		inputSearchState();
		clickOnSaveButton();
	}

	public boolean is_SearchResultDisplayed() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(searchResultElement);

	}

}
