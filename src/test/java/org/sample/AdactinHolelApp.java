package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

public class AdactinHolelApp {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		BaseClass base = new BaseClass();
		
		base.getDriver();
		
		base.loadUrl("http://adactinhotelapp.com/");
		
		base.waitUrl();
		
		WebElement txtUserName = base.findElementById("username");
		String user = base.getData("Data", 1, 0);
		base.type(txtUserName, user);
		
		WebElement txtPassword = base.findElementById("password");
		String pass = base.getData("Data", 1, 1);
		base.type(txtPassword, pass);
		
		WebElement element = base.findElementById("login");
		base.click(element);
		
		WebElement dDnLocation = base.findElementById("location");
		String data = base.getData("Data", 1, 2);
		base.selectOptionsByText(dDnLocation, data);
		
		WebElement dDnHotel = base.findElementById("hotels");
		String data2 = base.getData("Data", 1, 3);
		base.selectOptionsByText(dDnHotel, data2);
		
		WebElement dDnRoomType = base.findElementById("room_type");
		String data3 = base.getData("Data", 1, 4);
		base.selectOptionsByText(dDnRoomType, data3);
		
		WebElement dDnNumberOfRoom = base.findElementById("room_nos");
		String data4 = base.getData("Data", 1, 5);
		base.selectOptionsByText(dDnNumberOfRoom, data4);
		
		WebElement bDnAdultCount = base.findElementById("adult_room");
		String data5 = base.getData("Data", 1, 6);
		base.selectOptionsByText(bDnAdultCount, data5);
		
		WebElement dDnChildrenCount = base.findElementByName("child_room");
		String data6 = base.getData("Data", 1, 7);
		base.selectOptionsByText(dDnChildrenCount, data6);
		
		WebElement btnClick = base.findElementById("Submit");
		base.click(btnClick);
		
		WebElement btnRadio = base.findElementById("radiobutton_0");
		base.click(btnRadio);
		
		WebElement btnContinue = base.findElementByName("continue");
		base.click(btnContinue);
		
		WebElement txtFirstName = base.findElementById("first_name");
		String data7 = base.getData("Data", 1, 8);
		base.type(txtFirstName, data7);
		
		
		WebElement txtLastName = base.findElementById("last_name");
		String data8 = base.getData("Data", 1, 9);
		base.type(txtLastName, data8);
		
		
		WebElement txtAddress = base.findElementById("address");
		String data9 = base.getData("Data", 1, 10);
		base.type(txtAddress, data9);
		
		
		WebElement txtCCNum = base.findElementByName("cc_num");
		String data10 = base.getData("Data", 1, 11);
		base.type(txtCCNum, data10);
		
		WebElement dDnCardType = base.findElementById("cc_type");
		String data11 = base.getData("Data", 1, 12);
		base.selectOptionsByText(dDnCardType, data11);
		
		WebElement dDnExpiryDate = base.findElementById("cc_exp_month");
		String data12 = base.getData("Data", 1, 13);
		base.selectOptionsByText(dDnExpiryDate, data12);
		
		WebElement dDnExpiryYear = base.findElementById("cc_exp_year");
		String data13 = base.getData("Data", 1, 14);
		base.selectOptionByAttribute(dDnExpiryYear, data13);
		
		WebElement txtCvvNumber = base.findElementById("cc_cvv");
		String data14 = base.getData("Data", 1, 15);
		base.type(txtCvvNumber, data14);
		
		WebElement btnSubmit = base.findElementById("book_now");
		base.click(btnSubmit);
		
		
		WebElement orderNo = base.findElementById("order_no");
		String text = base.getAttributeValue(orderNo);
		base.outData("D:\\PRADEEP\\Excel\\Adactinhotel.xlsx", "Data", 1, 16, text);
		
	
	
	}
}
