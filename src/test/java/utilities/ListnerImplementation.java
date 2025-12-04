package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.BaseTest;

public class ListnerImplementation extends BaseTest implements ITestListener{

	public void onTestStart(ITestResult result)
		{
			Reporter.log(result.getName()+": Test started");
			System.out.println(result.getName()+": Test started");
			
		}

	

}
