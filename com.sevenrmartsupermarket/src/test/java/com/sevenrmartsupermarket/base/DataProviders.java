package com.sevenrmartsupermarket.base;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "New User Creation")
	public Object[][] DataProviderDeliveryboyUserCreation() {
		return new Object[][] {
				{ "Deliveryboyuser", "deliveryboy@gmail.com", "1234567890", "XYZ address", "DeliveryUser",
						"Delivey@123" },
				{ "Deliveryboyusers", "deliveryboyusers@gmail.com", "8974267181", "ABC address", "Delivery23",
						"Delivery@1" } };
	}

}
