package com.rs.app;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SoftAssertionTest {

	private SoftAssert softAssert;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		this.softAssert = new SoftAssert();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		this.softAssert = null;
	}

	@Test
	public void test() {
		System.out.println("test");
		System.out.println("Open login page");
		System.out.println("Enter credentials");
		Assert.assertTrue(true); // Hard Assert
		System.out.println("View Profile");
		this.softAssert.assertTrue(false); // Soft Assert
		System.out.println("Change profile name");
		this.softAssert.assertAll();
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}

}
