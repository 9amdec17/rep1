package yahoo;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class,MethodListener.class,ConfigurationListener.class})
public class SanityTest extends MainClass
{
	
	{
		System.setProperty("atu.reporter.config", "e:\\9am_dec_17\\atu.properties");
	}
	
	@Test
	@Parameters({"browser"})
	public void sanityTesting(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		 FileInputStream fin=new FileInputStream("e:\\9am_dec_17\\testdata.xlsx");
		  XSSFWorkbook wb=new XSSFWorkbook(fin);
		  
		  XSSFSheet ws= wb.getSheet("sanitytest");
		  Row row;
		  String classname,methodname;
		  for(int r=1;r<=ws.getLastRowNum();r++)
		  {
			 row=ws.getRow(r);
			 if(row.getCell(4).getStringCellValue().matches("yes"))
			 {
				 classname=row.getCell(2).getStringCellValue();
				 methodname=row.getCell(3).getStringCellValue();
				 
				 Class c=Class.forName(classname);//load the class into memory
				 Method m=c.getMethod(methodname,null);//get the method in the class
				 Object obj=c.newInstance(); //create instance forthe class
				 m.invoke(obj, null); 
				 
			 }
		  }
		  fin.close();
		
	}
}
