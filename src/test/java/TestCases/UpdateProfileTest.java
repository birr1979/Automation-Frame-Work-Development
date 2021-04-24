package TestCases;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.LandingPage;

public class UpdateProfileTest extends BaseTest{



	@Test
	public void LoginPageTest () throws InterruptedException { 
		LandingPage twitter=new LandingPage(getDriver());
		log.info("Driver initilized and Landing Page opened success.");
		twitter.goToLogin().doSignIn("birrpro2", "ethio1234");
		log.info("Login sucessful for user 'UserName'");
		twitter.menu.goToProfilePage().changeProfilePicture();

		Thread.sleep(2000);

		twitter.menu.goToNotificationPage().seeAllNotifications();
		Thread.sleep(2000);
		twitter.menu.goToNotificationPage().seeMentionNotifications();
		twitter.menu.logOut();
		log.info("Log out sucessful for user 'UserName'");
		Thread.sleep(7000);

	}
}
