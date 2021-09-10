package Revision.SelfProject2;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> tlextentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
		tlextentTest.set(test);
	}

	public void onTestSuccess(ITestResult result)
	{
		tlextentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		WebDriver driver = null;
		String methodName = result.getMethod().getMethodName();
		try
		{
			driver= (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String dest= screenShot(driver,methodName);
			tlextentTest.get().addScreenCaptureFromPath(dest, result.getMethod().getMethodName());
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
		extent.flush();
	}
	

}
