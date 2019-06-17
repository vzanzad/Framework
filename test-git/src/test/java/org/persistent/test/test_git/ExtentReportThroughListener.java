package org.persistent.test.test_git;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import getters.BaseGetClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utils;

public class ExtentReportThroughListener extends BaseClass{

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
		
		try {
			Assert.assertTrue(false);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			try {
				String screenshotName=result.getName()+"_"+BaseGetClass.getBrowserName(iTestCaseRowNumber)+"_"+Utils.getCurrentSystemDate()+".png";
				String temp=Utils.captureScreenshot(driver,screenshotName);
				Utils.setCurrentScreenshot(temp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
}
