package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstMavenProject {

	public static void main(String[] args) throws IOException {
		
		
		
		//Mention the path of excel sheet
		File file = new File("D:\\PRADEEP\\Excel\\Data.xlsx");
		
		//Get the objects/byte from file
		FileInputStream stream = new FileInputStream(file);
		
		//Create Workbook
		Workbook workbook = new XSSFWorkbook(stream);
		
		//Get the sheet
		Sheet sheet = workbook.getSheet("DataSheet");
		
		//Get the row
		Row row = sheet.getRow(2);
		
		//get row count
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Total row -"+physicalNumberOfRows);
		
		//Get the cell
		Cell cell = row.getCell(1);
		
		//get cell count
		int physicalNumberOfCells = row.getPhysicalNumberOfCells();
		System.out.println("Total cells in row -"+physicalNumberOfCells);
			
		
		for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row2 = sheet.getRow(i);
			System.out.println();
			
			for (int j = 0; j <row2.getPhysicalNumberOfCells(); j++) {
			Cell cell2 = row2.getCell(j);
			
			
			int type = cell2.getCellType();
			if(type==1) {
				String data = cell2.getStringCellValue();
				
				System.out.println(data);
			}
			  
			if (type==0) {
				if (DateUtil.isCellDateFormatted(cell2)) {
					

					Date date = cell2.getDateCellValue();
					SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy");
					String format2 = format.format(date);
					System.out.println(format2);
					
				}
				else
				
				{
				double d = cell2.getNumericCellValue();
				long l = (long) d;
				String d1 = String.valueOf(l);
				System.out.println(d1);
				}
				
				
				
			}

			
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	}

