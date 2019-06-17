package org.persistent.test.test_git;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentHtmlReporter htmlReporter;
	public static String browserName;
	public String appURL = "https://github.com/login";
	public String sTestCaseName;
	public static int iTestCaseRowNumber;
	public String testResult;
	public static boolean bResult;
	// public static int rowCount;

	/*
	 * public static void setBrowserName() { browserName = "chrome"; }
	 * 
	 * public static String getBrowserName() { setBrowserName(); return browserName;
	 * }
	 */

	/*
	 * public static void setTestCaseName(String testCaseName) {
	 * sTestCaseName=testCaseName; }
	 * 
	 * public static String getTestCaseName() { return sTestCaseName; }
	 */

	
	/*
	 * public static void setTestCaseNumber(String testCaseRowNumber) {
	 * iTestCaseRowNumber=testCaseRowNumber; }
	 * 
	 * public static String getTestCaseNumber() { return iTestCaseRowNumber; }
	 */
	  
	  
	  
	public static void setTestCaseRowNumber(int testCaseNo) 
	{
		iTestCaseRowNumber = testCaseNo;
	}
	  
	  public static int getTestCaseRowNumber() 
	  { 
		  return iTestCaseRowNumber; 
	  }
	 

}
