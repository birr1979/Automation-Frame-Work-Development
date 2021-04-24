package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class ExplorePage extends BasePage{
	
	/**
	 * 
	 * 
	 */

	public ExplorePage(WebDriver driver) {
		super(driver);
			}
	
	
//WebElements on the Login Page
@FindBy(xpath="//input[@placeHolder='Search Twitter']")
public static WebElement searchTwitter;

@FindBy(xpath="(//div[@role='presentation'])[4]")
public static WebElement searchPeople;



public static void searchTwitter(String keyword) {
	searchTwitter.sendKeys(keyword);
}

public static void searchPeople() {
	searchPeople.click();
}
	

	
}
