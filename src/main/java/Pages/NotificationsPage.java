package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.sun.tools.sjavac.Log;

import BasePage.BasePage;

public class NotificationsPage extends BasePage{
	public NotificationsPage(WebDriver driver) {
		super(driver);
	}
	
	
@FindBy(xpath="//span[contains(text(), 'All')]")
WebElement allNotifications;


@FindBy(xpath="//span[contains(text(), 'Mentions')]")
WebElement mentionNotifications;

@FindBy(xpath="//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']")
WebElement listofNotifications;


public void seeAllNotifications() {
	allNotifications.click();
	List<WebElement> allNotification=driver.findElements(By.xpath("//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']"));
	System.out.println("You have : "+allNotification.size()+" in the All Notification tab.");
	for(int i=0;i<allNotification.size();i++) {
		System.out.println(allNotification.get(i).getText());
	}
}

public void seeMentionNotifications() {
	mentionNotifications.click();
	List<WebElement> allNotification=driver.findElements(By.xpath("//div[@aria-label='Timeline: Notifications']//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']"));
	System.out.println("You have : "+allNotification.size()+" in the Mentions Notification tab.");
	for(int i=0;i<allNotification.size();i++) {
		System.out.println(allNotification.get(i).getText());
	}

}

}
