package TestCases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.LandingPage;
import Pages.NotificationsPage;
import Utilities.TestDataProvider;


public class LoginTest extends BaseTest{

	@Test//(dataProviderClass = TestDataProvider.class, dataProvider = "commonDataProvider")
	public void LoginPageTest () throws InterruptedException { 
		LandingPage twitter=new LandingPage(getDriver());
		log.info("Driver initilized and Landing Page opened success.");
		twitter.goToLogin().doSignIn("birrpro2","ethio1234");
		log.info("Login sucessful for user 'UserName'");
		twitter.menu.logOut();
		log.info("Log out sucessful for user 'UserName'");
		Thread.sleep(5000);
	}


}









