package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer1 implements IRetryAnalyzer{
     public int retrycount=0;
     public int maxtry=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retrycount<maxtry)
		{
			retrycount++;
			return true;
		}
		return false;
	}

}
