package com.qa.web.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class UItest {
	
	@Test
	public void startBrowser() {
        
		// Setup WebDriverManager for ChromeDriver
//        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		System.out.println("chrome driver connected ");
		
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("quit browser ");
		driver.quit();
	}
	
	

}
