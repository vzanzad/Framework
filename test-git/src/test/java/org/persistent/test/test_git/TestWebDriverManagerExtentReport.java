package org.persistent.test.test_git;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utils;

public class TestWebDriverManagerExtentReport extends BaseClass{
	
	@BeforeTest
	public void setUpExtent()
	{
		String repName="Test-Report-"+Utils.getCurrentSystemDate()+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+repName);//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","pavan");
		
		htmlReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	@BeforeMethod
	public void setUpTest(Method method)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		//BaseClass.setBrowserName();	
	}
	
	@Test
	public void testGoogle1Fail() throws Exception
	{
		driver.get("https://google.co.in");
		Thread.sleep(5000);		
		
		Assert.assertTrue(false);		
	}
	
	@Test
	public void testGoogle1Pass() throws Exception
	{
		driver.get("https://google.co.in");
		Thread.sleep(5000);
		
		Assert.assertTrue(true);
		logger.log(Status.PASS, "Search Google page");
		logger.log(Status.INFO, "Enter text passed");
		logger.log(Status.ERROR, "submit clicked");
		
	}
	
	@Test(dependsOnMethods = { "testGoogle1Fail" })
	public void testGoogle1skip() throws Exception
	{
		driver.get("https://google.co.in");
		Thread.sleep(5000);
		logger.log(Status.PASS, "Search Google page");
		logger.log(Status.INFO, "Enter text passed");
		logger.log(Status.ERROR, "submit clicked");
		Assert.assertTrue(false);		
	}
	
	/*
	 * @Test public void testGoogle2Fail() throws Exception {
	 * driver.get("https://google.co.in"); Thread.sleep(5000);
	 * 
	 * Assert.assertTrue(false);
	 * 
	 * }
	 * 
	 * @Test public void testGoogle2Pass() throws Exception {
	 * driver.get("https://google.co.in"); Thread.sleep(5000);
	 * 
	 * Assert.assertTrue(true);
	 * 
	 * }
	 * 
	 * @Test(enabled=false) public void testGoogle2skip() throws Exception {
	 * driver.get("https://google.co.in"); Thread.sleep(5000);
	 * 
	 * Assert.assertTrue(false);
	 * 
	 * }
	 */

	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
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
		else if(ITestResult.SUCCESS==result.getStatus())
		{
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		}
		else if(ITestResult.SKIP==result.getStatus())
		{
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		}

		extent.flush();
		
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	
	
	

}
