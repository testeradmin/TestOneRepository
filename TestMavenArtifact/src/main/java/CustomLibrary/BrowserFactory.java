package CustomLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	public static WebDriver openBrowser(String browserName, String url)
	{
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Pavan_All Work\\SeleniumHQ\\chromedriver_win32 (1)\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Pavan_All Work\\SeleniumHQ\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
		return driver;
	}

}
