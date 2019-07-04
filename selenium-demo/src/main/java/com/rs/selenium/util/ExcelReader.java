package com.rs.selenium.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String path = "D:\\Eclipse Workspace\\TestNG20190314\\selenium-demo\\src\\main\\resources\\login-details.xlsx";
		Workbook workbook = WorkbookFactory.create(new File(path));
		Sheet sheet = workbook.getSheet("gmail-credentials");
		System.out.println(sheet);
//		DataFormatter dataFormatter = new DataFormatter();
//		sheet.forEach(row -> {
//			row.forEach(cell -> {
//				System.out.print(dataFormatter.formatCellValue(cell) + "\t");
//			});
//			System.out.println();
//		});
//		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//
//		System.out.println(rowCount);
//		System.out.println(sheet.getFirstRowNum());
//		System.out.println(sheet.getLastRowNum());
//		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
//			Row row = sheet.getRow(i);
//			System.out.println("first cell" + row.getFirstCellNum());
//			System.out.println("last cell" + row.getLastCellNum());
//			for (int j = 0; j < row.getLastCellNum(); j++) {
//				Object[] arr = new Object[] {};
//				System.out.print(row.getCell(j).getStringCellValue() + "\t");
//			}
//			System.out.println();
//		}
		
		//getSheetData().forEach(arr -> System.out.println(Arrays.toString(arr)));
	}
	
	private static List<Object[]> getSheetData() throws EncryptedDocumentException, IOException {
		String path = "D:\\Eclipse Workspace\\TestNG20190314\\selenium-demo\\src\\main\\resources\\login-details.xlsx";
		List<Object[]> data = new ArrayList<>();
		Workbook workBook = ExcelReaderUtil.getWorkBook(new File(path));
		Sheet sheet = ExcelReaderUtil.getSheet(workBook, "gmail-credentials");
		if(sheet != null) {
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				List<Object> arr = new ArrayList<>();
				Row row = sheet.getRow(i);
				System.out.println("first cell" + row.getFirstCellNum());
				System.out.println("last cell" + row.getLastCellNum());
				for (int j = 0; j < row.getLastCellNum(); j++) {
					arr.add(row.getCell(j).getStringCellValue());
				}
				data.add(arr.toArray());
				arr.clear();
			}
		}
		return data;
	}
}
