package com.test.utilities;

import org.openqa.selenium.WebElement;

public class General17 extends General14{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		General17 g17=new General17();
		General15 g15=new General15();
		General16 g16=new General16();

		g17.openBrowser();
		g17.getUrl("https://www.google.com");
		WebElement element=g15.getElement("name","q");
		g16.enterValue(element, "Java");
		
	}

}
