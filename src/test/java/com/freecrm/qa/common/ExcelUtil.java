package com.freecrm.qa.common;

import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private static String userHomeDir = FileUtils.getUserDirectory().getAbsolutePath();
	private static String testDataRelativeDirectory = Config.getProperty("testDataRelativeDirectory");
	private static String testDataExcelFile = Config.getProperty("testDataExcelFile");
	public static String testDataExcelFilePath = userHomeDir + testDataRelativeDirectory + testDataExcelFile;

	static Workbook workbook;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(testDataExcelFilePath);
			// workbook = WorkbookFactory.create(file);
			// Create Workbook instance for xlsx/xls file input stream
			if (testDataExcelFile.toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (testDataExcelFile.toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
