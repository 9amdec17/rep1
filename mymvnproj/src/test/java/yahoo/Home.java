package yahoo;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ATUReportsListener.class,MethodListener.class,ConfigurationListener.class})
public class Home extends MainClass
{
  
	{
		System.setProperty("atu.reporter.config", "e:\\9am_dec_17\\atu.properties");
	}
	
  public void open()
  {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://login.yahoo.com/?.src=ym&.intl=us&authMechanism=primary&yid=&done=https%3A%2F%2Fmail.yahoo.com%2F&eid=100&add=1"); 
  }
  public void createacc() throws Exception
  {
	open();
	Reporter.log("<font color='green'><b>Creating a new user</b></font>");
	driver.findElement(By.id("createacc")).click();
	Thread.sleep(5000);
	if(driver.findElement(By.name("firstName")).isDisplayed())
	  ATUReports.add("reg page is displayed", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	else
	  Reporter.log("<font color='red'><b>Sign up not working</b></font>");	
	
	//driver.findElement(By.name("firstName")).sendKeys("abcd");
	//enter lastname, yahooid, select month,day, year....etc
	
  }
  public void login() throws Exception
  {
	open();	
	driver.findElement(By.name("username")).sendKeys("venkat123456a");
	driver.findElement(By.name("signin")).click();
	Thread.sleep(5000);
	driver.findElement(By.name("password")).sendKeys("mqq987654");	
	driver.findElement(By.name("verifyPassword")).click();
  }
}
