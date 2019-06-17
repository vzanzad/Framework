package org.persistent.test.test_git;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import getters.BaseGetClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Utils;

public class MultiURLTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUpTest(Method method)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();	
		//BaseClass.setBrowserName();
	}
	
	@Test
	public void test() throws InterruptedException
	{
		driver.get("https://google.co.in");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		
		Thread.sleep(3000);
		
		driver.get("https://www.javatpoint.com/interface-in-java");
	}
	
	public void tearDown() 
	{		
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
