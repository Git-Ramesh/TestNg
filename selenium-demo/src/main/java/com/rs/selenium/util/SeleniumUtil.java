package com.rs.selenium.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SeleniumUtil {
	public static void sleep(long timeout, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(timeout);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	public static void captureScreenshot(WebDriver webDriver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) webDriver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
	
	public static void printThreadInfo() {
		System.out.println("Thread? " + Thread.currentThread());
	}
}
