package com.rs.selenium.util;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rs.selenium.constant.Browser;

public class WebDriverFactory {
	
	public static WebDriver newInstance(Browser browser) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("selenium");
		WebDriver webDriver = null;

		switch (browser) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", resourceBundle.getString("webdriver.chrome.driver"));
			webDriver = new ChromeDriver();
			break;
		case FIREFOX:
			System.out.println(resourceBundle.getString("webdriver.gecko.driver"));
			System.setProperty("webdriver.gecko.driver", resourceBundle.getString("webdriver.gecko.driver"));
			webDriver = new FirefoxDriver();
			break;
		default:
			webDriver = null;
			break;
		}
		return webDriver;
	}
}
