package amazon.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchListOfMobile {
	public String baseUrl = "https://www.amazon.in/";
	public WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		System.out.println("Before test execution \n");
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless");
		driver = new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	
	
	@Test
	public void searchMobileWithPriceLessThan10K() {
		
		//find search textBox
		WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchTextBox.clear(); searchTextBox.click();
		
		//enter text into textBox
		searchTextBox.sendKeys("Mobile");
		
		//click on searchButton
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		
		//List of mobile whose price less than 10K
		//use Translate to remove extra characters like comma etc from price.
		String locator ="//span[@class='a-price-whole'  and number(translate(text(),\",₹\",\"\")) < 10000 ]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/*[1]/*/*/*";
		List<WebElement> mobilePhones = driver.findElements(By.xpath(locator));
		
		System.out.println("List of Mobile Phones price less than 10K :> \n");

		for(WebElement a : mobilePhones ) {
			System.out.println(a.getText());
		}
	}
	
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		System.out.println("\nTear down execution");
		
		driver.quit();
	}

}
