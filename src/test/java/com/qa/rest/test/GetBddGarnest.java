package com.qa.rest.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetBddGarnest {
	
	@Test
	public void test()
	{
		
//		int a = 1;
//		int b = 2;
//		if(a!=b)System.out.println("yes");
//		System.out.println("good");
		
		given().
		when().
			get("http://ergast.com/api/f1/2023/1").
		then().
		assertThat().
		statusCode(200).
		and().
		header("Content-length",equalTo("1157"));
		

	}
}
