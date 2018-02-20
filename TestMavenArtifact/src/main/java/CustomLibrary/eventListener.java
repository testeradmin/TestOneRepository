package CustomLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class eventListener implements ITestListener{

	@Override
	public void onFinish(ITestContext res) {
		// TODO Auto-generated method stub
		
		System.out.println("Test finished-"+ res.getName());
		
	}

	@Override
	public void onStart(ITestContext res) {
		// TODO Auto-generated method stub
		
		System.out.println("Test started-"+ res.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult res) {
		// TODO Auto-generated method stub
		System.out.println("Test failed-"+ res.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult res) {
		// TODO Auto-generated method stub
		
		System.out.println("Actual Test started-"+ res.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult res) {
		// TODO Auto-generated method stub
		
		System.out.println("Test Sussessed-"+ res.getName());
		
	}
	
	

}
