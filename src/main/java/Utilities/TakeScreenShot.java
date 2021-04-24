package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseTest.BaseTest;

public class TakeScreenShot extends BaseTest{
	//	File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()+ ".png");
	public static String takeScreenShot(String testName) throws IOException {
		
					Date date= new Date();
					String file=date.toString().replace(":", "_").replace(" ", "_");
					
					String fileName= file.substring(0,19);
					
					
					File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
					String screenShotFilePath=System.getProperty("user.dir")+"\\src\\main\\resources\\Screenshots\\"+fileName+"_"+testName+"_Screenshoot.png";
					
					FileUtils.copyFile(screenshot, new File(screenShotFilePath));
					return screenShotFilePath;
				}
}
