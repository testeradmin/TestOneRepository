package MavenPkg1;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CustomLibrary.BrowserFactory;

public class handleScroll {

	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser()
	{
		driver=	BrowserFactory.openBrowser("Chrome", "http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");	
	}
	
	@Test(priority=1)
	public void pageScroll() throws InterruptedException
	{
			
	Thread.sleep(5000);
		
	((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		
	}
	
	@Test(priority=2)
	public void scrollView()
	{
		WebElement element= driver.findElement(By.xpath("//*[@id=\"mCSB_3_container\"]/p[3]"));
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//js.executeScript("arguments[0].scrollIntoView(true);",element);
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
		System.out.println(element.getText());
		
	}
	
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
		
	}
}
