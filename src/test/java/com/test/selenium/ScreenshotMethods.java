package com.test.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotMethods extends BrowserMethods {
	
	


	public void getScreenShot(String fileName) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(fileName));
	}
	

	public byte[] getScreenShots() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] b=FileUtils.readFileToByteArray(src);
		return b;
	}
}
