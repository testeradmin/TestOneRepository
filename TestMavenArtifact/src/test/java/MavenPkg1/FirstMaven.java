package MavenPkg1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CustomLibrary.BrowserFactory;
import CustomLibrary.excelData;
import CustomLibrary.takeScreenshot;
import Page_Registration.Reg_Elements;
import Page_Registration.Window_Elements;

@Listeners(CustomLibrary.eventListener.class)
public class FirstMaven {
	
	
	// This project is on GitHub now.
	
	
	WebDriver driver;
	
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void launchBrowser()
	{
		//Launch Browser
		driver= BrowserFactory.openBrowser("Chrome", "http://demoqa.com/registration/");
		
		
	}
	@Test(priority=1, enabled=false)
	public void registration() throws AWTException
	{
		
		//Create an object for page
		Reg_Elements page= PageFactory.initElements(driver, Reg_Elements.class);
		
		page.fillForm();
		
		page.checkMsg();
		
	}
	
	
	@Test(priority=2, enabled=false)
	public void windowframes()
	{
		Window_Elements we= PageFactory.initElements(driver, Window_Elements.class);
		
		we.click_WindLink();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		we.handleBrowserTab();
		
	}
	
	@Test(priority=3, enabled=false)
	public void sepWin()
	{
		Window_Elements pg= PageFactory.initElements(driver, Window_Elements.class);
		
		pg.click_WindLink();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		pg.handleNewWin();
	}
	
	@Test(priority=4, enabled=false)
	public void frames()
	{
		Window_Elements pg_frame= PageFactory.initElements(driver, Window_Elements.class);
		
		pg_frame.click_WindLink();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		pg_frame.handleFrame();
		
	}
	
	@DataProvider(name="provideData")
	public Object[][] passData()
	{
		excelData ex= new excelData("C:\\Pavan_All Work\\SeleniumHQ\\mvn_excel\\LoginCred.xlsx");
		
		int rows=ex.getLastRow(0);
		
		Object[][] data= new Object[rows][2];
		
		for (int i=0; i<rows; i++)
			{
				data[i][0]= ex.getExcelData(0, i, 0);
				data[i][1]= ex.getExcelData(0, i, 1);
			}
		
		return data;
		
		
	}
	@Test(dataProvider="provideData", enabled=false)
	public void login_ExcelData(String username, String password)
	{
		Reg_Elements page= PageFactory.initElements(driver, Reg_Elements.class);
		
		driver.findElement(By.name("first_name")).sendKeys(username);
		driver.findElement(By.name("last_name")).sendKeys(password);
		
		
	}

	//Generate Extent Report
	@Test
	public void reportTest()
	{
		report = new ExtentReports("C:\\Pavan_All Work\\SeleniumHQ\\Reports_Test\\ProjectReport.html");
		logger=report.startTest("pvnTest1");
		
		logger.log(LogStatus.INFO, "Browser Started");
		
		logger.log(LogStatus.INFO, "Application Started");
		String exp="DemoQA";
		
		assertTrue(driver.getTitle().contains("Demo"));
		logger.log(LogStatus.PASS, "Title matched");
		System.out.println("Title is verified and macthed");
	}
	
	/*@AfterMethod
	public void tearDown(ITestResult res) throws Exception
	{
		if(ITestResult.FAILURE==res.getStatus())
		{
			takeScreenshot.captureScreenshot(driver, "Reg_Failed");
		}
		driver.quit();
	}*/
	
	@AfterMethod
	public void failReport(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			String ss_path= takeScreenshot.returnScreenshot(driver,result.getName());
			String image=logger.addScreenCapture(ss_path);
			logger.log(LogStatus.FAIL, "TitleVerify",image);
			
			}
		
		report.endTest(logger);
		report.flush();
		driver.get("C:\\Pavan_All Work\\SeleniumHQ\\Reports_Test\\ProjectReport.html");
	}

}
