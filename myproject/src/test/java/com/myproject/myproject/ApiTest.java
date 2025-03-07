package com.myproject.myproject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {

	    // Base URL for Reqres API
	    private static final String BASE_URL = "https://reqres.in/api";

	    @Test
	    public void testLoginSuccess() {
	        // Define the endpoint for the POST request (Login)
	        String endpoint = "/login";

	        // JSON body for the POST request (Login credentials)
	        String requestBody = "{\n" +
	                "  \"email\": \"eve.holt@reqres.in\",\n" +
	                "  \"password\": \"pistol\"\n" +
	                "}";

	        // Send the POST request to login and get the response
	        Response response = RestAssured.given()
	                .header("Content-Type", "application/json")
	                .body(requestBody)
	                .post(BASE_URL + endpoint);

	        // Print the response body to the console
	        System.out.println("Response Body: " + response.getBody().asString());

	        // Validate the status code
	        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");

	        // Validate the presence of a token in the response
	        String token = response.jsonPath().getString("token");
	        Assert.assertNotNull(token, "Token is null in the response");

	        // Optionally, validate the token format (you can add a more strict validation based on the token format)
	        Assert.assertTrue(token.length() > 0, "Token is empty");
	    }
	}