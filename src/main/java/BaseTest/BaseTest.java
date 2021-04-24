package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * 1. Listener
 * 2. ObjRepository
 * 3. Exceptions
 * 4. Extent Reports
 */
public class BaseTest {

	//Static Variables declared
	public static String PropertiesFile_Path="src\\test\\resources\\TwitterAccount\\ObjRepository.properties";
	protected static WebDriver driver;
	public static Logger log=LogManager.getLogger(BaseTest.class.getName());
	public static Properties ObjRepo= new Properties();
	public static FileInputStream fis;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports reporter;
	public static ExtentTest test;
//	public static ThreadLocal<ExtentTest> testReporter= new ThreadLocal<ExtentTest>();
	public static Date date;
	public static WebElement element;

	@BeforeSuite
	public void setUp() {
		//Load the  Object repository file to the project
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Programming Related\\GIT\\FrameWorkDevelopmentExercises\\src\\test\\resources\\TwitterAccount\\DriverExecutables\\chromedriver.exe");
			fis=new FileInputStream(PropertiesFile_Path);
			log.info("Object Repository File Found Successfully.");
			ObjRepo.load(fis);
			log.info("Object Repository File Loaded Successfully. ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Problem while LOCATING Object Repository File.");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Problem while LOADING Object Repository File.");
		}

		//Launch Browser and Initialize 
		try {
			if (ObjRepo.getProperty("Browser").equalsIgnoreCase("Chrome")) {
				driver= new ChromeDriver();
				log.info((ObjRepo.getProperty("Browser").toUpperCase())+": Browser is Launched Successfully.");
			}else if (ObjRepo.getProperty("Browser").equalsIgnoreCase("FireFox")) {
				driver= new FirefoxDriver();
				log.info((ObjRepo.getProperty("Browser").toUpperCase())+": Browser is Launched Successfully.");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
		} catch (Exception e) {
			log.error((ObjRepo.getProperty("Browser").toUpperCase())+": Browser has encountered issue please try again!");
			e.printStackTrace();
		}
		
		//Extent Reporter design
		sparkReporter= new ExtentSparkReporter("C://Programming Related//GIT//FrameWorkDevelopmentExercises//src//main//resources//ExtentReports//extentReporter.html");
		sparkReporter.config().setEncoding("utf-8");
		sparkReporter.config().setDocumentTitle(ObjRepo.getProperty("DocTitle"));
		sparkReporter.config().setReportName(ObjRepo.getProperty("Author")+ObjRepo.getProperty("Report"));
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a '('zzz')'");

		reporter= new ExtentReports();
		reporter.attachReporter(sparkReporter);
		reporter.setSystemInfo("Operating System", "Windows 10");
		reporter.setSystemInfo("Enviroment", "Automation Testing");
		reporter.setSystemInfo("User Name", "Sendek@Pcs");	
		reporter.setSystemInfo("Company", "PCS Consultants");	
		
	}
	
	
		@BeforeMethod
		public void NavigatTo() {
			try {
				driver.get(ObjRepo.getProperty("Twitter_URL"));
				log.info("Navigated to :"+ ObjRepo.getProperty("Twitter_URL").toUpperCase());
			} catch (Exception e) {
				e.printStackTrace();
				log.error("error Navigating to :"+ ObjRepo.getProperty("Twitter_URL").toUpperCase());
			}
			

		}


		@AfterSuite
		public void tearDown() {
			try {
				driver.quit();
				fis.close();
				reporter.flush();
			} catch (IOException e) {
				log.error("Failure to generate Extent Report File. ");
				e.printStackTrace();
			}
		}
		
		
		  public static WebDriver getDriver() {
		        return driver;
		    }
		  
		  
		  
	}
