package com.rs.app;

import static org.testng.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.rs.selenium.constant.Browser;
import com.rs.selenium.listener.CustomTestListener;
import com.rs.selenium.util.SeleniumUtil;
import com.rs.selenium.util.WebDriverFactory;

@Listeners(CustomTestListener.class)
public class TakeFailedTestScreenshootTest {
	private WebDriver webDriver;

	static {
		System.out.println("static block");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		webDriver = WebDriverFactory.newInstance(Browser.CHROME);
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
			webDriver.get("https://google.com");
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("@AfterMethod");
		if (ITestResult.FAILURE == result.getStatus() ) {
			SeleniumUtil.captureScreenshot(webDriver, result.getName());
		}
			
		webDriver.quit();
	}

	@Test
	public void test() {
		System.out.println("test");
		fail();
	}

}
