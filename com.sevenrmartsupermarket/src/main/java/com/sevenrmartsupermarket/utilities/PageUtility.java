package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.constants.Constants;

public class PageUtility {
	WebDriver driver;
	JavascriptExecutor javascriptExecutor;
	Select select;

	public PageUtility(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * method to Scroll to an element
	 */

	public void scroll_into_view(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * method to Scroll and Click an element
	 */

	public void scroll_and_click(WebElement element) {
		int x = 0;
		javascriptExecutor = (JavascriptExecutor) driver;
		while (!is_Clicked(element)) {
			javascriptExecutor.executeScript("window.scrollBy(0," + x + ")");
			x = x + 20;
		}
	}

	public boolean is_Clicked(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * method to select element by visible text
	 */

	public void select_ByVisibleText(String text, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(text);

	}

	/**
	 * method to select element by index
	 */

	public void select_ByIndex(int index, WebElement element) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * method to select element by value
	 */

	public void select_ByValue(String value, WebElement element) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * method to mouse over the element
	 */

	public void action_MoveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * method to double click the element
	 */

	public void action_DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	/**
	 * method to drag and drop the element
	 */

	public void action_DragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	/**
	 * method to right click the element
	 */

	public void action_RightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	/**
	 * method to Accept Alert
	 */

	public void action_acceptAlert(WebElement element) {
		driver.switchTo().alert().accept();
	}

	/**
	 * method to dismiss Alert
	 */

	public void action_dismissAlert(WebElement element) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * method to give text value in the text field of an alert
	 */

	public void action_giveTextInAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	/**
	 * method to upload File
	 */

	public void uploadFile(WebElement element, String fileName) {
		try {
			File file = new File(Constants.IMAGE_DIRECTORY + fileName);
			element.sendKeys(file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
