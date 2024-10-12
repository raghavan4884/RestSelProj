package com.test.utilities;

import java.util.List;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class General19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification request=RestAssured.given();
		Response response=request.get();
		JsonPath js=response.jsonPath();
		List<String> ll=js.get("data.id");
		
		//String s=js.getString("data.id[0]");
		//String s=js.getString("support.url");
		//System.out.println(s);
		System.out.println(ll);
		
		response.then().assertThat().body("data.id", Matchers.hasItems(1,2,3,4,5));		
		System.out.println("passed");

	}

}
