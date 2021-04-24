package Rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RoughTest {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Programming Related\\GIT\\FrameWorkDevelopmentExercises\\src\\test\\resources\\TwitterAccount\\DriverExecutables\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://twitter.com");
		System.out.println(driver.getTitle());
	}
	

}
