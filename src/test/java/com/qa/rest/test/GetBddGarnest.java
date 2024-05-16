package com.qa.rest.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBddGarnest {
	
	@Test
	public void testGet1()
	{
		
		Response response = RestAssured.get("http://ergast.com/api/f1/2023/1");
//		System.out.println("response: "+ response.toString());
		System.out.println("responseTime: "+ response.getTime());
		System.out.println("response1: "+ response.asPrettyString());
		System.out.println("StatusCode : "+ response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200,"200");
		

	}
	
	@Test
	public void testGet2() {
		baseURI = "http://ergast.com/api";
		System.out.println("TestGet 2");
		given().get("/f1/2023/1").then().statusCode(200);
	}
	
}
