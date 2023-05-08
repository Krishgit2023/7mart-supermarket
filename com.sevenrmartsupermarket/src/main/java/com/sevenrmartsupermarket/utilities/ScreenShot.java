package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	TakesScreenshot takesScreenshot; // interface to capture screenshot

	public void takeScreenShot(WebDriver driver, String imageName) {
		try {
			takesScreenshot = (TakesScreenshot) driver;
			File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			// to get project path
			String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + imageName + " " + timeStamp + ".png";
			File finalDestination = new File(destination);
			FileHandler.copy(file, finalDestination);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
