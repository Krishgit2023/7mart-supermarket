package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageContentPage {
	
	WebDriver driver;
	PageUtility pageUtility;
	
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
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButtonElement;
	
	
	public  ManageContentPage(WebDriver driver) {
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
		pageUtility.fileUpload(imageUploadElement, imageName);
	}
	
	public void clickOnSaveButton() {
		saveButtonElement.click();
	}
	
	public void addNewPages(String title, String description, String pageName, String imageName) {
		clickOnManageContent();
		clickOnManagePage();
		clickOnNewButton();
		inputTitle(title);
		inputDescription(description);
		inputPageName(pageName);
		UploadImage(imageName);
		clickOnSaveButton();
	}	
	
	
	
	
	


}
