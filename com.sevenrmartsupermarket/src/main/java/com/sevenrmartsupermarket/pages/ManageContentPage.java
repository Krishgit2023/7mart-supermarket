package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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

	public ManageContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

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
	@FindBy(xpath = "//h5[contains(text(),' Alert!')]")
	private WebElement successAlertElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[5]//i[@class='fas fa-edit']")
	private WebElement editActionElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	private List<WebElement> tableElements;
	@FindBy(xpath = "//p[contains(text(),'Manage Footer Text')]")
	private WebElement footerTextElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[4]/a")
	private WebElement footerEditActionElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButtonElement;
	@FindBy(xpath = "//p[contains(text(),'Manage News')]")
	private WebElement manageNewsElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newsPageNewButtonElement;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enterNewsElement;

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

	public String getSuccessAlert() {
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

	public void clickOnDeleteUserButton(String name) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalUtility.GetTextOfElements(tableElements);
		int i;
		for (i = 0; i < userNames.size(); i++) {
			if (name.equals(userNames.get(i))) {
				i++;
				break;
			}
		}
		WebElement deleteButton = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i + "]/td[5]/a[2]"));
		pageUtility.scroll_and_click(deleteButton);
		pageUtility.action_acceptAlert(deleteButton);
	}

	public void clickOnFooterText() {
		footerTextElement.click();
	}

	public void clickOnFooterEditActionButton() {
		footerEditActionElement.click();
	}

	public void clickOnUpdateButton() {
		submitButtonElement.click();
	}

	public void updateFooterText() {
		clickOnManageContent();
		clickOnFooterText();
		clickOnFooterEditActionButton();
		clickOnUpdateButton();
	}

	public void clickOnManageNews() {
		manageNewsElement.click();
	}

	public void clickOnNewsPageNewButton() {
		newsPageNewButtonElement.click();
	}

	public void inputNews(String news) {
		enterNewsElement.sendKeys(news);
	}

	public void clickonSaveButton() {
		submitButtonElement.click();
	}

	public void createNews(String news) {
		clickOnManageContent();
		clickOnManageNews();
		clickOnNewsPageNewButton();
		inputNews(news);
		clickonSaveButton();
	}

}
