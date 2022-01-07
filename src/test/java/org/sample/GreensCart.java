package org.sample;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GreensCart {
	
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://greenscart.in/#/login?returnUrl=%2F");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Before
	public void before() {
		long start = System.currentTimeMillis();
		System.out.println(start);
	}
	
	@Test
	public void login() {
		WebElement txtUser = driver.findElement(By.xpath("(//input[@id='loginEmailId'])[2]"));
		txtUser.sendKeys("Pradeep@gmail.com");
		
		WebElement txtPassword = driver.findElement(By.xpath("(//input[@id='loginPassword'])[2]"));
		txtPassword.sendKeys("Pradeep@gm");
		
		WebElement btnLogin = driver.findElement(By.xpath("//input[@class='btnRegister form-control']"));
		btnLogin.click();
	}
	@After
	public void after() {
		long end = System.currentTimeMillis();
	System.out.println(end);
	}
	@AfterClass
	public static void afterClass() {
		//driver.quit();
	}
}
