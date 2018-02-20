package CustomLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class takeScreenshot {

	
	public static WebElement driver;
	
	public static void captureScreenshot(WebDriver driver, String scName) throws Exception
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./Screenshots/"+scName+".png"));
		
		System.out.println("Screenshot Taken");
		
	}
	
	
public static String returnScreenshot(WebDriver driver, String scname) throws IOException
{
	TakesScreenshot ts= (TakesScreenshot)driver;
	
	File src= ts.getScreenshotAs(OutputType.FILE);
	
	String dest= "./Screenshots/"+scname+".png";
	
	File destination= new File(dest);
	
	FileUtils.copyFile(src, destination);
	
	System.out.println("Screenshot Taken");
	
	return dest;
}
}
