package com.sevenrmartsupermarket.base;

import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders {

	ExcelReader excelReader = new ExcelReader();

	@DataProvider(name = "New DeliveryBoy User Creation")
	public Object[][] DataProviderDeliveryboyUserCreation() {
		return new Object[][] {
				{ "Deliveryboyuser", "deliveryboy@gmail.com", "1234567890", "XYZ address", "DeliveryUser",
						"Delivey@123" },
				{ "Deliveryboyusers", "deliveryboyusers@gmail.com", "8974267181", "ABC address", "Delivery23",
						"Delivery@1" } };
	}

	@DataProvider(name = "New DeliveryBoy User Creation Data")
	public Object[][] DataProviderDeliveryboyCreationData() {
		excelReader.setExcelFile("Deliveryboy", "Deliveryboy data");
		Object data[][] = excelReader.getMultidimentionalData(3, 6);
		return data;
	}

	@DataProvider(name = "New Admin User Creation")
	public Object[][] DataProviderAdminUserCreation() {
		return new Object[][] { { "Krishna", "Krishna@123", "Staff" }, { "Krishna", "Krishna@123", "Admin" },
				{ "Krishna", "Krishna@123", "Partner" }, { "Krishna", "Krishna@123", "Delivery Boy" } };
	}


}
