package testPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendsNew  {
	
	ChromeDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@Test
	public void ccextendingNew()
	{
		System.out.println("extend");
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\RAMAC\\eclipse-workspace\\SeleniumTest1\\src\\main\\resources\\Reports\\extendDemo2.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}
	
	@Test
	public void checkTitle()
	{
		//1.create Test Name
		test = extent.createTest("Check Register patient details");
		//2.create status pass/fail/error 
		test.log(Status.INFO, "Capture FB Title");
		String actualTitle = driver.getTitle();
		//Assert.assertEquals(actualTitle, "");
		if(actualTitle.equals("Facebook – log in or sign up"))
		{
			test.pass("Title Matched");
			//Assert.assertTrue(true);
		}
		else
		{
			test.fail("Title not matched");
			//Assert.assertTrue(false);
		}
		
	}

	@AfterTest
	public void tearDown()
	{
		extent.flush();//save the file
		driver.quit();
	}

}
