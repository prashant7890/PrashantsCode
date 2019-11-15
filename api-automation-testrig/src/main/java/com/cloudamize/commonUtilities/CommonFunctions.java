package com.cloudamize.commonUtilities;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;

public class CommonFunctions {

	private static String slash = System.getProperty("file.separator");

	public static Timestamp getCurrentTimeStamp() {

		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		return ts;
	}

	public static String getProperty(String key) {
		String value = null;
		try {
			InputStream input = new FileInputStream(System.getProperty("user.dir") + slash + "Common.properties");
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return value;
	}

	public static Properties getProperties(String filePath) {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream(filePath);

			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	public static void recursiveDelete(File file) {
		if (!file.exists())
			return;
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				recursiveDelete(f);
			}
		}
		file.delete();
	}

	public static String getHeader(String user) {
		String Password = TokenEncryptor.getPasswordForOauth();
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Basic bWFuYWdlOnNlY3JldA==")
				.header("Content-Type", "application/x-www-form-urlencoded").formParam("grant_type", "password")
				.formParam("username", user).formParam("password", Password);
		request.log().all();
		Response response = request.post("http://cmp-qa.cloudamize.com/auth/oauth/token");
		String responseBody = response.asString();
		System.out.println(responseBody);
		JsonPath abc = response.jsonPath();
		String header = abc.get("access_token");
		return header;
	}

	public static void WritePropertiesFile(String filePath, String key, String data) {
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();

			File file = new File(filePath);
			fileIn = new FileInputStream(file);
			configProperty.load(fileIn);
			configProperty.setProperty(key, data);
			fileOut = new FileOutputStream(file);
			configProperty.store(fileOut, "sample properties");

		} catch (Exception ex) {
			System.out.println("Exception found : "+ex);
		} finally {

			try {
				fileOut.close();
			} catch (IOException ex) {
				System.out.println("Exception found : "+ex);
			}
		}
	}

}
