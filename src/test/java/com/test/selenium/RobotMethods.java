package com.test.selenium;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.sun.glass.events.KeyEvent;

public class RobotMethods {

	public void KeyDown(int key)
	{
		try
		{
		Robot robot=new Robot();
		robot.keyPress(key);
		
		//robot.keyPress(KeyEvent.VK_CONTROL);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void keyUp(int key)
	{
		try {
			
			Robot robot=new Robot();
			robot.keyRelease(key);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void mouseDown(int key)
	{
		try {
			
			Robot robot=new Robot();
			robot.mousePress(key);
			//robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void mouseUp(int key)
	{
		try {
			
			Robot robot=new Robot();
			robot.mouseRelease(key);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void mouseMove(int x,int y)
	{
		try {
			
			Robot robot=new Robot();
			robot.mouseMove(x,y);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void scrollMouse(int wheelAmt)
	{
		try {
			
			Robot robot=new Robot();
			robot.mouseWheel(wheelAmt);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void getScreenShot(String fileName)
	{
		try {
			
			Robot robot=new Robot();
			Rectangle rect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage img=robot.createScreenCapture(rect);
			ImageIO.write(img, "jpg", new File(fileName));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void uploadFile(String fileName)
	{
		try {
			Robot robot=new Robot();
			Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection sel=new StringSelection(fileName);
			clipboard.setContents(sel,null);
			
			
		}
			catch(Exception e)
		{
				e.printStackTrace();
		}
	
	}

}