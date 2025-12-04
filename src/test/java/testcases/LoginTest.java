package testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.Configreader;
public class LoginTest extends BaseTest {

	Loginpage loginpage;
	
	@Test(priority = 1,groups= {"sanity"})
	    public void validateLogo() {
	        loginpage = new Loginpage(driver);
	        boolean logoPresent = loginpage.verifylogo();
	        Assert.assertTrue(logoPresent, "❌ Logo not displayed on login page!");
	        System.out.println("✅ Logo displayed successfully.");
	        Reporter.log("testreport 1");
	        //Wait <WebDriver> wait= new FluentWait <WebDriver> (driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring()); 
	        
	        //WebElement ele= wait.until(driver-> driver.findElement(null));
	    }
	
	
	  @Test(priority = 2)
	  public void Loginverify() throws InterruptedException
	  {
		  loginpage = new Loginpage(driver);
		  String username=Configreader.getProperty("username");
		  String password=Configreader.getProperty("password");
		
		  System.out.println("username;"+username);
		  System.out.println("password:"+password);
		  
		  loginpage.login(username, password); 
		  Reporter.log("testreport 2");
	  }
	  @Test(enabled= false)
	 public void verifybrokenlink()
	 {
		List <WebElement> links =driver.findElements(By.xpath("//a"));
		for(WebElement link:links)
		{
			System.out.println(link.getAttribute("href"));
		}
		Reporter.log("testreport 3");
	 }
	
	//@SuppressWarnings("deprecation")
	@Test(enabled= false)
	public void verifybrokenlinkls()
	{
		
		   List<WebElement> links = driver.findElements(By.tagName("a"));
	        System.out.println("Total links found: " + links.size());

	        int brokenLinksCount = 0;

	        // Loop through each link
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");

	            // Skip empty or javascript links
	            if (url == null || url.isEmpty() || url.startsWith("javascript")) {
	                continue;
	            }

	            try {
	                // Create HTTP connection
	                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	                connection.setRequestMethod("HEAD"); // Faster than GET
	                connection.connect();

	                int responseCode = connection.getResponseCode();

	                // If response >= 400 → broken link
	                if (responseCode >= 400) {
	                    System.out.println("❌ Broken link: " + url + " | Status: " + responseCode);
	                    brokenLinksCount++;
	                } else {
	                    System.out.println("✅ Valid link: " + url + " | Status: " + responseCode);
	                }

	            } catch (Exception e) {
	                System.out.println("⚠️ Exception for URL: " + url + " → " + e.getMessage());
	                brokenLinksCount++;
	            }
	        }

	        System.out.println("\nTotal broken links: " + brokenLinksCount);

	    }
	

@Test(enabled= false)

public void gettitlelink() throws InterruptedException
{
	
	List<WebElement> links= driver.findElements(By.tagName("a"));
	System.out.println(links.size());
	
	for(WebElement link:links)
	{
		
		String url=link.getAttribute("href");
		if(url==null || url.isEmpty())
			continue;
		Thread.sleep(1000);
		driver.get(url);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
	}
	
	
}
}




