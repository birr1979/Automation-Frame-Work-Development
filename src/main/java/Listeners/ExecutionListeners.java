package Listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import BaseTest.BaseTest;


public class ExecutionListeners extends BaseTest implements ITestListener {
	/**
	 * This Is a class that listens all the execution of the Test cases and
	 * will provide information if the Test Case is Passed, Skipped or Failed.
	 * 
	 */

	public static String ScreenShot;
	public void onTestStart(ITestResult result) {
		System.out.println("******************Test Started: "+result.getMethod().getMethodName()+"***************************");
		
	}

	public void onTestSuccess(ITestResult result) {
		String logText="<b>"+"TestCase: "+result.getMethod().getMethodName().toUpperCase()+" PASSED " +"<b>";
		Markup m= MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);
		test.log(Status.INFO, "*** TEst PASSED ***");
		test.log(Status.INFO, result.getMethod().getMethodName());
			
		System.out.println("*********************Test Sucess: "+result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		/*
		 * 1. include stackTrance
		 * e. screenshot
		 * 
		 * 
		 * */
		String testName=result.getMethod().getMethodName();
		//convert the exception to string and store it
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
	
				
		test.info("<details open> <summary><strong> Exception Occurred: Click to view Details: </strong></summary>"+exceptionMessage+"</details>");
		
		
		
//		test.info("<details>" + "<summary>"+"Exception Occurred: Click to view Details. "+"</summary>"+exceptionMessage.replaceAll(",", "<br>")+"</details>" + "\n");
		//failure message
		String FailureMessage="<b>"+"Test Case: "+testName.toUpperCase()+" FAILED " +"</b>";
		Markup m= MarkupHelper.createLabel(FailureMessage, ExtentColor.RED);
		test.fail(m);
		test.log(Status.INFO, "TEst FAILED $$$$$$$$$$$$$$$$$");

		System.out.println("*****************Test Failed: "+result.getMethod().getMethodName());
		//take the screenshot
		
		try {
			ScreenShot = Utilities.TakeScreenShot.takeScreenShot(testName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//adding the screenshot
		try {
			test.addScreenCaptureFromPath(ScreenShot);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		test.info("<b>"+"font color= red"+ "Screenshoot of failure"+"</font>"+"</b>", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot).build());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("_********************Test Skipped: "+result.getMethod().getMethodName());
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	System.out.println("******************8skipped with success percentage: "+result.SUCCESS_PERCENTAGE_FAILURE);
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("***********Test Timeout (failed): "+result.getMethod().getMethodName());
		
	}

	

	public void onStart(ITestContext context) {
		test= reporter.createTest(context.getName());
		System.out.println("**************Test Suit Started: "+context.getSkippedTests());

		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$ Begin TestCase Execution  $$$$$$$$$$$$$$$$$$$$$$$$$$");
		test.info("$$$$$$$$$$$$$$$$$$$$$$$$$ Begin TestCase Execution  $$$$$$$$$$$$$$$$$$$$$$$$$$");


	}


	public void onFinish(ITestContext context) {
		System.out.println("********************Test Suit Finished: "+context.getSkippedTests());

		log.info("$$$$$$$$$$$$$$$$$$$$$$$$$ End TestCase Execution  $$$$$$$$$$$$$$$$$$$$$$$$$$");				
		test.info("$$$$$$$$$$$$$$$$$$$$$$$$$ End TestCase Execution  $$$$$$$$$$$$$$$$$$$$$$$$$$");


	}




}
