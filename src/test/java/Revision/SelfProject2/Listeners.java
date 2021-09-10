package Revision.SelfProject2;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
	}

	public void onTestSuccess(ITestResult result)
	{
		
	}

	public void onTestFailure(ITestResult result) 
	{
		WebDriver driver = null;
		String methodName = result.getMethod().getMethodName();
		try
		{
			driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			screenShot(driver,methodName);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result)
	{
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
	}

	public void onStart(ITestContext context)
	{
		
	}

	public void onFinish(ITestContext context)
	{
	}
	

}
