package Rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TryBlockWithoutCatch {


	public static void rigthClick() {

		String locator="web element locator xpath";
		WebDriver driver = new FirefoxDriver();
		Actions a = new Actions(driver);
		WebElement element= driver.findElement(By.xpath(locator));
		a.moveToElement(element).contextClick().build().perform();

	}
}

