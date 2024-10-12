package com.test.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class General28 {

	private Workbook workbook;
	private Sheet sheet;
	private Cell cell;
	
	General28(String fileName,String sheetName)
	{
		try
		{
		FileInputStream fis=new FileInputStream(fileName);
		String extension=fileName.substring(fileName.indexOf('.'));
		if(extension.contains(".xlsx"))
		{
			workbook=new XSSFWorkbook(fis);
		}
		else
		{
			workbook=new HSSFWorkbook(fis);
		}
		sheet=workbook.getSheet(sheetName);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
			e.toString();
			
		}
		
	}
	
	int getTotalRows()
	{
		return sheet.getPhysicalNumberOfRows();
	}
	int getTotalCols()
	{
		return sheet.getRow(0).getLastCellNum();
	}
	
	String getValue(int row,int col)
	{
		String s="";
		if(sheet.getRow(row).getCell(col).getCellType()==CellType.NUMERIC)
		{
			s=String.valueOf(sheet.getRow(row).getCell(col).getNumericCellValue());
		}
		else
		{
			s=sheet.getRow(row).getCell(col).getStringCellValue();
		}
		return s;
	}
	
	Object[][] value()
	{
		int row=this.getTotalRows();
		int col=this.getTotalCols();
		Object[][] obj=new Object[row][col];
		String data="";
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				data=this.getValue(i, j);
				obj[i-1][j]=data;
			}
		}
		return obj;
	}
	
	void writeToWorkbbok(int row,int col,String message,String fileName)
	{
		cell=sheet.getRow(row).createCell(col);
		cell.setCellValue(message);
		try
		{
		FileOutputStream fos=new FileOutputStream(fileName);
		workbook.write(fos);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void writeToFile(String fileName,String message) throws IOException
	{
		File file=new File(fileName);
		if(!file.exists())
		{
			file.createNewFile();
			
		}
	FileWriter fw=new FileWriter(file,true);
	BufferedWriter bw=new BufferedWriter(fw);
	bw.write(message);
	bw.close();
	fw.close();
	
	}
	
	
	void readFromFile(String fileName) throws IOException
	{
		File file=new File(fileName);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String s="";
		String s1="";
		while((s=br.readLine())!=null)
		{
			s1=s1+s;
		}
	}
	
	void getFileSize(String fileName)
	{
		File folder=new File(fileName);
		File[] files=folder.listFiles();
		for(File file:files)
		{
			if(file.isFile())
			{
				String name=file.getName();
				if(name.equals(""))
				{
					double d=file.length()/(1024*1024);
				}
			}
		}
	}
	
	void getProp(String property,String fileName)
	{
		try
		{
			FileInputStream fis=new FileInputStream(fileName);
			Properties prop=new Properties();
			prop.load(fis);
			String p=prop.getProperty(property);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void getBrokenLinks(String linkName) throws IOException
	{
		URL url=new URL(linkName);
		HttpURLConnection hc=(HttpURLConnection)url.openConnection();
		hc.setConnectTimeout(5000);
		hc.connect();
		hc.getResponseCode();
		hc.getResponseMessage();
		
	}
	
	void getBrokenImage(String imgName) throws ClientProtocolException, IOException
	{
		HttpClient client=(HttpClient) HttpClientBuilder.create().build();
		HttpGet request=new HttpGet(imgName);
		HttpResponse response=client.execute(request);
		response.getStatusLine().getStatusCode();
		
	}
	
	void xmlReader(String fileName,String tagName1,String tagName2) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		Document doc=db.parse(fileName);
		NodeList list=doc.getElementsByTagName(tagName1);
		for(int i=0;i<list.getLength();i++)
		{
		Node node=list.item(i);
		if(node.getNodeName().equals(Node.ELEMENT_NODE))
		{
			Element element=(Element) node;
			String s=element.getElementsByTagName(tagName2).item(0).getTextContent();
			String s1=element.getAttribute("attribute");
		}
		}
		
	}
	
	void JsonReader()
	{
		
		JSONObject obj=new JSONObject();
		obj.put("jsonKey", "jsonValue");
		String s=(String) obj.get("jsonKey");
		
		
	}
	
	void getLocalTime()
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		
		LocalDateTime now=LocalDateTime.now();
		dtf.format(now);
	}
	
	void addMinutes() throws ParseException
	{
		SimpleDateFormat sd=new SimpleDateFormat("HH:mm");
		String s="09:30";
		Date dd=sd.parse(s);
		Calendar cal=Calendar.getInstance();
		cal.setTime(dd);
		cal.add(Calendar.MINUTE,30);
		sd.format(cal.getTime());
	}
	
	void calendarControl()
	{
		System.setProperty("webdriver.chrome.driver", "chrome.exe");
		WebDriver driver=new ChromeDriver();
		WebElement element=driver.findElement(By.xpath(""));
		String d=element.getText();
		String date="3";
		String month="May";
		String year="2024";
		String s[]=d.split(" ");
		String dd=s[0];
		String m=s[1];
		String y=s[2];
		while(!month.equals(m)&&year.equals(y))
		{
			WebElement element1=driver.findElement(By.xpath(""));
			element1.click();
			element=driver.findElement(By.xpath(""));
			d=element.getText();
			dd=s[0];
			m=s[1];
			y=s[2];
		}
		List<WebElement> dayElement=driver.findElements(By.xpath(""));
		for(WebElement ele:dayElement)
		{
			if(ele.getText().equals(dd))
			{
				ele.click();
			}
		}
		
		WebElement tabElement=driver.findElement(By.xpath("//table"));
		List<WebElement> rowElements=tabElement.findElements(By.xpath("//tr"));
		for(WebElement row:rowElements)
		{
			List<WebElement> colElements=row.findElements(By.xpath("//td"));
			for(WebElement cc:colElements)
			{
				WebElement el=cc.findElement(By.xpath("//td"));
				el.getText();
			}
		}
		WebElement nextElement=driver.findElement(By.xpath(""));
		WebElement aaElement=driver.findElement(By.xpath(""));
		List<WebElement> nameElement=driver.findElements(By.xpath("//name"));
		ArrayList<String> al=new ArrayList<>();
		for(WebElement name:nameElement)
		{
			al.add(name.getText());
		}
		
		String oo=aaElement.getAttribute("");
		while(!oo.equals("diabled"))
		{
			nextElement.click();
			nameElement=driver.findElements(By.xpath("//name"));
			for(WebElement name:nameElement)
			{
				al.add(name.getText());
			}	
			oo=aaElement.getAttribute("");
			
		}
		
		List<WebElement> we=driver.findElements(By.xpath(""));
		boolean b=true;
		while(!b)
		{
			if(we.size()>0)
			{
				System.out.println("");
				b=true;
			}
			else
			{
				nextElement.click();	
			}
			
			
		}
		
		
		String parentWindow=driver.getWindowHandle();
		Set<String> childWindow=driver.getWindowHandles();
		List<String> windows=new ArrayList<>(childWindow);
		for(String ww:windows)
		{
			String tilte=driver.switchTo().window(ww).getTitle();
			if(tilte.equals("fdg"))
			{
				System.out.println("windowFound");
			}
		}
		
		if(ExpectedConditions.alertIsPresent()!=null)
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
			alert.dismiss();
			alert.sendKeys("dsf");
			alert.getText();
			
		}
		
		List<WebElement> frmElement=driver.findElements(By.xpath("//frame"));
		for(WebElement frm:frmElement)
		{
			driver.switchTo().frame(frm);
			if(nameElement.size()>0)
			{
				nameElement.get(0).click();
			}
			
			else
			{
				driver.switchTo().defaultContent();
			}
		}
	}
	
	
	
}

