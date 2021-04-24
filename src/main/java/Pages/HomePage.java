package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
			}
	
	
	//WebElements on the Login Page

		@FindBy (xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")
		static
		WebElement createNewTweet;
	
		@FindBy (xpath="//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div/div/span/span")
		static
		WebElement tweetButton;
	
	private static void enterTweet(String tweet) {
		createNewTweet.sendKeys(tweet);
	}
	
	private static void clickOnTweet() {
		tweetButton.click(); 
	}

	public static void createTweet(String tweet) {
		for (int i=1;i<=4;i++)		{	
		enterTweet("Twitte #"+i +":" +" "+tweet);
	
		clickOnTweet();
		}
		
		if(message="Something went wrong, but don’t fret — let’s give it another shot."
				enterTweet("Twitte #"+i+++":" +" "+tweet);

		#1. Fix Excel, issue
		#2. Fix create twitter sequence 
		#3. Loger and info at each steps
		Test case failure Message at last
	}
	
	
}
