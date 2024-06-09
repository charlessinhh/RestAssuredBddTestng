package amazon.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class LoginTest {
	
	public String baseUrl = "https://www.amazon.in/";
	public WebDriver driver;
	
	public String email = "";
	public String pwd = "";
	
	
	@BeforeTest
	public void setUp() {
		System.out.println("Before test execution");
		
		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless");
		driver = new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		
		driver.get(baseUrl);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	@Test
	public void loginToAmazon() {
		LoginPage lp = new LoginPage(driver);
		
		//click on account list
		lp.clickAccountList();
		
		//enter email pwd
		lp.enterEmail(email);
		
		lp.clickContinueToPasswordButton();
		
		lp.enterPassword(pwd);
		
		lp.clickSignInButton();
		
		String expectedAccountNameMsg = "Hello, Bittu";
		String actualAccountNameMsg = lp.getAccountNameMsg();
		
		Assert.assertEquals(expectedAccountNameMsg, actualAccountNameMsg);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		System.out.println("tear down execution");
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
