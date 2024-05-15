package com.qa.stepDefinition;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;
import org.testng.ITestResult;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class HttpReqRes {
	
	private Response response;
	ITestResult result;
	
	@Given("^I have a valid API endpoint$")
	public void i_have_a_valid_API_endpoint() throws Throwable {
		baseURI = "https://reqres.in";
//		System.out.println(baseURI);
		
		response = RestAssured.given().get();
	    int statusCode = response.getStatusCode();
	    Assert.assertEquals(statusCode, 200,"API endpoint availabel");
	    
	}

	@When("^I send a GET request$")
	public void i_send_a_GET_request() throws Throwable {
		response = RestAssured.given().get("https://reqres.in/api/users?page=2"); 
//		System.out.println(response.asPrettyString());
	}

	@Then("^I should receive a valid status code$")
	public void i_should_receive_a_valid_status_code() throws Throwable {
	    
	}

}
