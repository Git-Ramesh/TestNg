package com.rs.selenium.app;

import java.util.Arrays;

import org.testng.TestNG;

public class FailedTestRunner {

	public static void main(String[] args) throws InterruptedException {
		TestNG testNG = new TestNG();
		testNG.setTestSuites(Arrays.asList(
					"D:\\Eclipse Workspace\\TestNG20190314\\selenium-demo\\test-output\\Failed suite [Default suite]\\testng-failed.xml"
				));
		testNG.run();
	}

}
