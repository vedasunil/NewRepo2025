package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable {

	 static WebDriver driver;
	@Test(priority=1)
	public void webtableautomate()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int row =driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		int col=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
	
		
	
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				String name=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+(i)+"]/td["+(j)+"]")).getText();
				System.out.println(name);
				if(name.equals("UK"))
				{
				Assert.assertTrue(true);
				}
			}
		}
		//Assert.fail();
	
		//driver.quit();
		
	}	
	
   @AfterMethod()
   public void teardown()
   {
	   if(driver!=null)
		   driver.quit();
   }			

}
