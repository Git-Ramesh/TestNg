package com.rs.app;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppTest {
	static {
		System.out.println("AppTest: static block");
	}

	public AppTest() {
		System.out.println("AppTest: 0-param constr");
	}

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("@BeforeClass");

	}

	@AfterClass
	public static void  tearDownAfterClass() {
		System.out.println("@AfterClass");
	}

	@BeforeTest
	public void setUpBeforeTest() {
		System.out.println("@BeforeTest");
	}

	@AfterTest
	public void tearDownAfterTest() {
		System.out.println("@AfterTest");
	}

	@Test
	public void test() {
		System.out.println("test");
	}

	@Test
	public void test1() {
		System.out.println("test1");
	}
}
