package Revision.SelfProject2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class FileUploadTest
{
	@Test
	public void abc() throws IOException, InterruptedException
	{
		
		String downloadPath = System.getProperty("user.dir")+"\\DownloadedFiles";
		HashMap<String,Object> ChromePrefs = new HashMap<String,Object>();
		ChromePrefs.put("profile.default_content_settings.popups", 0);
		ChromePrefs.put("download.default_directory",downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", ChromePrefs);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver2.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://smallpdf.com/pdf-converter");
		driver.findElement(By.xpath("//*[text()='Choose Files']/../..")).click();
				
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\imp.exe"+" "+System.getProperty("user.dir")+"\\FileToUpload\\image.jpg");
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//canvas[@class='sc-46m2md-6 fcioeM']")));
		driver.findElement(By.xpath("//*[text()='Download']/..")).click();
		
		Thread.sleep(2000);
		File file = new File(downloadPath+"\\image-converted.pdf");
		if(file.exists())
		{
			System.out.println("File available");
			if(file.delete())
				System.out.println("File successfully deleted");
		}
		driver.close();
	}

}
