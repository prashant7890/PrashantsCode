package com.cloudamize.performance.cmp.testcases;

import com.cloudamize.performance.JmeterUtils;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class PerformanceController extends PerformanceBaseTest {

    @Test
    public void performanceMetrics() throws Exception {

        String testName = "Performance Controller Test";
        ArrayList<String> headerValues = new ArrayList<>();
        headerValues.add("customer-key/" + customerKey);
        String path = "performance/filters/metrics/resourceid/" + resourceId;
        HTTPSamplerProxy httpSamplerLoad = JmeterUtils.httpSamplerLoad(domain, path, "GET", testName);
        JmeterUtils.createJmxFile(accessToken, headerValues, testName, httpSamplerLoad, threadCount);
        JmeterUtils.runTest(testName, logFilePath);

    }
}