package yahoo;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class,MethodListener.class,ConfigurationListener.class})
public class Compose extends MainClass
{
  
	{
		System.setProperty("atu.reporter.config", "e:\\9am_dec_17\\atu.properties");
	}
  public void sendmail() throws Exception
  {
	  System.out.println("hello");
	  driver.findElement(By.xpath("//input[@class='composeicon']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("to")).sendKeys("abcd@gmail.com");
	  driver.findElement(By.id("Subj")).sendKeys("hello");
	  driver.findElement(By.name("Content")).sendKeys("this is sample mail");
	  driver.findElement(By.id("send_top")).click();
  }
  public void signout()
  {
	  driver.findElement(By.linkText("Sign Out")).click();
	  driver.close();
  }
}
