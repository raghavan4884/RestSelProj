package com.test.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class General21 {

	public int id[];
	public String email[];
	public String first_name[];
	public String last_name[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification request=RestAssured.given();
		Response response=request.get();
		ResponseBody body=response.getBody();
		General21 g=body.as(General21.class);
		for(int i:g.id)
		{
			System.out.println(i);
		}
		//System.out.println(g.id);
		//System.out.println(g.email);
		//System.out.println(g.first_name);
		//System.out.println(g.last_name);
	}

}
