package org.persistent.test.test_git;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.BrowserFactory;

public class GoogleTest extends BaseClass{
	
	@BeforeMethod
	public void setUp()
	{
		//setBrowserName();
		driver=BrowserFactory.startApplication(driver, browserName, appURL);
	}
	
	@Test
	public void testGoogle() throws Exception
	{
		driver.get("https://google.co.in");
		Thread.sleep(5000);
		
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	

}
