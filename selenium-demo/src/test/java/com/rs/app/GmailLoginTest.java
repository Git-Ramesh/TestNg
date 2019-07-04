package com.rs.app;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rs.selenium.analyzer.RetryAnalyzer;
import com.rs.selenium.constant.Browser;
import com.rs.selenium.util.ExcelReaderUtil;
import com.rs.selenium.util.SeleniumUtil;
import com.rs.selenium.util.WebDriverFactory;

import net.bytebuddy.jar.asm.commons.AnalyzerAdapter;

public class GmailLoginTest {
	WebDriver webDriver = null;
	String path = "D:\\Eclipse Workspace\\TestNG20190314\\selenium-demo\\src\\main\\resources\\login-details.xlsx";

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		webDriver = WebDriverFactory.newInstance(Browser.CHROME);
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			webDriver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
			webDriver.get("https://accounts.google.com");
		}
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod");
		webDriver.quit();
	}

	@Test(dataProvider = "getSheetData")
	public void testGmailLogin(String email, String pass) throws InterruptedException {
		SeleniumUtil.printThreadInfo();
		String emailXpath = "//input[@id='identifierId']";
		String nextXpath = "//span[@class='RveJvd snByac']";
		String passwordXpath = "//input[@name='password']";
		String nextXpath1 = "//span[contains(text(),'Next')]";
		webDriver.findElement(By.xpath(emailXpath)).sendKeys(email);
		webDriver.findElement(By.xpath(nextXpath)).click();
		webDriver.findElement(By.xpath(passwordXpath))
				.sendKeys(new String(Base64.getDecoder().decode(pass.getBytes())));
		webDriver.findElement(By.xpath(nextXpath1)).click();
		SeleniumUtil.sleep(2, TimeUnit.SECONDS);
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void testFail() {
		SeleniumUtil.printThreadInfo();
		fail();
	}

//	@DataProvider
//	public Object[][] dp() {
//		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
//	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite");
	}

	@DataProvider
	private Iterator<Object[]> getSheetData() throws EncryptedDocumentException, IOException {
		List<Object[]> data = new ArrayList<>();
		Workbook workBook = ExcelReaderUtil.getWorkBook(new File(path));
		Sheet sheet = ExcelReaderUtil.getSheet(workBook, "gmail-credentials");
		if (sheet != null) {
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				List<Object> arr = new ArrayList<>();
				Row row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					arr.add(row.getCell(j).getStringCellValue());
				}
				data.add(arr.toArray());
				arr.clear();
			}
		}
		return data.iterator();
	}

}
