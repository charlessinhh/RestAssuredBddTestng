package serialisationAndDeserialisation;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class DeserialisationJSONResponse {
	
	
	@Test
	public void createUser() {
		
		JSONObject postData = new JSONObject();
		postData.put("name", "charles");
		postData.put("job", "Leader");
		
		baseURI = "https://reqres.in";
		basePath = "/api/users";
		
		ResponseBody response = given()
		
									.contentType("application/json")
									.body(postData.toJSONString())
			
								.when()
		
									.post();
		
		response.prettyPrint();
		response.jsonPath().getInt("id");
		
		//deserialize the response body to class object -> JSONPostRequestResponse
		
		JSONPostRequestResponse responseClass = response.as(JSONPostRequestResponse.class);
		
		//assertion
		
//		(new SoftAssert()).assertEquals(responseClass.name, "charle", "check for name");
		
		Assert.assertEquals(responseClass.name, "charles", "check for name");
		Assert.assertEquals(responseClass.job, "Leader", "check for job");
		
		
		
		Response response1 = given()
				
				.contentType("application/json")
				.body(postData.toJSONString())

			.when()

				.post()
				
			.then()
				.extract()
				.response();
		
		String jsonResponse1 = response1.getBody().asPrettyString();
		// Print responses (for debugging purposes)
        System.out.println("Response from endpoint 1: " + jsonResponse1);
		
	}

}
