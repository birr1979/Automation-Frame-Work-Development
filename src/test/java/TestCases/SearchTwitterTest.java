package TestCases;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.ExplorePage;
import Pages.LandingPage;
import Pages.LoginPage;

public class SearchTwitterTest extends BaseTest{
	
	@Test
	public void searchTwitter() throws InterruptedException {
		LandingPage twitter=new LandingPage(getDriver());
		log.info("Driver initilized and Landing Page opened success.");
		twitter.goToLogin().doSignIn("birrpro2", "ethio1234");
		log.info("Login sucessful for user 'UserName'");
		
		twitter.menu.goExplorePage().searchTwitter("test engineer");
		
		//search results in the twitter

		twitter.menu.logOut();
		log.info("Log out sucessful for user 'UserName'");
		Thread.sleep(5000);

	}


}
