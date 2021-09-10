package Revision.SelfProject2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class BaseClass
{
	WebDriver driver;
	Properties prop;
	@Test
	public WebDriver launchBrowser() throws FileNotFoundException, IOException
	{
		prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\mainFile.properties"));
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver2.exe");
		
		ChromeOptions opt = new ChromeOptions();
		
		if(System.getProperty("browser").contains("chrome"))
		{
			if(System.getProperty("browser").contains("headless"))
			{
				opt.addArguments("headless");
			}
			driver = new ChromeDriver(opt);
		}
		
		driver.manage().window().maximize();

		return driver;
	}
	
	public String screenShot(WebDriver driver, String methodName) throws WebDriverException, IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		String destFile=System.getProperty("user.dir")+"\\Screenshots\\"+methodName+".png";
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(destFile));
		return destFile;
	}

}
