package org.persistent.test.test_git;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import getters.GetLogin;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import utility.BrowserFactory;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;

public class LoginTest extends BaseClass{
	
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
	public void setUpTest(Method method) throws Exception
	{
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();
		
		sTestCaseName=method.getName();
		iTestCaseRowNumber=ExcelUtils.getTestCaseRowNumber(sTestCaseName, Constant.Col_TestCaseName);
		//rowCount=ExcelUtils.getRowCount(Constant.Path_TestData, Constant.File_TestData);
	}
	
	@Test
	public void checkValidUser() throws Exception
	{
	 
	// This will launch browser and specific url 
	//WebDriver driver=BrowserFactory.startBrowser("firefox", "http://demosite.center/wordpress/wp-login.php");
	driver=BrowserFactory.startApplication(driver, "chrome", appURL);
	 
	// Created Page Object using Page Factory
	String testCaseName=sTestCaseName;
	int rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName );
	String uname=ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, rownum, Constant.Col_Username);
	String pass=ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, rownum, Constant.Col_Password);
	
	LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	 
	// Call the method
	login_page.login(uname, pass);
	}
	
	
	@Test
	public void checkValidUserUDF() throws Exception 
	{
	  
	  driver=BrowserFactory.startApplication(driver, "chrome", appURL);
	  
	  LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
	  
	  //Call the method 
	  login_page.login(GetLogin.getUsername(iTestCaseRowNumber), GetLogin.getPassword(iTestCaseRowNumber)); 
	  }
	 
	
	/*
	 * @DataProvider(name="logintestdata") public Object[][] TestDataFeed() throws
	 * Exception {
	 * 
	 * String testCaseName=sTestCaseName; int
	 * rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName
	 * );
	 * 
	 * // Create object array with 2 rows and 2 column- first parameter is row and
	 * // second is //column Object[][] logindata = new Object[2][2];
	 * 
	 * // Enter data to row 0 column 0 logindata[0][0] = Constant.Col_Username;
	 * 
	 * // Enter data to row 0 column 1 logindata[0][1] =
	 * ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData,
	 * rownum, Constant.Col_Username);
	 * 
	 * // Enter data to row 1 column 0 logindata[1][0] = Constant.Col_Password;
	 * 
	 * // Enter data to row 1 column 0 logindata[1][1] =
	 * ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData,
	 * rownum, Constant.Col_Password);
	 * 
	 * // return arrayobject to testscript return logindata; }
	 */
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
			testResult="Fail";
			try {
				String screenshotName=result.getName()+"_"+getBrowserName()+"_"+Utils.getCurrentSystemDate()+".png";
				//String screenshotName=result.getName()+".png";
				String temp=Utils.captureScreenshot(driver,screenshotName);
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			GetLogin.setTestResult(iTestCaseRowNumber, testResult);
			
			
		}
		else if(ITestResult.SUCCESS==result.getStatus())
		{
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
			testResult="Pass";
			GetLogin.setTestResult(iTestCaseRowNumber, testResult);
		}
		else if(ITestResult.SKIP==result.getStatus())
		{
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
			testResult="Skip";
			GetLogin.setTestResult(iTestCaseRowNumber, testResult);
		}

		extent.flush();
		
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
