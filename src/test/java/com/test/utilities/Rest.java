package com.test.utilities;

import java.io.*;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseLogSpec;
import io.restassured.specification.RequestSpecification;

public class Rest {

	public static void main(String args[])
	{
		//RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.baseURI="https://reqres.in/api/products/";
		RequestSpecification request=RestAssured.given().basePath("{id}").pathParam("id", "3");
		//RequestSpecification request=RestAssured.given().queryParam("page", "2");
		

		Response response=request.get();
		ResponseBody rb=response.getBody();
		response.getTime();
		response.asPrettyString();
		response.then().assertThat().time(Matchers.lessThan(2000L));
		System.currentTimeMillis();

		//Header header=response.getHeader("heasdr");
		response.then().log().all();
		response.then().log().headers();
		response.then().log().body();
		
		rb.prettyPrint();
		
		File file=new File("1.txt");
		try {
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(response.asPrettyString());
		
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			
		}
		
		response.then().log().all();
		//response.then().log().headers();
		//response.then().log().body();
		
		response.then().assertThat().time(Matchers.lessThan(2000L));
	/*	response.getTime();
		JsonPath js=response.jsonPath();
		//List<String> s=response.then().extract().path("data[(?(@.id==7&&@.email==michael.lawson@reqres.in)]");
		//System.out.println(s);
		System.out.println("hi");
		//System.out.println(js.get("data.id[0]"));
		
		int i=js.getInt("data.id[0]");
		String d=Integer.toString(i);
		String s=js.getString("data.email[0]");
		Assertions.assertTrue((d.equals("7")) && (s.equals("michael.lawson@reqres.in")) );
		
		response.then().assertThat().body("data.id",Matchers.hasItems(7));
		System.out.println("mtahced");*/
		
	}
}
