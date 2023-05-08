package com.sevenrmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.PushNotificationPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class PushNotificationTest extends Base{
	PushNotificationPage pushnotificationpage;
	ExcelReader excelreader=new ExcelReader();

	
	@Test
	public void verifyPushNotification() {
		pushnotificationpage= new PushNotificationPage (driver);
		pushnotificationpage.clickPushNotification();
		excelreader.setExcelFile("Pushnotificationdata", "notificationdata");
		String title=excelreader.getCellData(1,0 );
		System.out.println(title);
		//excelreader.setExcelFile(title, title);we can give next one here
		
	
 
}

}
