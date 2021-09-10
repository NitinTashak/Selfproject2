package Revision.SelfProject2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import POMFiles.HomePage;

public class FeelingLuckyTest extends BaseClass
{
	WebDriver driver;
	@BeforeMethod
	public void bLaunch() throws FileNotFoundException, IOException
	{
		driver = launchBrowser();
		driver.navigate().to(prop.getProperty("url"));
	}
	@Test
	public void happySearch()
	{
		HomePage hp = new HomePage(driver);
		hp.feelingLucky().click();
		Assert.assertTrue(false);
	}
	@AfterTest
	public void cBrowser()
	{
		driver.quit();
	}
}
