package org.persistent.test.test_git;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import getters.BaseGetClass;
import getters.GetLogin;
import pages.LoginPage;
import utility.BrowserFactory;
import utility.Constant;
import utility.ExcelUtils;
import utility.Utils;
import verification.Login;

public class GoogleNew extends BaseClass {

	@BeforeMethod
	public void setUpTest(Method method) throws Exception {

		sTestCaseName = method.getName();
		iTestCaseRowNumber = ExcelUtils.getTestCaseRowNumber(sTestCaseName, Constant.Col_TestCaseName);
		System.out.println("Executing test case :"+sTestCaseName);
		System.out.println("Before Method: test case row number is : " + iTestCaseRowNumber);
		BaseClass.setTestCaseRowNumber(iTestCaseRowNumber);
		// setTestCaseRowNumber(iTestCaseRowNumber);
		browserName = BaseGetClass.getBrowserName(iTestCaseRowNumber);
		bResult = true;

	}

	/*
	 * @Test public void GooglePass1() throws Exception {
	 * driver=BrowserFactory.startApplication(driver, browserName, appURL);
	 * Assert.assertTrue(true); }
	 * 
	 * @Test public void GoogleFail1() throws Exception {
	 * driver=BrowserFactory.startApplication(driver, browserName, appURL);
	 * Assert.assertTrue(false); }
	 * 
	 * @Test(dependsOnMethods= {"GoogleFail1"}) public void GoogleSkip1() throws
	 * Exception { driver=BrowserFactory.startApplication(driver, browserName,
	 * appURL); Assert.assertTrue(true); }
	 * 
	 * @Test public void GooglePass2() throws Exception {
	 * driver=BrowserFactory.startApplication(driver, browserName, appURL);
	 * Assert.assertTrue(true); }
	 * 
	 * @Test public void GoogleFail2() throws Exception {
	 * driver=BrowserFactory.startApplication(driver, browserName, appURL);
	 * Assert.assertTrue(false); }
	 * 
	 * @Test(dependsOnMethods= {"GoogleFail2"}) public void GoogleSkip2() throws
	 * Exception { driver=BrowserFactory.startApplication(driver, browserName,
	 * appURL); Assert.assertTrue(true); }
	 */

	@Test
	public void checkValidUser001() throws Exception {

		try {
			driver = BrowserFactory.startApplication(driver, browserName, appURL);

			// Created Page Object using Page Factory
			// String testCaseName=sTestCaseName;
			// int
			// rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName
			// );
			String uname = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Username);
			String pass = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Password);

			LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

			// Call the method
			login_page.login(uname, pass);
			Login.verify();
			Assert.assertTrue(bResult);
			//Assert.ass
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled=false)
	public void checkValidUserUDF001() throws Exception {

		try {
			driver = BrowserFactory.startApplication(driver, browserName, appURL);

			LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

			// Call the method
			login_page.login(GetLogin.getUsername(iTestCaseRowNumber), GetLogin.getPassword(iTestCaseRowNumber));
			Login.verify();
			Assert.assertTrue(bResult);
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}

	}
	
	@Test(enabled=false)
	public void checkValidUser002() throws Exception {

		try {
			driver = BrowserFactory.startApplication(driver, browserName, appURL);

			// Created Page Object using Page Factory
			// String testCaseName=sTestCaseName;
			// int
			// rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName
			// );
			String uname = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Username);
			String pass = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Password);

			LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

			// Call the method
			login_page.login(uname, pass);
			Login.verify();
			Assert.assertTrue(bResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled=false)
	public void checkValidUserUDF002() throws Exception {

		try {
			driver = BrowserFactory.startApplication(driver, browserName, appURL);

			LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

			// Call the method
			login_page.login(GetLogin.getUsername(iTestCaseRowNumber), GetLogin.getPassword(iTestCaseRowNumber));
			Login.verify();
			Assert.assertTrue(bResult);
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}

	}
	
	@Test(enabled=false)
	//(dependsOnMethods={"checkValidUserUDF001"})
	public void checkValidUser003() throws Exception {

		try {
			driver = BrowserFactory.startApplication(driver, browserName, appURL);

			// Created Page Object using Page Factory
			// String testCaseName=sTestCaseName;
			// int
			// rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName
			// );
			String uname = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Username);
			String pass = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Password);

			LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

			// Call the method
			login_page.login(uname, pass);
			Login.verify();
			Assert.assertTrue(bResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(enabled=false)
	public void checkValidUserUDF003() throws Exception {

		try {
			driver = BrowserFactory.startApplication(driver, browserName, appURL);

			LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

			// Call the method
			login_page.login(GetLogin.getUsername(iTestCaseRowNumber), GetLogin.getPassword(iTestCaseRowNumber));
			Login.verify();
			Assert.assertTrue(bResult);
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
		}

	}
	
	@Test(enabled=false)
	public void checkValidUser004() throws Exception {

		try {
			driver = BrowserFactory.startApplication(driver, browserName, appURL);

			// Created Page Object using Page Factory
			// String testCaseName=sTestCaseName;
			// int
			// rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName
			// );
			String uname = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Username);
			String pass = ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, iTestCaseRowNumber,
					Constant.Col_Password);

			LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);

			// Call the method
			login_page.login(uname, pass);
			Login.verify();
			Assert.assertTrue(bResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	  
	 

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {

		if (driver != null) {
			driver.quit();
		}
	}

}
