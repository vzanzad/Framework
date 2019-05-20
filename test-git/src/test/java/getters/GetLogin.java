package getters;

import org.persistent.test.test_git.BaseClass;

import utility.Constant;
import utility.ExcelUtils;

public class GetLogin extends BaseGetClass{
	
	public static String getUsername(int testCaseRowNum) throws Exception
	{
		//String testCaseName=BaseClass.sTestCaseName;
		//int rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName );
		String uname=ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, testCaseRowNum, Constant.Col_Username);
		return uname;	
	}
	
	public static String getPassword(int testCaseRowNum) throws Exception
	{
		//String testCaseName=BaseClass.sTestCaseName;
		//int rownum=ExcelUtils.getTestCaseRowNumber(testCaseName,Constant.Col_TestCaseName );
		String pass=ExcelUtils.getCellData(Constant.Path_TestData, Constant.File_TestData, testCaseRowNum, Constant.Col_Password);
		return pass;	
	}

}
