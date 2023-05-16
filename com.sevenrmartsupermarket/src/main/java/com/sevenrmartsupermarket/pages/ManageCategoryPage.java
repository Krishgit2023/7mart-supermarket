package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class ManageCategoryPage {

	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility;
	Select select;

	@FindBy(xpath = "//p[contains(text(),'Manage Category')]")
	private WebElement manageCategoryElement;
	@FindBy(xpath = "//p[text()='Category']")
	private WebElement categoryElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newCategoryButtonElement;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categoryFieldElement;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement groupSelectionElement;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement imageUploadElement;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButtonElement;
	@FindBy(xpath = "//h5[contains(text(),' Alert!')]")
	private WebElement successAlertElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchElement;
	@FindBy(xpath = "//input[@name='un']")
	private WebElement searchCategoryElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody")
	private WebElement searchResultElement;
	@FindBy(xpath = "//p[text()='Sub Category']")
	private WebElement subCategoryElement;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement categoryInfofieldElement;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement subCategoryfieldElement;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	private List<WebElement> tableElements;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageCategory() {
		manageCategoryElement.click();
	}

	public void clickOnCategory() {
		categoryElement.click();
	}

	public void clickOnNewCategoryButton() {
		newCategoryButtonElement.click();
	}

	public void inputCategory(String category) {
		categoryFieldElement.sendKeys(category);
	}

	public void inputGroups() {
		groupSelectionElement.click();
	}

	public void UploadImage(String imageName) {
		pageUtility = new PageUtility(driver);
		pageUtility.uploadFile(imageUploadElement, imageName);
	}

	public String getSuccessAlert() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.get_textOFElement(successAlertElement);
	}

	public void createNewCategory(String category, String imageName) {
		clickOnManageCategory();
		clickOnCategory();
		clickOnNewCategoryButton();
		inputCategory(category);
		inputGroups();
		UploadImage(imageName);
		pageUtility.scroll_and_click(submitButtonElement);
	}

	public void clickOnSearchCategoryButton() {
		searchElement.click();
	}

	public void inputSearchCategory(String category) {
		searchCategoryElement.sendKeys(category);
	}

	public void clickOnSubmitButton() {
		submitButtonElement.click();
	}

	public boolean is_SearchResultDisplayed() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_Displayed(searchResultElement);

	}

	public void searchForCategory(String category) {
		clickOnManageCategory();
		clickOnCategory();
		clickOnSearchCategoryButton();
		inputSearchCategory(category);
		clickOnSubmitButton();
	}

	public void clickOnSubCategory() {
		subCategoryElement.click();
	}

	public void inputCategoryInfo(String category) {
		select = new Select(categoryInfofieldElement);
		select.selectByVisibleText(category);
	}

	public void inputSubCategory(String subCategory) {
		subCategoryfieldElement.sendKeys(subCategory);
	}

	public void createNewsubCategory(String category, String subCategory, String imageName) {
		clickOnManageCategory();
		clickOnSubCategory();
		clickOnNewCategoryButton();
		inputCategoryInfo(category);
		inputSubCategory(subCategory);
		UploadImage(imageName);
		clickOnSubmitButton();
	}

	public void clickOnDeleteSubCategoryButton(String subCategoryName) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);

		List<String> categoryNames = new ArrayList<String>();
		categoryNames = generalUtility.GetTextOfElements(tableElements);
		int i;
		for (i = 0; i < categoryNames.size(); i++) {
			if (subCategoryName.equals(categoryNames.get(i))) {
				i++;
				break;
			}
		}
		WebElement deleteButton = driver.findElement(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[" + i + "]/td[5]/a[2]"));
		pageUtility.scroll_and_click(deleteButton);
		pageUtility.action_acceptAlert(deleteButton);
	}

}
