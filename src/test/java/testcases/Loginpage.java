package testcases;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class Loginpage  {


	WebDriver driver;
	private String SignIn;
	private String Loginbtn;
	private String Nextbtn;
	private String PasswordBtn;
	private WebElement Logo;
	
	
	
	public Loginpage(WebDriver driver) 
	{   
		PageFactory.initElements(driver,this);
		this.driver = driver;
		Logo=driver.findElement(By.xpath("//a[text()='Zoho.com']"));
		SignIn="//a[text()='Sign In']";
		Loginbtn="//input[@id='login_id']";
		Nextbtn="//button[@id='nextbtn']";
		PasswordBtn="//input[@id='password']";
		
	}

	public boolean verifylogo()
	{

		return Logo.isDisplayed();
	}

	public void login(String username,String password) throws InterruptedException
	   {
				
			driver.findElement(By.xpath(SignIn)).click();
			Thread.sleep(8000);
			driver.findElement(By.xpath(Loginbtn)).sendKeys(username);
			Thread.sleep(5000);
			driver.findElement(By.xpath(Nextbtn)).click();			
			Thread.sleep(5000);
			driver.findElement(By.xpath(PasswordBtn)).sendKeys(password);
		}

}
