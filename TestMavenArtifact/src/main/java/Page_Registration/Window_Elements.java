package Page_Registration;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Window_Elements {
	
	public WebDriver driver;
	
	public Window_Elements(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.LINK_TEXT, using ="Frames and windows")
	WebElement lnk_wind;
	
	@FindBy(how=How.LINK_TEXT, using="New Browser Tab")
	WebElement bTab;
	
	@FindBy(how=How.LINK_TEXT, using="Open Seprate New Window")
	WebElement bWin;
	
	@FindBy(how=How.LINK_TEXT, using="Open New Seprate Window")
	WebElement lnk_New_Win;
	
	@FindBy(how=How.LINK_TEXT, using="Frameset")
	WebElement frame;
	
	@FindBy(how=How.LINK_TEXT, using="Open Frameset Window")
	WebElement frame_Win;
	
	//Click Frames and windows link
	
	public void click_WindLink()
	{
		lnk_wind.click();
	}
	
	public void handleBrowserTab()
	{
		bTab.click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Set<String> allWindows= driver.getWindowHandles();
		
		ArrayList<String> arr= new ArrayList<String>(allWindows);
		
		driver.switchTo().window(arr.get(1));
		
		System.out.println("Title of NEW Window is -" +driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(arr.get(0));
				
		System.out.println("Title of MAIN Window is -" + driver.getTitle());
		
		}
	
	public void handleNewWin()
	{
		bWin.click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		lnk_New_Win.click();
		
		Set<String> allwin=driver.getWindowHandles();
		
		ArrayList<String> arr=new ArrayList<String>(allwin);
		
		driver.switchTo().window(arr.get(1));
		
		System.out.println("Here is the title of SEPERATE window- " +driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(arr.get(0));
		
		System.out.println("Here is the title of BASE window- " +driver.getTitle());
		
		
	}
	
	public void handleFrame()
	{
		frame.click();
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		frame_Win.click();
		
		Set<String> wind=driver.getWindowHandles();
		ArrayList<String> arr= new ArrayList<String>(wind);
		
		driver.switchTo().window(arr.get(1));
		
		//Switch to frame using name
		driver.switchTo().frame("topFrame");
		
		System.out.println("Inside 1st frame");
		
		//back to main window
		driver.switchTo().defaultContent();
		
		//find frame using web element 
		WebElement frame1= driver.findElement(By.xpath("//frame[@name='contentFrame']"));
		
		driver.switchTo().frame(frame1);
		
		System.out.println("Inside 2nd frame");
		
		
	}
	
	
}
