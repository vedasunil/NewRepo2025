package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Configreader;

public class BaseTest {


	    protected WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	    	
	    	//String folderPath = System.getProperty("user.dir") + "/allure-results";
	    	String [] folders= {
	    			System.getProperty("user.dir") + "/allure-results",
	    			System.getProperty("user.dir") + "/src/test/resources/Sceenshots"
	    						
	    	};
	    	Configreader.deleteJsonFiles(folders);
	        String browser = Configreader.getProperty("browser");
	        String url = Configreader.getProperty("testurl");

	        System.out.println("=== Launching Browser: " + browser + " ===");

	        if (browser.equalsIgnoreCase("chrome")) {
	        	
	        	WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }
	        

	        driver.manage().window().maximize();
	        driver.get(url);
	    }

	    @AfterClass
	    public void tearDown() {
	        
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	            System.out.println("=== Closing Browser ===");
	        }
	        	        
	    }
	    @AfterMethod
	    public void Takescreenshot(ITestResult result) throws IOException
	    {
	    	Date currentdate= new Date();
	    	String localtime=currentdate.toString().replace(" ","-").replace(":", "-");
	    	
	    	System.out.println("---->"+result.getStatus());
	    	if(ITestResult.FAILURE==result.getStatus())
	    	{   
	    		System.out.println(result.getStatus());
	    		TakesScreenshot ts= (TakesScreenshot)driver;
	    		File scr =ts.getScreenshotAs(OutputType.FILE);
	    		String path=System.getProperty("user.dir")+"/src/test/resources/Screenshots/"+result.getName()+localtime+".png";
	    		File dest=new File(path);
	    		FileUtils.copyFile(scr,dest);
	    	}
	    }
	

}
