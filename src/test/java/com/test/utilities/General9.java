package com.test.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.skyscreamer.jsonassert.JSONAssert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class General9 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification request=RestAssured.given();		
		Response response=request.get();
		ResponseBody body=response.getBody();
		//System.out.println(body.asPrettyString());
		File file=new File("d://3.json");
		FileWriter fw=new FileWriter(file,true);
		BufferedWriter bw=new BufferedWriter(fw);
		String ss=body.asPrettyString();
		bw.write(ss);
		System.out.println(ss);
		System.out.println("writtern in File");
		bw.close();
		fw.close();
		
		FileReader fr=new FileReader("d:\\4.json");
		BufferedReader br=new BufferedReader(fr);
		int i=0;
		String o=null;
		String val="";
		while((o=br.readLine())!=null)
		{
			val=val+o;
		}
		response.then().log().all();
		response.then().log().body();
		String sss=response.getHeader("ancd");
		//File f1=new File("D://New Text Document.txt");
		//File f2=new File("D://New Text Document (2).txt");
		   BufferedReader reader1 = new BufferedReader(new FileReader("D:\\3.json"));
	         
	        BufferedReader reader2 = new BufferedReader(new FileReader("D:\\4.json"));
	         
	        String line1 = reader1.readLine();
	         
	        String line2 = reader2.readLine();
	         
	        boolean areEqual = true;
	         
	        int lineNum = 1;
	         
	        while (line1 != null || line2 != null)
	        {
	            if(line1 == null || line2 == null)
	            {
	                areEqual = false;
	                 
	                break;
	            }
	            else if(! line1.equalsIgnoreCase(line2))
	            {
	                areEqual = false;
	                 
	                break;
	            }
	             
	            line1 = reader1.readLine();
	             
	            line2 = reader2.readLine();
	             
	            lineNum++;
	            
	            
		            
	        }
	        if(areEqual)
	        {
	            System.out.println("Two files have same content.");
	        }
	        else
	        {
	            System.out.println("Two files have different content. They differ at line "+lineNum);
	             
	            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
	        }
	        
	        reader1.close();
	         
	        reader2.close();
	         
	        ObjectMapper mapper1=new ObjectMapper();
	        File file1=new File("D://3.json");
	        File file2=new File("D://4.json");	        
	        JsonNode node1=mapper1.readTree(file1);
	        JsonNode node2=mapper1.readTree(file2);
	        System.out.println(node1.equals(node2));
	        
	        
	        //Gson gson=new Gson();
	        Gson gson = new Gson();
	        Type type = new TypeToken<Map<String, Object>>() {
	        }.getType();

	        //Map<String, Object> leftMap = gson.fromJson(file1, type);
	        //Map<String, Object> rightMap = gson.fromJson(file2, type);

	        
	        Map<String, Object> leftMap = gson.fromJson(body.asPrettyString(),type);
	        Map<String, Object> rightMap = gson.fromJson(val, type);
	        MapDifference<String, Object> difference = Maps.difference(leftMap, rightMap);

	        System.out.println("Files are " + (difference.areEqual() ? "Identical" : "Distinct"));

	        if (!difference.areEqual()) {
	            if (difference.entriesOnlyOnLeft().size() > 0) {
	                System.out.println("Entries only on the left\n--------------------------");
	                difference.entriesOnlyOnLeft().forEach((key, value) -> System.out.println(key + ": " + value));
	            }

	            if (difference.entriesOnlyOnRight().size() > 0) {
	                System.out.println("\n\nEntries only on the right\n--------------------------");
	                difference.entriesOnlyOnRight().forEach((key, value) -> System.out.println(key + ": " + value));
	            }

	            if (difference.entriesDiffering().size() > 0) {
	                System.out.println("\n\nEntries differing\n--------------------------");
	                difference.entriesDiffering().forEach((key, value) -> System.out.println(key + ": " + value));
	            }
	        }
	    }
	        
	        
	        
	        
	        
	
	

}
