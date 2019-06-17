package utility;

import java.io.File;
import java.io.IOException;

import org.persistent.test.test_git.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import getters.BaseGetClass;
import getters.GetLogin;

public class ReportingNew extends BaseClass implements ITestListener{

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	@Override
	public void onTestStart(ITestResult result) {
		/*
		 * sTestCaseName=result.getName(); browserName="chrome";
		 */
		
		/*
		 * sTestCaseName=result.getName(); try {
		 * iTestCaseRowNumber=ExcelUtils.getTestCaseRowNumber(sTestCaseName,Constant.
		 * Col_TestCaseName); } catch (Exception e) { e.printStackTrace(); } try {
		 * browserName=BaseGetClass.getBrowserName(iTestCaseRowNumber); } catch
		 * (Exception e) { e.printStackTrace(); } bResult=true;
		 */
		 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger=extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));	
		testResult="Pass";
		try {
			//int itestcase=getTestCaseRowNumber();
			int itestcase=iTestCaseRowNumber;
			System.out.println("Pass test case row number is: "+itestcase);
			GetLogin.setTestResult(itestcase, testResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
			logger=extent.createTest(result.getName()); // create new entry in th report
			logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
			testResult="Fail";
			try {
				//String screenshotName=result.getName()+"_"+getBrowserName()+"_"+Utils.getCurrentSystemDate()+".png";
				String screenshotName=result.getName()+"_"+browserName+"_"+Utils.getCurrentSystemDate()+".png";
				String temp=Utils.captureScreenshot(driver,screenshotName);
				logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				//int itestcase=getTestCaseRowNumber();
				int itestcase=iTestCaseRowNumber;
				System.out.println("Fail test case row number is: "+itestcase);
				GetLogin.setTestResult(itestcase, testResult);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger=extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		testResult="Skip";
		try {
			/*
			 * int itestcase=iTestCaseRowNumber;
			 * System.out.println("Skip test case row number is: "+itestcase);
			 * GetLogin.setTestResult(itestcase, testResult);
			 */
			sTestCaseName = result.getName();
			iTestCaseRowNumber = ExcelUtils.getTestCaseRowNumber(sTestCaseName, Constant.Col_TestCaseName);
			System.out.println("Skipped test case is:"+ sTestCaseName);
			System.out.println("Skipped test case row number is : " + iTestCaseRowNumber);
			BaseClass.setTestCaseRowNumber(iTestCaseRowNumber);
			GetLogin.setTestResult(iTestCaseRowNumber, testResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
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

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
		/*
		 * if(driver!=null) { driver.quit(); }
		 */
		
	}

}
