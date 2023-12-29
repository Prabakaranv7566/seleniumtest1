package testPackage;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SparkReport {
	
	//ChromeDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	By ConfirmName=By.xpath("//div[@id='dataCanvas']/child::div/child::p/child::span");
	By ConfirmGender=By.xpath(null);
	By ConfirmBirth=By.xpath(null);
	By ConfirmAddress=By.xpath(null);
	By ConfirmPhone=By.xpath(null);
	By ConfirmRelative=By.xpath(null);
	
	
	public void sparkCheck()
	{
		System.out.println("extend");
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\RAMAC\\eclipse-workspace\\SeleniumTest1\\src\\main\\resources\\Reports\\extendDemo2.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	public void checkLogin()
	{
		
	}
}
