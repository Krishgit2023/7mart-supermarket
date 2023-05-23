package com.sevenrmartsupermarket.utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	static Faker faker = new Faker();

	public static String getFullName() {
		return faker.name().fullName();
	}

	public static String getFirstName() {
		return faker.name().firstName();
	}

	public static String getLastName() {
		return faker.name().lastName();
	}

	public static String getUsername() {
		return faker.name().username();
	}

	public static String getTitle() {
		return faker.name().title();
	}

}
