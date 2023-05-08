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

	public void waitForElemenetToBeVisible(String xpath) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void waitForElemenetToBeVisible(WebElement element) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElemenetToBeClickable(String xpath) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void waitForElemenetToBeClickable(WebElement element) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElemenetToBeInvisible(String xpath) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public void waitForElemenetToBeInvisible(WebElement element) {
		Wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		Wait.until(ExpectedConditions.invisibilityOf(element));
	}

}
