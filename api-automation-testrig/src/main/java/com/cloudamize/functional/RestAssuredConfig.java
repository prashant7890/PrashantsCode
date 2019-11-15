package com.cloudamize.functional;

import com.cloudamize.commonUtilities.CommonFunctions;
import com.cloudamize.commonUtilities.TokenEncryptor;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RestAssuredConfig {

	static String header;

	public RequestSpecification getRequestSpecification() {
		RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON);
		return (RequestSpecification) requestSpecification.log().all();
	}

	public static RequestSpecification getRequestSpecification(String user) {
		header = "Bearer " + CommonFunctions.getHeader(user);
		RequestSpecification requestSpecification = RestAssured.given().contentType(ContentType.JSON)
				.header("Authorization", header);
		return (RequestSpecification) requestSpecification.log().all();
	}

	public static Response getResponse(RequestSpecification requestSpecification, Method method, String endpoint,
			int responseCode) {
		Response response = requestSpecification.request(method, endpoint);
		Assert.assertEquals(response.getStatusCode(), responseCode, "Status code");
		System.out.println(response.asString());
		return (Response) response;
	}

}
