package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageSliderPage {

	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility;

	@FindBy(xpath = "//p[contains(text(),'Manage Slider')]")
	private WebElement manageSliderElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButtonElement;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUploadElement;
	@FindBy(xpath = "//input[@id='link']")
	private WebElement linkElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButtonElement;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	private WebElement successAlertElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[4]/a[1]")
	private WebElement editElement;
	@FindBy(xpath = "//span[@class='fas fa-trash-alt']")
	private WebElement trashElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[4]/a[2]")
	private WebElement deleteElement;

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageSlider() {
		manageSliderElement.click();
	}

	public void clickOnNewButton() {
		newButtonElement.click();
	}

	public void UploadImage(String imageName) {
		pageUtility = new PageUtility(driver);
		pageUtility.uploadFile(imageUploadElement, imageName);
	}

	public void inputLink(String link) {
		linkElement.sendKeys(link);
	}

	public void clickOnSaveButton() {
		submitButtonElement.click();
	}

	public String getSuccessAlert() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(successAlertElement);
	}

	public void createNewSlider(String imageName, String link) {
		clickOnManageSlider();
		clickOnNewButton();
		UploadImage(imageName);
		inputLink(link);
		clickOnSaveButton();
	}

	public void clickOnEditButton() {
		editElement.click();
	}

	public void clickOnTrashButton() {
		trashElement.click();
	}

	public void clickOnDeleteButton() {
		deleteElement.click();
	}

	public void editSlider() {
		pageUtility = new PageUtility(driver);
		clickOnManageSlider();
		clickOnEditButton();
		clickOnTrashButton();
		pageUtility.action_acceptAlert(trashElement);
		clickOnSaveButton();
		clickOnDeleteButton();
		pageUtility.action_acceptAlert(deleteElement);

	}

}
