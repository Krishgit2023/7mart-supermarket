package com.sevenrmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * method to get text of the element
	 * 
	 * @param element
	 * @return string
	 */

	public String get_textOFElement(WebElement element) {
		return element.getText();
	}

	/**
	 * method to get text of list of elements
	 * 
	 * @param listOfElements
	 * @return list<string>
	 */

	public List<String> GetTextOfElements(List<WebElement> Listofelements) {
		List<String> text = new ArrayList<String>();
		for (WebElement element : Listofelements) {
			String data = element.getText();
			text.add(data);

		}
		return text;
	}

	/**
	 * method to check element is displayed
	 * 
	 * @param element
	 * @return boolean
	 */

	public boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * method to check element is enabled
	 * 
	 * @param element
	 * @return boolean
	 */

	public boolean is_enabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * method to check element is selected
	 * 
	 * @param element
	 * @return boolean
	 */

	public boolean is_selected(WebElement element) {
		return element.isSelected();

	}

	/**
	 * method to get attribute
	 */

	public String get_Attribute(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	/**
	 * method to get css properties of an element
	 */

	public String get_CSSValue(WebElement element, String cssValue) {
		return element.getCssValue(cssValue);
	}

	/**
	 * method to switch window
	 */

	public void switchToWindow(String WindowId) {
		driver.getWindowHandle();
	}

	/**
	 * method to get text inside an alert
	 */

	public void action_getTextOfAlert(WebElement element) {
		driver.switchTo().alert().getText();
	}
	
	public static String getTimeStamp() {
		return new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
	}

}
