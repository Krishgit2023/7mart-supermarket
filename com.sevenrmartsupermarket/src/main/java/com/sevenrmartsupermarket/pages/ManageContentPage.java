package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageContentPage {

	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility;

	@FindBy(xpath = "//p[contains(text(),'Manage Content')]")
	private WebElement manageContentElement;
	@FindBy(xpath = "//p[contains(text(),'Manage Pages')]")
	private WebElement managePageElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement titleElement;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	private WebElement descriptionElement;
	@FindBy(xpath = "//input[@id='page']")
	private WebElement pageNameElement;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUploadElement;
	@FindBy(xpath = "//button[@name = 'create']")
	private WebElement saveButtonElement;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlertElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[5]//i[@class='fas fa-edit']")
	private WebElement editActionElement;

	public ManageContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageContent() {
		manageContentElement.click();
	}

	public void clickOnManagePage() {
		managePageElement.click();
	}

	public void clickOnNewButton() {
		newButtonElement.click();
	}

	public void inputTitle(String title) {
		titleElement.sendKeys(title);
	}

	public void inputDescription(String description) {
		descriptionElement.sendKeys(description);
	}

	public void inputPageName(String pageName) {
		pageNameElement.sendKeys(pageName);
	}

	public void UploadImage(String imageName) {
		pageUtility = new PageUtility(driver);
		pageUtility.uploadFile(imageUploadElement, imageName);
	}

	public String getPageCreationSuccessAlert() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(successAlertElement);
	}

	public void addNewPages(String title, String description, String pageName, String imageName) {
		pageUtility = new PageUtility(driver);
		generalUtility = new GeneralUtility(driver);
		clickOnManageContent();
		clickOnManagePage();
		clickOnNewButton();
		inputTitle(title);
		inputDescription(description);
		inputPageName(pageName);
		UploadImage(imageName);
		pageUtility.scroll_and_click(saveButtonElement);
		generalUtility.backNavigation();
	}
	
	public void clickOnEditButton() {
		editActionElement.click();
	}
	
	public void editPage() {
		pageUtility = new PageUtility(driver);
		generalUtility = new GeneralUtility(driver);
		clickOnManageContent();
		clickOnManagePage();
		clickOnEditButton();
	}

}
