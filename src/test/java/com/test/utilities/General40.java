package com.test.utilities;

import org.openqa.selenium.WebElement;

public class General40 extends General39{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		General40 g=new General40();
		g.openBrowser();
		g.openUrl("https:\\www.google.com");
		General38 g1=new General38();
	WebElement element=	g1.getElement("txt_Element", "xpath", "//textArea[@name='q']");
		g1.enterValue(element, "java");
		Thread.sleep(1000);
		g.quitBrowser();
		
		
		
	}

}
