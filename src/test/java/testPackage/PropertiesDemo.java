package testPackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;


public class PropertiesDemo {
	File f;
	FileReader fr;
	Properties prop;
	
	@Test(priority=-3)
	public void checking()
	{
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver=new ChromeDriver();
		//driver.get(prop.getProperty("url"));
		
	}
	@Test(priority=-4)
	public void cagetprop() throws IOException
	{
		f=new File("C:\\Users\\RAMAC\\eclipse-workspace\\SeleniumTest1\\src\\test\\resources\\config.properties");
		fr=new FileReader(f);
		prop=new Properties();
		prop.load(fr);
		
	}
}
