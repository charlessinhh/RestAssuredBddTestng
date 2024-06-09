package com.qa.web.automation;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankTest {

//	static String url = "https://parabank.parasoft.com/parabank/";

	@Test
	public static void openUrl() {
		WebDriver driver =null;
		
		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless");
		driver = new ChromeDriver(opt);
		
//		driver.manage().window().maximize();

//		driver.get(url);

		// implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("hello");
//		driver.findElement(By.xpath(("//input[@name='password']"))).sendKeys("pass");
//		driver.findElement(By.xpath("//div[@class='login']//input[@class='button']")).click();

		// explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement ele = driver.findElement(By.xpath("//div[@class='login']//input[@class='button']"));
//		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(ele));
//		e.click();

//		FluentWait<WebDriver> wait = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(20))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(NoSuchElementException.class);
//
//        WebElement enabledElement = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                WebElement element = driver.findElement(By.id("enabledElementId"));
//                if (element.isEnabled()) {
//                    return element;
//                } else {
//                    return null;
//                }
//            }
//        });
//
//        enabledElement.click();

//		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
//
//		WebElement table = driver.findElement(By.id("customers"));
////		Assert.assertTrue(table.isDisplayed(), "table not present");
//
//		List<WebElement> tableRow = table.findElements(By.tagName("tr"));
//		System.out.println("tableRow: " + tableRow.size());
//
//		// head cell so
//		List<WebElement> headCell = tableRow.get(0).findElements(By.tagName("th"));
//		System.out.println("head cell: " + headCell.size());
//		for (WebElement cell : headCell) {
//			System.out.println("cellValue: " + cell.getText());
//		}
//
//		// body cells
//		for (int cellIndex = 1; cellIndex < tableRow.size(); cellIndex++) {
//			List<WebElement> cells = tableRow.get(cellIndex).findElements(By.tagName("td"));
//			System.out.println("cells size : " + cells.size());
//			for (WebElement cell : cells) {
//				System.out.println("cellValue: " + cell.getText());
//
//			}
//			
//		}
		
		
		
		
		//drop-down selection ->  select tag
		String url = "https://accounts.spotify.com/en/login/phone?flow_ctx=695d29df-98b1-43c7-abb8-7ee416846c80:1717153507";
		
		driver.get(url);
		
		WebElement ele = driver.findElement(By.xpath("//select[@id=\"phonelogin-country\"]"));
//		System.out.println(ele);
		
		Select dropdown = new Select(ele);
		List<WebElement> options = dropdown.getOptions();
		System.out.println(options.size());
		for(WebElement option: options) {
			System.out.println(option.getText());
		}
		
		dropdown.selectByVisibleText("+212");
		
		driver.findElement(By.xpath("//input[@id=\"phonelogin-phonenumber\"]")).sendKeys("9636298");
		
		driver.findElement(By.xpath("//span[@class='Indicator-sc-1airx73-0 kxYwgo']")).click();
		
		
//		driver.quit();
	}

}
