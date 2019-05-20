package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.persistent.test.test_git.TestWebDriverManager;

public class Utils extends TestWebDriverManager{
	
	public static String currentSystemDate;
	public static String currentScreenshot;
	
	public static String captureScreenshot(WebDriver driver,String screenshotName) throws Exception
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String screenshot=System.getProperty("user.dir")+"/Screenshots/"+screenshotName;
		
		File destination=new File(screenshot);
		
		FileUtils.copyFile(source, destination);
		
		System.out.println("Screenshot captured");
		
		return screenshot;
	}
	
	public static String getCurrentSystemDate()
	{
		/*
		 * // Create object of SimpleDateFormat class and decide the format DateFormat
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		 * 
		 * // get current date time with Date() Date date = new Date();
		 * 
		 * // Now format the date String currentDate = dateFormat.format(date);
		 */
		  
		 
		
		//String currentDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		setCurrentSystemDate();
		return currentSystemDate;
		
	}
	
	public static void setCurrentSystemDate()
	{
		// Create object of SimpleDateFormat class and decide the format DateFormat
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		currentSystemDate = dateFormat.format(date);
	}
	
	public static void setCurrentScreenshot(String screenshotName)
	{
		currentScreenshot=screenshotName;
	}
	
	public static String getCurrentScreenshot()
	{
		return currentScreenshot;
	}
	
	

}
