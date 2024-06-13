package googleSearch.test;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearch {

	public WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.out.println("Before test execution");

		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless");
		driver = new ChromeDriver(opt);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	@Test
	public void openTabinChrome() {
		
		//open a new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
		
		// Get the list of all open windows
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        // Switch to the new tab
        driver.switchTo().window(tabs.get(1));
		
		driver.get("https://www.google.co.in/");
		
		WebElement searchText = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		searchText.clear();
		searchText.sendKeys("Football");
		
		driver.findElement(By.xpath("//input[@name='btnK']")).click();

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		System.out.println("tear down execution");

//		driver.quit();
	}

}
