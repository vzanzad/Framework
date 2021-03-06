package org.persistent.test.test_git;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utils;

public class TestWebDriverManagerReporting extends BaseClass{

	
	/*
	 * @BeforeClass public void setupClass() {
	 * WebDriverManager.chromedriver().setup(); }
	 */
	
	@BeforeMethod
	public void setUpTest(Method method)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
	}
	
	@Test
	public void testGoogle() throws Exception
	{
		driver.get("https://google.co.in");
		Thread.sleep(5000);
		
		Assert.assertTrue(false);
		
		
		
	}
	
	/*
	 * @Test public void testFirstCry() throws Exception {
	 * driver.get("https://www.firstcry.com/"); Thread.sleep(5000);
	 * 
	 * Assert.assertTrue(true);
	 * 
	 * }
	 */
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		/*if(ITestResult.FAILURE==result.getStatus())
		{
			try {
				String screenshotName=result.getName()+"_"+getBrowserName()+"_"+Utils.getCurrentSystemDate()+".png";
				String temp=Utils.captureScreenshot(driver,screenshotName);
				Utils.setCurrentScreenshot(temp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	
	
	

}
