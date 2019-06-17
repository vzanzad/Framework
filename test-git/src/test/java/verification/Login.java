package verification;

import org.persistent.test.test_git.BaseClass;
import org.testng.Reporter;

public class Login extends BaseClass{
	
	public static void verify() throws Exception
	{
		if(driver.getTitle().equals("GitHub"))
		{
			Reporter.log("login successful");
		}
		else
		{
			BaseClass.bResult=false;
			Reporter.log("Login failed");
			//throw new Exception("Login failed");
		}
	}

}
