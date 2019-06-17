package getters;

import com.aventstack.extentreports.Status;

import utility.Constant;
import utility.ExcelUtils;

public class BaseGetClass {
	
	
	public static void setTestResult(int testCaseRowNum,String result) throws Exception
	{
		//String testCaseName=BaseClass.sTestCaseName;
		//int rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName );
		//String uname=ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, testCaseRowNum, Constant.Col_Username);
		//return uname;
		
		ExcelUtils.setCellData(Constant.Path_TestData, Constant.File_TestData, testCaseRowNum, Constant.Col_Result, result);
	}
	
	public static String getBrowserName(int testCaseRowNum) throws Exception
	{
		String browserName=ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, testCaseRowNum, Constant.Col_BrowserName);
		return browserName;
	}

}
