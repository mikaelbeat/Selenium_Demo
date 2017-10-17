package pages;

import org.testng.Assert;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login_Page {
	
	WebDriver driver;
	ExtentTest test;
	
	public Login_Page(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Fill_username(String user) {
		  WebElement usernameField = driver.findElement(By.id("username"));
		  usernameField.sendKeys(user);
		  test.log(LogStatus.INFO, "Filled username.");
	}
	
	public void Fill_password(String user) {
		  WebElement passwordField = driver.findElement(By.id("password"));
		  passwordField.sendKeys(user);
		  test.log(LogStatus.INFO, "Filled password.");
	}
	
	public void Click_login_button() {
		  WebElement loginButton = driver.findElement(By.id("login"));
		  loginButton.click();
		  test.log(LogStatus.INFO, "Clicked login button.");
	}
	
	public void Check_welcome_text() {
		  WebElement welcomeText = null;
		  try {
			  welcomeText = driver.findElement(By.id("username_show"));
		  }
		  catch (NoSuchElementException e) {
			  System.out.println(e.getMessage());
		  }
		  Assert.assertTrue(welcomeText != null);
		  test.log(LogStatus.PASS, "Welcome Text found.");
	  }
	
	public void assert_welcome_text(String expected){
		WebElement welcome = driver.findElement(By.id("username_show"));
		String value = welcome.getAttribute("value");
		assertEquals(value, expected);
		test.log(LogStatus.PASS, "Verified Welcome text value.");
	}
	
}
