package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContentPage;

public class ManageContentTest extends Base{
	
	ManageContentPage manageContentPage;
	LoginPage loginPage;
	
	@Test
	public void verifyNewPageCreation() {
		loginPage = new LoginPage(driver);
		manageContentPage = new ManageContentPage(driver);
		loginPage.loginUtility();
		manageContentPage.addNewPages("Test Title", "Test123", "Testing", "");
		
		
		
		
	}

}
