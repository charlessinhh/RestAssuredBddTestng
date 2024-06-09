package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


// with page factory FindBy interface
public class LoginPage {
	
	//constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	//find web elements on webpage

	@FindBy(id="nav-link-accountList")    //a[contains(@id,'nav-link-accountList')]
	WebElement accountListButton;
	
	@FindBy(id="ap_email")
	WebElement enterEmailField;
	
	@FindBy(id="continue")
	WebElement continueToPasswordButton;
	
	@FindBy(id="ap_password")
	WebElement enterPasswordField;
	
	@FindBy(id="signInSubmit")
	WebElement clickSignInButton;
	
//	WebElement = Hello, Bittu
	
	@FindBy(xpath="//span[contains(text(),'Hello, Bittu')]")
	WebElement accountNameMsg;
	
	
	//method to interact to the WebElements
	
	//enter email
	public void enterEmail(String email) {
		enterEmailField.sendKeys(email);
	}
	
	//enter password
	public void enterPassword(String pwd) {
		enterPasswordField.sendKeys(pwd);
	}
	
	public void clickAccountList() {
		accountListButton.click();
	}
	
	public void clickContinueToPasswordButton() {
		continueToPasswordButton.click();
	}
	
	public void clickSignInButton()
	{
		clickSignInButton.click();
	}
	
	
	public String getAccountNameMsg() {
		return (accountNameMsg.getText());
	}
	
	
	
	
	
	
	

}
