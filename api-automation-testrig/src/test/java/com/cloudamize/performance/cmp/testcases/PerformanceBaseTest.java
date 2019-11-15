package com.cloudamize.performance.cmp.testcases;

import static org.apache.jmeter.JMeter.JMETER_REPORT_OUTPUT_DIR_PROPERTY;

import java.io.File;

import com.cloudamize.commonUtilities.CommonFunctions;
import org.apache.jmeter.report.dashboard.ReportGenerator;
import org.apache.jmeter.util.JMeterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class PerformanceBaseTest {

    private static final Logger LOG = LoggerFactory.getLogger(PerformanceBaseTest.class);

    static final File jmeterHome = new File(System.getProperty("jmeter.home", "apache-jmeter-5.1.1"));
    static final String slash = System.getProperty("file.separator");
    static final String logFilePath = jmeterHome + slash + "ApiPerformanceTestSuit.jtl";
    static final File logFile = new File(jmeterHome + slash + "ApiPerformanceTestSuit.jtl");
    static final File reportFile = new File(System.getProperty("user.dir") + slash + "Reports" +slash +
            "PerformanceTestReports");

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

//	String customerKey = System.getenv().get("CUSTOMER_KEY");
//	String resourceId = System.getenv().get("RESOURCE_ID");
//	String domain = System.getenv().get("DOMAIN");
//	private String threadCountFromJenkins = System.getenv().get("THREAD_COUNT");
//	private String userName = System.getenv().get("TEST_USER_NAME");

    String customerKey = "QVdTLU1BTkdFLUNPT0tFRC1EQi0y";
    String resourceId = "i-034f75974183a15de";
    String domain = "cmp-qa.cloudamize.com/manage/v1";
    private String threadCountFromJenkins = "2";
    private String userName = "deepak@cloudamize.com";

    int threadCount;

    String accessToken;

    public PerformanceBaseTest() {

    }

    @BeforeSuite
    public void beforeSuit() throws Exception {

        LOG.info("Execution Started");
        System.out.println("********************Execution started********************");

        System.out.println("thread count is : " + threadCountFromJenkins);
        System.out.println("username is : " + userName);
        System.out.println("domain is : " + domain);
        threadCount = Integer.parseInt(threadCountFromJenkins);
        if (logFile.exists()) {
            boolean delete = logFile.delete();
            System.out.println("Jtl deleted: " + delete);
        }
        accessToken = CommonFunctions.getHeader(userName);

    }

    @AfterSuite
    public void afterSuit() throws Exception {
        System.out.println("generating report");
        CommonFunctions.recursiveDelete(reportFile);
        String reportFilePath;
        reportFilePath = System.getProperty("user.dir") + slash + "Reports"+ slash + "PerformanceTestReports";
        JMeterUtils.setProperty(JMETER_REPORT_OUTPUT_DIR_PROPERTY, reportFilePath);
        ReportGenerator generator = new ReportGenerator(logFilePath, null);
        generator.generate();
        System.out.println("report path :" + reportFilePath);
        System.out.println("********************Execution completed********************");
        LOG.info("Execution Completed");

    }

}
