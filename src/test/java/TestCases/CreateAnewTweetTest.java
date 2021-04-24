package TestCases;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.LandingPage;
import Pages.HomePage;

public class CreateAnewTweetTest extends BaseTest{


	@Test
	public void LoginPageTest () throws InterruptedException {
		LandingPage twitter=new LandingPage(getDriver());
		twitter.goToLogin().doSignIn("birrpro2", "ethio1234");
		HomePage.createTweet("Crypto the feature digital money!!!");
		twitter.menu.logOut();

		Thread.sleep(5000);
		
		
		
		

	}
}
