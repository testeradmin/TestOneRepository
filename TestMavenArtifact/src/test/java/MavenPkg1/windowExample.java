package MavenPkg1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CustomLibrary.BrowserFactory;

public class windowExample {
	
	WebDriver driver;
	
	@Test
	public void multiWindows()
	{
		driver=BrowserFactory.openBrowser("Chrome", "http://demoqa.com/registration/");
		
		driver.findElement(By.linkText("Frames and windows")).click();
		
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("New Browser Tab")).click();
		
		Set<String> allwin= driver.getWindowHandles();
		
		ArrayList<String> arr= new ArrayList<String>(allwin);
		
		System.out.println("Title is -" +driver.getTitle());
		
		driver.switchTo().window(arr.get(1));
		
		System.out.println("Title is -" +driver.getTitle() );
		
		driver.close();
		
		driver.switchTo().window(arr.get(0));
		System.out.println("Title is -" +driver.getTitle() );
		
		driver.quit();
		
	}
}
