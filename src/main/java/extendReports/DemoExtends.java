package extendReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoExtends  {
	
	
	
	public void init()
	{
		System.out.println("extend");
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\RAMAC\\eclipse-workspace\\seleniumTesting\\src\\main\\resources\\Reports\\extentdemo.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
	}

}
