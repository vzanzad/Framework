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

public class TestWebDriverManager extends BaseClass{
	

	//private ExtentReports extent;
	//private ExtentTest logger;
	
	/*
	 * @BeforeClass public void setupClass() {
	 * WebDriverManager.chromedriver().setup(); }
	 */
	
	@BeforeMethod
	public void setUpTest(Method method)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		//BaseClass.setBrowserName();
		
		String repName="Test-Report-"+Utils.getCurrentSystemDate()+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+repName);
		
	    extent = new ExtentReports();
	    
	    extent.attachReporter(htmlReporter);
	    
	    logger=extent.createTest(method.getName());
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
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			try {
				String screenshotName=result.getName()+"_"+getBrowserName()+"_"+Utils.getCurrentSystemDate()+".png";
				//String screenshotName=result.getName()+".png";
				String temp=Utils.captureScreenshot(driver,screenshotName);
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		extent.flush();
		
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	
	
	

}
