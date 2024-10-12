package com.test.rest;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;

import com.test.utilities.JSONUtil;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RestMethods {

	
	public Response getRequestForBasicAuth(String uri,String user,String password,String queryParamName,String queryParamValue)
	{
		RestAssured.baseURI=uri;
		
		RequestSpecification request=RestAssured.given().auth().basic(user, password).queryParam(queryParamName, queryParamValue);
		Response response=request.when().get();
		return response;
		
	}
	public Response postRequestForFormAuth(String uri,String user,String password,String jsonKey,String jsonValue)
	{
		JSONUtil ju=new JSONUtil();		
		RestAssured.baseURI=uri;
		RequestSpecification request=RestAssured.given().auth().form(user, password).body(ju.putJsonString(jsonKey, jsonValue));
		Response response=request.when().post();
		ResponseBody body=response.getBody();

		return response;
		
	}
	public Response getRequestForPathParam(String uri,String pathParamKey,int pathParamValue)
	{
		RestAssured.baseURI=uri;
		String base=pathParamKey;
		RequestSpecification request=RestAssured.given().basePath("{"+base+"}").pathParam(pathParamKey, pathParamValue);
		Response response=request.when().get();
		ResponseBody body=response.getBody();
		
		//response.then().assertThat().time(Matchers.lessThan(200L));
		//response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("1.json"));
		response.prettyPrint();
		System.out.println(response.getStatusLine());
		response.then().assertThat().statusLine(Matchers.equalTo("HTTP/1.1 200 OK"));
		
		//System.out.println(response.asPrettyString());
		return response;
		
	}
	public Response putResponseForBearerToken(String uri,String token,String jsonKey,String jsonValue)
	{
		JSONUtil ju=new JSONUtil();
		RestAssured.baseURI=uri;
		
		RequestSpecification request=RestAssured.given().header("authorization","bearer +'"+token+"'+").body(ju.putJsonString(jsonKey, jsonValue));
		
		Response response=request.when().put();
		return response;
	}
	public Response putResponseForBearerToken(String uri,String queryStringKey,String queryStringValue)
	{
		
		RestAssured.baseURI=uri;
		RequestSpecification request=RestAssured.given().queryParam(queryStringKey, queryStringValue);
		Response response=request.when().get();
		System.out.println(response.asPrettyString());
		return response;
	}
	public void getResponseCode(Response response)
	{
		response.getStatusCode();
	}
	public void getResponseValue(Response response)
	{
		response.getStatusLine();
	}
	public void getResponseTime(Response response)
	{
		
		response.getTime();
	}
	public String getJsonValue(Response response,String jsonPath)
	{
		JsonPath jp=response.jsonPath();
		//jsonPath="data.id(0)";
		//jsonPath="$id(0)";
		return jp.getString(jsonPath);
		
	}
	public void getHeaderValue(Response response,String headerName)
	{
		response.getHeader(headerName);
	}
	public Map<String,String> getHeaderValues(Response response)
	{
		Map<String,String> hm=new HashMap<String,String>();
		Headers headers=response.getHeaders();
		for(Header header:headers)
		{
			hm.put(header.getName(), header.getValue());
		}
		return hm;
				
	}
	public void verifyJsonSchema(Response response,String fileName)
	{
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(fileName));
	}
	public void verifyResponseCode(Response response,int responseCode)
	{
		response.then().assertThat().statusCode(responseCode);
	}
	public void verifyResponseMessage(Response response,String statusMessage)
	{
	
		response.then().assertThat().statusLine(statusMessage);
	}

	public void verifyJsonValues(Response response,String jsonPath,String value)
	{
		response.then().assertThat().body(jsonPath,Matchers.equalTo(value));
	}
	public void verifyReponseHeader(Response response,String headerName,String value)
	{
		String s=response.getBody().asPrettyString();
		//response.then().assertThat().bidy("name.id[0]",Matchers.equalTo(1));
		
//		response.then().assertThat().body("name.id",Matchers.hasItems(1,2,3));
		
		
		response.then().assertThat().header(headerName,value);
		
		
	}
	
}
