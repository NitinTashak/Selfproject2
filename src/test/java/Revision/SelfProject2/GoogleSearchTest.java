package Revision.SelfProject2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import POMFiles.HomePage;
import POMFiles.ImagePage;

public class GoogleSearchTest extends BaseClass
{
	WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	
	@BeforeClass
	public void bLaunch() throws FileNotFoundException, IOException
	{
		driver = launchBrowser();
		log.info("browser launched");
		
	}
	@BeforeMethod
	public void lPage()
	{
		driver.navigate().to(prop.getProperty("url"));
	}
	
	@Test(dataProvider="ExcelData")
	public void SearchTest(String TC, String data)
	{
		HomePage hp = new HomePage(driver);
		hp.searchBox().sendKeys(data+Keys.ENTER);
		//hp.searchButton().click();
		
		if(TC.equals("Positive"))
		{
			ImagePage ip = new ImagePage(driver);
			ip.images().click();
		}
		else
		{
			Assert.assertTrue(false);
		}
				
	}
	@AfterTest
	public void cBrowser()
	{
		driver.quit();
	}
	
	@DataProvider (name="ExcelData")
	public Object[][] readData() throws IOException
	{
		Object[][] obj = null;
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\sele.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(1).getLastCellNum();
		
		obj = new Object[lastRow][lastCell];
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
			{
				obj[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}

}
