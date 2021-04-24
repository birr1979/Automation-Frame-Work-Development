package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class MessagesPage extends BasePage{
	public MessagesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[@aria-label='Compose a DM']")
	WebElement compose;

	@FindBy(xpath="//input[@aria-label='Search query']")
	WebElement searchPeople;

	@FindBy(xpath="//span[contains(text(),'@BelayRute')]")
	WebElement selectPeople;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement nextButton;

	@FindBy(xpath="//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")
	WebElement messages;

	@FindBy(xpath="//div[@aria-label='Send']")
	WebElement sendButton;

	public MessagesPage sendMessage(String people, String message) throws InterruptedException {
		compose.click();
		searchPeople.sendKeys(people);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).click();
		nextButton.click();
		messages.sendKeys(message);
		sendButton.click();
		return new MessagesPage(driver);
	}







}
