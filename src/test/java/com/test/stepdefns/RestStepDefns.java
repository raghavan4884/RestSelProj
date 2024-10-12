package com.test.stepdefns;

import com.test.rest.RestMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.internal.common.assertion.Assertion;
import junit.framework.Assert;


public class RestStepDefns extends RestMethods{
	
RestMethods rm=new RestMethods();


@Given("that the users are displayed in the {string} {int}")
public void that_the_users_are_displayed_in_the(String string, Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	String s=int1.toString();
	rm.putResponseForBearerToken("https://reqres.in/api/users",string,s);
	
	
	
	
}


@Given("that the Products are displayed with {string} {int}")
public void that_the_products_are_displayed_with(String string, Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	String s=int1.toString();
	rm.getRequestForPathParam("https://reqres.in/api/products/",string,int1);
}



}
