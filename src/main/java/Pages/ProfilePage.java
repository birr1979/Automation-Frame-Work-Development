package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePage.BasePage;

public class ProfilePage extends BasePage{
	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[contains(text(),'Set up profile')]")
	WebElement setUpProfile;
	
	@FindBy(xpath="//span[contains(text(),'Edit profile')]")
	WebElement editProfile;

	@FindBy(xpath="//input[@class='r-8akbif r-orgf3d r-1udh08x r-u8s1d r-xjis5s r-1wyyakw']")
	WebElement UploadProfilePicture;

	@FindBy(xpath="//span[contains(text(),'Apply')]")
	WebElement applyChange;

	@FindBy(xpath="//span[contains(text(),'Next')]")
	WebElement applyNext;

	@FindBy(xpath="//input")
	WebElement pickHeaderImage;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement saveChanges;

	@FindBy(xpath="//textarea[@name='text']")
	WebElement discribeBio;
	
	@FindBy(xpath="//span[contains(text(),'See profile')]")
	WebElement seeProfile;

	public ProfilePage setProfilePicture() {
		setUpProfile.click();
		UploadProfilePicture.sendKeys("C:\\Users\\birr_\\Desktop\\twitterProfile.jpg");
		applyChange.click();
		pickHeaderImage.sendKeys("C:\\Users\\birr_\\Desktop\\twitterProfileHeader.jpg");
		applyChange.click();
		applyNext.click();
		discribeBio.sendKeys("I am passionate in automation");
		applyNext.click();
		seeProfile.click();
		return new ProfilePage(driver);
	}

	public ProfilePage changeProfilePicture() {
		
		editProfile.click();
		UploadProfilePicture.sendKeys("C:\\Programming Related\\GIT\\FrameWorkDevelopmentExercises\\src\\test\\resources\\TwitterAccount\\ProfilePicture\\twitterProfile.jpg");
		applyChange.click();
		pickHeaderImage.sendKeys("C:\\Programming Related\\GIT\\FrameWorkDevelopmentExercises\\src\\test\\resources\\TwitterAccount\\ProfilePicture\\twitterProfileHeader.jpg");
		applyChange.click();
		saveChanges.click();
		return new ProfilePage(driver);
	}
	
	
	
	
}
