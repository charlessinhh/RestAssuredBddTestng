package com.qa.rest.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidate {
	
	@Test
	public void validateSchema() {
		RestAssured.baseURI = "https://reqres.in";
		
		given()
		
		.when()
			.get("/api/users?page=2")
			
		.then()
			.statusCode(200)
			.assertThat()
            .contentType("application/json; charset=utf-8")
            .body(matchesJsonSchemaInClasspath("schema.json"))
			;
	}

}
