package com.rs.selenium.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.rs.selenium.constant.Browser;
import com.rs.selenium.util.WebDriverFactory;

public class AmazonApp {
	public static void main(String[] args) {
		WebDriver webDriver = WebDriverFactory.newInstance(Browser.FIREFOX);
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
			webDriver.get("https://www.amazon.in/");
		}
		JavascriptExecutor jse = (JavascriptExecutor) webDriver;
		getTodayDeals(webDriver);
		jse.executeScript("scroll(0, 400)");
		webDriver.findElement(By.xpath("//span[@class='a-label a-checkbox-label'][contains(text(),'Books')]")).click();
	}

	private static void getTodayDeals(WebDriver webDriver) {
		String xpath = "//a[contains(text(),\"Today's Deals\")]";
		webDriver.findElement(By.xpath(xpath)).click();
	}

}
