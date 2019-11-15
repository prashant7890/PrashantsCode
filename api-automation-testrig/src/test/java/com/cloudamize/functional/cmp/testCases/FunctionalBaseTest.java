package com.cloudamize.functional.cmp.testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;

public class FunctionalBaseTest {

	private static final Logger LOG = LoggerFactory.getLogger(FunctionalBaseTest.class);

	String buildNumber = System.getenv().get("BUILD_NUMBER");
	String baseUri = System.getenv().get("API_SERVER_URL");
	String cookedDbName = System.getenv().get("COOKED_DB_NAME");
	String masterDbName = System.getenv().get("MASTER_DB_NAME");
	String cookedDbIp = System.getenv().get("COOKED_DB_IP");
	String masterDbIp = System.getenv().get("DEV_MASTER_DB_IP");
	String dbPort = System.getenv().get("POSTGRESQL_PORT");
	String resource_id = System.getenv().get("RESOURCE_ID");
	String dbUser = System.getenv().get("PGSQL_USERNAME");
	String dbPassword = System.getenv().get("PGSQL_PASSWORD");
	String userName = System.getenv().get("TEST_USER_NAME");

	public FunctionalBaseTest() {

	}

	@BeforeSuite
	public void beforeSuit() {

		LOG.info("Execution Started");
		System.out.println("********************Execution started********************");
	}

	@AfterSuite
	public void afterSuit() {
		LOG.info("Execution Completed");
		System.out.println("********************Execution completed********************");
	}
}
