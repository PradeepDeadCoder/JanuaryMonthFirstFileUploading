package org.sample;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Argument;

public class BaseClass {
	
	static WebDriver driver;
	
	public static void getDriver() {
	
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}

	public static void loadUrl(String url) {
	driver.get(url);

}
	
	public static void closeBrowser() {
		driver.quit();
	}
	
	
	public void doubleClick(WebElement element) {
		Actions actions = new Actions (driver);
		
		actions.doubleClick(element).perform();

	}
	
	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions actions = new Actions (driver);
		actions.dragAndDrop(source, destination).perform();
		
	}
	
	public void rightClick(WebElement element) {
		Actions actions = new Actions (driver);
		actions.contextClick(element).perform();
		
	}
	
	public void nagivateBack() {
		driver.navigate().back();
	}
	
	public void navigateForeward() {
		driver.navigate().forward();
	}
	
	public void alertAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void alertDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void alertTypeText(String data) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(data);
	}
	
	public String alertGetText() {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}
	
	public void moveToElement(WebElement element) {
		Actions action = new Actions (driver);
		action.moveToElement(element);
		
	}
	
	public void rightClick() {
		Actions action = new Actions (driver);
		action.contextClick();
	}
	
	public void deSelectAll(WebElement element) {
		Select select = new Select (element);
		select.deselectAll();
	}

	public void deSelectByIndex(WebElement element, int index) {
		Select select = new Select (element);
		select.deselectByIndex(index);
	}
	
	public void deSelectByValue(WebElement element, String value) {
		Select select = new Select (element);
		select.deselectByValue(value);
	}

	public void deSelectByVisibleText(WebElement element, String text) {
		Select select = new Select (element);
		select.deselectByVisibleText(text);
		
	}
	
	public void getFirstSelectedOption(WebElement element) {
		Select select = new Select (element);
		select.getFirstSelectedOption();
		
	}

	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	public void switchToNormalWindow() {
		driver.switchTo().defaultContent();
	}
	
	public String getParentWindowId() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public Set<String> getAllWindowId() {
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}
	
	public void switchFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchFrameBy(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}
	
	public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}
	
	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}
	
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public String getAttributeValue(WebElement element) {
		String data = element.getAttribute("value");
		return data;
	}
	
	public String getAttributeValue(WebElement element, String attributeValue) {
		String data = element.getAttribute("value");
		return data;
	}
	
	public void selectOptionsByText(WebElement element, String data) {
		Select select = new Select (element);
		select.selectByVisibleText(data);
	}
	
	public void selectOptionByAttribute(WebElement element, String attributeValue) {
		Select select = new Select (element);
		select.selectByValue(attributeValue);
	}
	
	public void selectionOptionByIndex(WebElement element, int index) {
		Select select = new Select (element);
		select.selectByIndex(index);
	}
	
	public WebElement findElementByXpath(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));
		return element;
	}
	
	
	
	public void outData(String path, String sheetName, int rowNo, int cellNo, String data) throws IOException {
		
		File file = new File(path);
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook =new XSSFWorkbook (stream);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNo);
		
		Cell cell = row.createCell(cellNo);
		
		cell.setCellValue(data);
		
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		
	}
	
	public static void waitUrl() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	public String getData(String sheetName, int rowNo, int cellNo) throws IOException {
		String data=null;
		
		File file = new File("D:\\PRADEEP\\Excel\\Adactinhotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook (stream);
		
		Sheet sheet = workbook.getSheet(sheetName);
		
		Row row = sheet.getRow(rowNo);
		
		Cell cell = row.getCell(cellNo);
		
		int cellType = cell.getCellType();
		
		if (cellType==1) {
			data=cell.getStringCellValue();	
		}
		if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
				 data = dateformat.format(dateCellValue);
			}
		
		
		else {
			double d = cell.getNumericCellValue();
			long l = (long) d;
			 data = String.valueOf(l);
			
		}
			}
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
