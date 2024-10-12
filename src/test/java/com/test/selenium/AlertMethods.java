package com.test.selenium;

import org.openqa.selenium.Alert;

public class AlertMethods extends BrowserMethods{
	
	public Alert getAlert()
	{
		Alert alert=driver.switchTo().alert();
		return alert;
	}
	public void acceptAlert()
	{
		getAlert().accept();
	}
	public void dismissAlert()
	{
		getAlert().dismiss();
	}
	public String getAlertText()
	{
		return getAlert().getText();
	}
	public void sendValuesToAlert(String value)
	{
		getAlert().sendKeys(value);
	}

}
