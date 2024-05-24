package com.qa.rest.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import org.json.simple.*;
import java.util.HashMap;

public class GetAndPost {
	
	static int id; // to store the id of the user created
	
	@Test(priority = 0)
	public void listUsers() {
		
		RestAssured.baseURI = "https://reqres.in";
//		baseURI = "https://reqres.in";
		
		given()
		
		.when()
			.get("/api/users?page=2")
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.assertThat()
            .contentType("application/json; charset=utf-8")
			.body("data[2].first_name", equalTo("Tobias"))
			.body("data.first_name", hasItems("George","Tobias","Rachel"));
//			.log().all();
		
		
	}
	
//	@Test
	public void listSingleUser() {
		
		baseURI = "https://reqres.in";
		
		given()
		
		.when()
			.get("/api/users/"+id)
			
		.then()
//			.statusCode(200)
			.assertThat()
            .contentType("application/json; charset=utf-8")
			.log().all();

	}
	
	
	
	@Test(priority = 1)
	public void createUser() {
		
//		HashMap data = new HashMap<>();
//		data.put("name", "charles");
//		data.put("job", "Leader");
//		System.out.println(data);
//		
//		JSONObject req = new JSONObject(data);
//		System.out.println(req);
		
		JSONObject postData = new JSONObject();
		postData.put("name", "charles");
		postData.put("job", "Leader");
		System.out.println(postData.toJSONString());
		
		baseURI = "https://reqres.in"; 
		
		id = 
		given()
			.contentType("application/json")
			.body(postData.toJSONString())
			
		.when()
		.post("/api/users")
		
//		.then()
//			.statusCode(201)
//			.body("name", equalTo("charles"))
//			.log().all();
		
		//take out the id of the user created
		.jsonPath().getInt("id");
		
			
	}
	
	@Test(priority = 2 , dependsOnMethods= {"createUser"})
	public void patchUser() {
		
		JSONObject postData = new JSONObject();
		postData.put("name", "charles singh");
		System.out.println("id1 :"+id);
		baseURI = "https://reqres.in";
		
		given()
			.contentType("application/json")
			.body(postData)
		
		.when()
		.patch("/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test(priority = 3)
	public void deleteUser() {
		baseURI = "https://reqres.in";
		
		given()
		
		.when()
			.delete("/users/"+id)
		
		.then()
			;
		System.out.println("User Deleted by ID: "+id);
	}

}
