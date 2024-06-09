package com.qa.web.automation;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class UItest {
	
	@Parameters("Browser")
	@Test
	public void startBrowser(String browserName) {
		WebDriver driver = null;
		System.out.println("Browser name is "+ browserName);
		if(browserName.toLowerCase().contains("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome driver connected ");
		}
		else if(browserName.toLowerCase().contains("edge")) {
			driver = new EdgeDriver();
			System.out.println("Edge driver connected ");
		}
		

		
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
		
		System.out.println("quit browser --*****---$%%$$$*****");
		driver.quit();
	}
	
	

}
