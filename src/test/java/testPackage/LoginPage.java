package testPackage;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends PropertiesDemo{
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	String getbirth;
	
	By uname = By.xpath("//input[@name='username']");
	By Loginpassword = By.xpath("//input[@type='password']");
	By OutPatient = By.xpath("//li[@id='Outpatient Clinic']");
	By Loginbtn = By.id("loginButton");
	By RegPatient = By.linkText("Register a patient");
	By gname1 = By.xpath("//input[@name='givenName']");
	By FamilyName = By.xpath("//input[@name='familyName']");
	By Nextbtn = By.id("next-button");
	By Male = By.xpath("//option[@value='M']");
	By Bdate = By.name("birthdateDay");
	By Bmonth = By.name("birthdateMonth");
	By Byear = By.name("birthdateYear");
	By Addrs1 = By.id("address1");
	By City1 = By.id("cityVillage");
	By Cntry1 = By.id("country");
	By St = By.id("stateProvince");
	By Pcode = By.id("postalCode");
	By Ph = By.name("phoneNumber");
	By Relation = By.name("relationship_type");
	By Person = By.xpath("//input[@placeholder='Person Name']");
	
	By ConfirmName=By.xpath("//div[@id='dataCanvas']//p[1]");
	By ConfirmGender=By.xpath("//div[@id='dataCanvas']//p[2]");
	By ConfirmBirth=By.xpath("//div[@id='dataCanvas']//p[3]");
	By ConfirmAddress=By.xpath("//div[@id='dataCanvas']//p[4]");
	By ConfirmPhone=By.xpath("//div[@id='dataCanvas']//p[5]");
	By ConfirmRelative=By.xpath("//div[@id='dataCanvas']//p[6]");
	
	By confirm=By.xpath("//input[@value='Confirm']");
	By agechk=By.xpath("//div[@class='gender-age col-auto']//span[2]");
	By startVisit=By.xpath("//div[@class='col-11 col-lg-10']");
	By confirmbtn=By.xpath("//button[@id='start-visit-with-visittype-confirm']");
	By captureVitals=By.xpath("//a[text()=' Capture Vitals']");
	By captureVitals1=By.xpath("//div[@class='main-content col-6 col-sm-6 col-md-9 col-lg-9']/div/div[2]/a[4]");
	By iconVitals=By.xpath("//i[@class='icon-vitals']");
	By newCapture=By.xpath("//a[@class='button task activelist'][5]");
	
			
			@Test(priority = -2)
	public void mainlogin() throws InterruptedException {
		System.out.println("init");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		WebElement username = driver.findElement(uname);
		username.sendKeys(prop.getProperty("loginusername"));
		WebElement password = driver.findElement(Loginpassword);
		password.sendKeys(prop.getProperty("Loginuserpass"));
		driver.findElement(OutPatient).click();
		driver.findElement(Loginbtn).click();
		Thread.sleep(2000);
	}

	@Test(priority=-1)
	public void init1() throws InterruptedException 
	{
		System.out.println("init1");
		driver.findElement(RegPatient).click();
		WebElement gname = driver.findElement(gname1);
		gname.sendKeys(prop.getProperty("patientfirstname"));
		WebElement fname = driver.findElement(FamilyName);
		fname.sendKeys(prop.getProperty("patientfamilyname"));
		driver.findElement(Nextbtn).click();
		driver.findElement(Male).click();
		driver.findElement(Nextbtn).click();
		WebElement birthdate = driver.findElement(Bdate);
		birthdate.sendKeys(prop.getProperty("patientbirthdate"));
		WebElement month = driver.findElement(Bmonth);
		Select s = new Select(month);
		s.selectByVisibleText("May");
		WebElement year = driver.findElement(Byear);
		year.sendKeys(prop.getProperty("patientbirthyear"));
		driver.findElement(Nextbtn).click();
		Thread.sleep(1000);
		WebElement add1 = driver.findElement(Addrs1);
		add1.sendKeys(prop.getProperty("patientaddress"));
		WebElement city = driver.findElement(City1);
		city.sendKeys(prop.getProperty("patientaddress1"));
		WebElement country = driver.findElement(Cntry1);
		country.sendKeys(prop.getProperty("patientcountry"));
		WebElement state = driver.findElement(St);
		state.sendKeys(prop.getProperty("patientstate"));
		WebElement post = driver.findElement(Pcode);
		post.sendKeys(prop.getProperty("patientpincode"));
		driver.findElement(Nextbtn).click();
		WebElement phone = driver.findElement(Ph);
		phone.sendKeys(prop.getProperty("patientphone"));
		driver.findElement(Nextbtn).click();
		WebElement relationShip = driver.findElement(Relation);
		Select r = new Select(relationShip);
		r.selectByVisibleText("Parent");
		WebElement personName = driver.findElement(Person);
		personName.sendKeys(prop.getProperty("patientrelative"));
		driver.findElement(Nextbtn).click();
	}
	@Test(priority=0)
	public void sparkCheck()
	{
		System.out.println("extend");
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\RAMAC\\eclipse-workspace\\SeleniumTest1\\src\\main\\resources\\Reports\\extendDemo2.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@Test(priority=1)
	public void RegisterpatientCheck()
	{
		WebElement retrive1 = driver.findElement(ConfirmName);
		String getName=retrive1.getText();
		WebElement retrive2 = driver.findElement(ConfirmGender);
		String getGender=retrive2.getText();
		WebElement retrive3 = driver.findElement(ConfirmBirth);
		getbirth=retrive3.getText();
		WebElement retrive4 = driver.findElement(ConfirmAddress);
		String getAddress=retrive4.getText();
		WebElement retrive5 = driver.findElement(ConfirmPhone);
		String getPhone=retrive5.getText();
		
		test = extent.createTest("Check Register patient details");
		test.log(Status.INFO, "Check Given and Actual patient details");
		
		if (getName.contains(prop.getProperty("patientfirstname"))) 
		{
			test.pass("Patient Name Matched");
			if (getGender.contains("Male"))

			{
				test.pass("patient Gender matched");
				if(getbirth.contains(prop.getProperty("patientbirthyear")))
				{
					test.pass("patient Birth Matched");
					if(getAddress.contains(prop.getProperty("patientaddress")))
					{
						test.pass("Patient address Matched");
						if(getPhone.contains(prop.getProperty("patientphone")))
						{
							test.pass("Patient Phone Matched");
							driver.findElement(confirm).click();
						}
				
					}
				}
			}
		} 
		else 
		{
			test.fail("patient details not matched");
			System.out.println("Fail");
		}
		extent.flush();
	}
	
	@Test(priority=2)
	public void AgeCheck() throws InterruptedException
	{
		Thread.sleep(2000);
		//Calendar Cal = Calendar.getInstance();
		//int currentYear=Cal.get(Calendar.YEAR);	
		String givenYear12 = prop.getProperty("patientbirthyear");
		
		int newyear=Integer.parseInt(givenYear12);
		
		String newYearString = String.valueOf(newyear);		
		//int checkAge=(currentYear-newyear);
		
		WebElement sysAge = driver.findElement(agechk);
		
		String ageverification = sysAge.getText();
		
		if(ageverification.contains(newYearString))
		{
			System.out.println("age matched");
		}
		else
		{
			System.out.println("age not matched");
		}
	}
	@Test(priority=3)
	public void startVisitcheck() throws InterruptedException
	{
		System.out.println("ok1");
		driver.findElement(startVisit).click();
		System.out.println("ok2");
		driver.findElement(confirmbtn).click();
		System.out.println("ok3");
		Thread.sleep(5000);
		WebElement capturevitals = driver.findElement(captureVitals);
		capturevitals.click();
		System.out.println("ok4");
	}

}
