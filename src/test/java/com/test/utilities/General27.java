package com.test.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class General27 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//String fileName="d:\\file3.txt";
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("YYYY-MM-dd");		
		LocalDateTime now=LocalDateTime.now();
		//dtf.format(now);
		File file=new File("D:\\"+dtf1.format(now)+".txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		else
		{
			FileWriter fw=new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(fw);
			bw.write(dtf.format(now)+"-----hi");
			bw.close();
			fw.close();
		}
	}

}
