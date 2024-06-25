package googleSearch.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class IncognitoAndXpath {
	
	
	@Test
	public void incognito() {
		
		ChromeOptions opt = new ChromeOptions();
//		opt.addArguments("--headless");
		opt.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://the-internet.herokuapp.com/tables");
		
		String[] lastnames = {"Smith","Bach","Doe","Conway"};
		for(String lastName : lastnames) {
			String xpath = "//td[@class='last-name' and text()='" + lastName + "']/following-sibling::td[@class='email']";
			
			WebElement ele = driver.findElement(By.xpath(xpath));
			
			String email = ele.getText();
			// Print the email
	        System.out.println("Email for " + lastName + ": " + email);
		}
		
		
		driver.quit();
		
		
		
	}

}
