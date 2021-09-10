package POMFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="[title='Search']")
	private WebElement searchBox;
	
	@FindBy(css="[value='Google Search']")
	private WebElement searchButton;
	
	@FindBy(xpath="(//input[contains(@value,'Google Search')]/following-sibling::input)[2]")
	private WebElement feelingLucky;
	
	public WebElement searchBox()
	{
		return searchBox;
	}
	
	public WebElement searchButton()
	{
		return searchButton;
	}
	
	public WebElement feelingLucky()
	{
		return feelingLucky;
	}

}
