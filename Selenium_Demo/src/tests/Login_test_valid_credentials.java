package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import pages.Login_Page;
import utilities.*;

public class Login_test_valid_credentials {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	Login_Page loginPage;
	

  @BeforeClass
  public void beforeClass() {
	  baseUrl = "http://adactin.com/HotelAppBuild2/";
	  report = ExtentReport.reportResult();
	  test = report.startTest("Login test with valid credentials.");
	  driver = new ChromeDriver();
	  loginPage = new Login_Page(driver, test);
	  driver.get(baseUrl);
	  test.log(LogStatus.INFO, "Browser started.");
	  driver.manage().window().maximize();
	  test.log(LogStatus.INFO, "Browser maximized");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  test.log(LogStatus.INFO, "Web application opened.");
  }
  
  @Test
  public void Login_test_with_valid_credentials() {
	  loginPage.Fill_username("ryynanenphm");
	  loginPage.Fill_password("Tester74");
	  loginPage.Click_login_button();
	  loginPage.Check_welcome_text();
	  loginPage.assert_welcome_text("Hello ryynanenphm!");
  }
  
  @AfterMethod
  public void afterMethod(ITestResult testResult) throws IOException {
	  if (testResult.getStatus() == ITestResult.FAILURE) {
		  String path = Screenshot.takeScreenshot(driver, testResult.getName());
		  String imagePath = test.addScreenCapture(path);
		  test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
	  }
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  report.endTest(test);
	  report.flush();
  }

}
