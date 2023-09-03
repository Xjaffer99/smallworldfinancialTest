package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;

	By txt_username = By.id("user-name");
	
	By txt_password = By.id("password");
	
	By btn = By.id("login-button");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clicklogin() {
		driver.findElement(btn).click();
	}
	
	public void loginValidUser(String username,String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn).click();
	}
	
}
