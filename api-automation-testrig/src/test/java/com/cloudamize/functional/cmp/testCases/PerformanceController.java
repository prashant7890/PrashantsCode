package com.cloudamize.functional.cmp.testCases;

import com.cloudamize.commonUtilities.CommonFunctions;
import com.cloudamize.commonUtilities.DbConnectionUtils;
import com.cloudamize.commonUtilities.Endpoints;
import com.cloudamize.functional.RestAssuredConfig;
import com.cloudamize.functional.cmp.bean.PerformanceControllerBean;
import com.cloudamize.functional.cmp.entity.PerformanceMetricsEntity;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class PerformanceController extends FunctionalBaseTest {

	SoftAssert softAssert = new SoftAssert();

	@DataProvider(name = "data", parallel = true)
	public Iterator<Object[]> data2() {
		Collection<Object[]> testData = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {
			testData.add(new Object[] { String.valueOf(i + 1) });
		}
		return testData.iterator();
	}

	@Test(groups = { "PerformanceController" })
	public void performanceMetrics() throws SQLException {

		Connection con = null;
		try {
			RestAssured.baseURI = baseUri;
			RequestSpecification requestSpecification = RestAssuredConfig.getRequestSpecification(userName);
			requestSpecification.header("Accept", "application/json, text/plain")
					.header("customer-key", System.getProperty("CUSTOMER_KEY"))
					.header("Content-Type:", "application/json; charset=utf-8").header("Sec-Fetch-Mode", "cors")
					.pathParam("resourceid", resource_id);
			Response response = RestAssuredConfig.getResponse(requestSpecification, Method.GET,
					Endpoints.performanceMetrics, 200);
			System.out.println("Response code " + response.getStatusCode());
			PerformanceControllerBean responseData = response.as(PerformanceControllerBean.class,
					ObjectMapperType.GSON);
			ArrayList<PerformanceControllerBean> responseDataList = new ArrayList<>();
			responseDataList.add(responseData);
			DbConnectionUtils dbConnectionUtils = new DbConnectionUtils();
			con = dbConnectionUtils.getDbConnection(cookedDbIp, cookedDbName, dbPort, dbUser, dbPassword);
			String query = CommonFunctions.getProperty("query1");
			ResultSet result = con.createStatement().executeQuery(query);

			ArrayList<PerformanceMetricsEntity> dbResultSet = new ArrayList<>();
			while (result.next()) {
				String a = result.getString("metric_full_name");
				String b = result.getString("metric_display_name");
				PerformanceMetricsEntity performanceMetricsEntity = new PerformanceMetricsEntity(a, b);
				dbResultSet.add(performanceMetricsEntity);
			}

			HashMap<String, String> hm = new HashMap<String, String>();

			for (int j = 0; j < dbResultSet.size(); j++) {
				hm.put(dbResultSet.get(j).getMetric_full_name(), dbResultSet.get(j).getMetric_display_name());
			}

			softAssert.assertEquals(responseDataList.get(0).getAverageAwsMetricCpuUtilization(),
					hm.get("average.aws_metric_cpu_utilization"), "average.aws_metric_cpu_utilization");
			softAssert.assertEquals(responseDataList.get(0).getAverageAwsMetricDiskWriteBytes(),
					hm.get("average.aws_metric_disk_write_bytes"), "average.aws_metric_disk_write_bytes");
			softAssert.assertEquals(responseDataList.get(0).getAverageAwsMetricDiskReadOps(),
					hm.get("average.aws_metric_disk_read_ops"), "average.aws_metric_disk_read_ops");
			softAssert.assertEquals(responseDataList.get(0).getAverageAwsMetricDiskReadBytes(),
					hm.get("average.aws_metric_disk_read_bytes"), "average.aws_metric_disk_read_bytes");

		} catch (Exception e) {
			Assert.assertTrue(false, "Exception occurred : " + e);
		} finally {
			if (con != null)
				con.close();
		}
	}

}
