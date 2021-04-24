package TestCases;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import Pages.LandingPage;

public class SendAMessageTest extends BaseTest{
	@Test
	public void LoginPageTest () throws InterruptedException { 
		LandingPage twitter=new LandingPage(getDriver());
		log.info("Driver initilized and Landing Page opened success.");
		twitter.goToLogin().doSignIn("birrpro2", "ethio1234");
		log.info("Login sucessful for user 'UserName'");

		twitter.menu.goToMessagesPage().sendMessage("@ruteBelay", "Hi how have you been, how is Class going on. This is a Automation Test ");
		twitter.menu.logOut();
		log.info("Log out sucessful for user 'UserName'");

		Thread.sleep(5000);

	}

	

}
