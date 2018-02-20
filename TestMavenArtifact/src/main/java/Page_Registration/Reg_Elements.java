package Page_Registration;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class Reg_Elements {

	public WebDriver driver;
	
	//Assign driver
	public Reg_Elements(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Find All elements of Registration form
	
	@FindBy(how=How.NAME, using="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(how=How.NAME, using="last_name")
	WebElement lastName;
	
	//@FindBy(how=How.NAME, using="radio_4[]")
	//WebElement rd_Single;
	
	//@FindBy(how=How.XPATH, using="//*[@id=\"pie_register\"]/li[3]/div/div[1]/input")
	//WebElement cb_Hobby;
	
	
	
	@FindBy(how=How.NAME, using="pie_submit")
	WebElement submit;
	
	@FindBy(how=How.NAME, using="dropdown_7")
	WebElement dd_Country;
	
	
	@FindBy(how=How.NAME, using="date_8[date][mm]")
	WebElement dd_Month;

	@FindBy(how=How.NAME, using="date_8[date][dd]")
	WebElement dd_Day;
	
	@FindBy(how=How.NAME, using="date_8[date][yy]")
	WebElement dd_Year;
	
	
	@FindBy(how=How.NAME, using="phone_9")
	WebElement phone;
	
	@FindBy(how=How.NAME, using="username")
	WebElement username;
	
	@FindBy(how=How.NAME, using="e_mail")
	WebElement email;
	
	//Choose file
	
	@FindBy(how=How.NAME, using ="profile_pic_10")
	WebElement profilePic;
	
	@FindBy(how=How.NAME, using="description")
	WebElement about;
	
	@FindBy(how=How.NAME, using="password")
	WebElement pass;
	
	@FindBy(how=How.ID, using="confirm_password_password_2")
	WebElement C_Pass;
	
	String exp="Mismatch";
	
	
	@FindBy(how=How.ID, using ="piereg_passwordStrength")
	WebElement act;
	
	
	
	// Create methods to perform actions
	
	public void fillForm() throws AWTException
	{
		firstName.sendKeys("Test FirstName");
		
		lastName.sendKeys("Test LastName");
		
		//Randomly select radio button
		
		List<WebElement> radio= driver.findElements(By.xpath("//*[@id=\"pie_register\"]/li[2]/div/div/input"));
		
		Random r = new Random();
		int x= r.nextInt(radio.size());
		radio.get(x).click();
		
		//Select Checkboxes
		List<WebElement> chb= driver.findElements(By.xpath("//*[@id=\"pie_register\"]/li[3]/div/div/input"));
		
		for (WebElement we : chb) {
			
			if(!we.isSelected())
			{
				we.click();
				
				System.out.println("Checkbox selected");
			}
			
		}
		
		
		
		Select cntry= new Select(dd_Country);
		
		cntry.selectByVisibleText("India");
		
		Select mnth= new Select(dd_Month);
		mnth.selectByValue("4");
		
		Select day= new Select(dd_Day);
		day.selectByIndex(15);
		
		Select year= new Select(dd_Year);
		year.selectByValue("1992");
		
		phone.sendKeys("9130088065");
		
		username.sendKeys("testUser");
		
		email.sendKeys("Test@gamil.com");
		
		//File Uploaded
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		profilePic.click();
		
		WebElement popup= driver.switchTo().activeElement();
		popup.sendKeys("C:\\Pavan_All Work\\BlueSpire\\Project Docs\\Testing Images\\Arnav innovations_corporate trainings.jpg");
		
		//popup.sendKeys(Keys.ENTER);
			
		
		about.sendKeys("This is text area. It is used to write multiple lines.");
		
		pass.sendKeys("pasword1");
		
		C_Pass.sendKeys("pasword");
		
		submit.click();
		
		System.out.println("The form is filled");
	}
	
	public void checkMsg()
	{
		Assert.assertTrue(exp.equalsIgnoreCase(act.getText()));
	}
	
	
	
	
}
