package com.qa.web.automation;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class UItest {
	
	@Parameters("Browser")
	@Test
	public void startBrowser(String browserName) {
		WebDriver driver = null;
		System.out.println("Browser name is "+ browserName);
		
		
		if(browserName.toLowerCase().contains("chrome")) {
			
			// Configure ChromeOptions
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--headless");
			opt.addArguments("--no-sandbox");
			opt.addArguments("--disable-dev-shm-usage");
			
			driver=new ChromeDriver(opt);
			
			System.out.println("Chrome driver connected ");
		}
		
		
		else if(browserName.toLowerCase().contains("edge")) {
			
			// Configure EdgeOptions
	        EdgeOptions options = new EdgeOptions();
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--headless"); // If you need headless mode
	        options.addArguments("--remote-debugging-port=9222");
	        
			driver = new EdgeDriver(options);
			
			System.out.println("Edge driver connected ");
		}
		

		
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "OrangeHRM");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("quit browser --*****---$%%$$$*****");
		
		driver.quit();
	}
	
	

}
