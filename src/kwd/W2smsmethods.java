package kwd;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class W2smsmethods
{
	public WebDriver driver;
	public WebDriverWait wait;
	 public String launch (String l, String d,String c)
	 {
		 driver=new ChromeDriver();
		 driver.get("http://www.way2sms.com");
		 driver.manage().window().maximize();
		 wait=new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		return ("Done");
		
	 }
	 public String fill(String l, String d,String c)
	 {
		 driver.findElement(By.xpath(l)).sendKeys(d);
		return ("done");
	 }
	 public String click(String l,String d,String c) throws Exception
	 {
		 driver.findElement(By.xpath(l)).click();
		 Thread.sleep(5000);
		 return("done");
	 }
	 public String validatelogin(String l, String d, String c)
	 {
		 try
		 {
			 if(c.equalsIgnoreCase("All_valid")&&driver.findElement(By.xpath("//*[text()='SendSMS']")).isDisplayed())
			 {
				 return("login with valid test passed");
			 }
			 else if(c.equalsIgnoreCase("Wrongsize_mbno")&&driver.findElement(By.xpath("//*[text()='Enter your mobile number']")).isDisplayed())
			 {
				 return("Blank mbno test passed");
			 }
			 else if(c.equalsIgnoreCase("Invalid_mbno")&&driver.findElement(By.xpath("//b[contains(text(),' not register with us.')]")).isDisplayed())
			 {
				 return("Invalid mbno test passed");
			 }
			 else if (c.equalsIgnoreCase("Blank_pwd")&&driver.findElement(By.xpath("(//*[text()='Enter password'])[1]")).isDisplayed())
			 {
				 return("Blank pwd test passed");
			 }
			 else if(c.equalsIgnoreCase("Invalid_pwd")&&driver.findElement(By.xpath("//b[contains(text(),'Try Again')]")).isDisplayed())
			 {
				 return("Invalid pwd test passed");
			 }
			 else
			 {
				 SimpleDateFormat sf= new SimpleDateFormat("dd-MMMM_YYYY-hh-mm-ss");
				 Date dt= new Date();
				 String fname=sf.format(dt);
				 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 File dest=new File(fname);
				 FileHandler.copy(src, dest);
				 return("login test failed adb see" +fname);
			 }
		 }
		 catch(Exception ex)
		 {
			 return(ex.getMessage());
		 }
	 }
	 public String closesite(String l,String d,String c)
	 {
		 driver.close();
		return ("done");
	 }
	 
}
		 
		 
	 
		 




