package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriverWait Wait;
	WebDriver driver;
	public static final long IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT = 20;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToBeVisible(String xpath) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void waitForElementToBeVisible(WebElement element) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(String xpath) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void waitForElementToBeClickable(WebElement element) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeInvisible(String xpath) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public void waitForElementToBeInvisible(WebElement element) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	//add fluent wait 
	//alert to be visible -explivit wait

}
