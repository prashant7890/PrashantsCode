package com.cloudamize.functional.cmp.testCases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cloudamize.commonUtilities.Endpoints;
import com.cloudamize.functional.RestAssuredConfig;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResourceController extends FunctionalBaseTest {

	SoftAssert softAssert = new SoftAssert();

	@DataProvider(name = "data", parallel = true)
	public Iterator<Object[]> data2() {
		Collection<Object[]> testData = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {
			testData.add(new Object[] { String.valueOf(i + 1) });
		}
		return testData.iterator();
	}

	@Test(groups = { "ResourceController" })
	public void instances() throws ParseException {
		RestAssured.baseURI = baseUri;
		RequestSpecification requestSpecification = RestAssuredConfig.getRequestSpecification(userName);
		requestSpecification.header("Accept", "application/json, text/plain")
				.header("Content-Type:", "application/json; charset=utf-8").header("Sec-Fetch-Mode", "cors");
		Response response = RestAssuredConfig.getResponse(requestSpecification, Method.GET,
				Endpoints.resourceController_instances, 200);
		System.out.println("Response code " + response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200, "Status code");

	}

}
