package com.test.stepdefns;

import org.openqa.selenium.WebElement;

import com.test.utilities.General14;
import com.test.utilities.General15;
import com.test.utilities.General16;
import com.test.utilities.General17;

public class General1 extends General14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		General1 g1=new General1();
		General15 g15=new General15();
		General16 g16=new General16();

		g1.openBrowser();
		g1.getUrl("https://www.google.com");
		WebElement element=g15.getElement("name","q");
		g16.enterValue(element, "Java");


	}

}
