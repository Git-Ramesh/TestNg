package com.rs.selenium.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderUtil {
	
	public static Workbook getWorkBook(File excelFile) throws EncryptedDocumentException, IOException {
		return WorkbookFactory.create(excelFile);
	}

	public static Sheet getSheet(Workbook workbook, String sheetName) {
		Sheet sheet = null;
		if (workbook != null) {
			sheet = workbook.getSheet(sheetName);
		}
		return sheet;
		

	}
}
