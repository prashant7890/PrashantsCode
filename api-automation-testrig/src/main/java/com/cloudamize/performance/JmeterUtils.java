package com.cloudamize.performance;

import com.cloudamize.commonUtilities.CommonFunctions;
import org.apache.jmeter.assertions.DurationAssertion;
import org.apache.jmeter.assertions.ResponseAssertion;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.config.gui.ArgumentsPanel;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.Header;
import org.apache.jmeter.protocol.http.control.HeaderManager;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.gui.HeaderPanel;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.reporters.Summariser;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.ListedHashTree;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * @author Santiago Villarreal
 */
public class JmeterUtils {

    private static final String slash = System.getProperty("file.separator");
    private static final StandardJMeterEngine jmeter = new StandardJMeterEngine();
    private static final File jmeterHome = new File(System.getProperty("jmeter.home", "apache-jmeter-5.1.1"));
    private static final File jmeterProperties = new File(jmeterHome.getPath() + slash + "bin" + slash + "jmeter.properties");
    private static final int LOOPS_NUMBER = 1;

    public static void createJmxFile(String accessToken, ArrayList<String> headers, String testName, HTTPSamplerProxy httpSamplerLoad, int threadCount) throws Exception {

        JMeterUtils.setJMeterHome(jmeterHome.getPath());
        JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
        JMeterUtils.initLocale();
        SaveService.loadProperties();

        // JMeter Test Plan
        ListedHashTree testPlanTree = new ListedHashTree();

        TestPlan testPlan = new TestPlan("API Performance Tests");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setUserDefinedVariables((Arguments) new ArgumentsPanel().createTestElement());
        testPlanTree.add(testPlan);

        HeaderManager headerManager = buildHeaders(accessToken,headers);

        // Build Test Plan from previously initialized elements
        testPlanTree.add(testPlan);
        ThreadGroup threadGroup = buildThreadGroupWithLoop(LOOPS_NUMBER, threadCount);
        HashTree threadGroupHashTree = testPlanTree.add(testPlan, threadGroup);

        HTTPSamplerProxy samplerProxy = httpSamplerLoad;
        threadGroupHashTree.add(samplerProxy, headerManager);

        //Generate the JMX
        SaveService.saveTree(testPlanTree, new FileOutputStream(
                System.getProperty("user.dir") + slash + "JmeterTestFiles" + slash + testName+".jmx"));

    }

    public static void runTest(String testName, String logFilePath) throws Exception {

        String testPath = System.getProperty("user.dir") + slash + "JmeterTestFiles" + slash + testName+".jmx";
        JMeterUtils.setJMeterHome(jmeterHome.getPath());
        JMeterUtils.loadJMeterProperties(jmeterProperties.getPath());
        JMeterUtils.initLocale();
        SaveService.loadProperties();
        HashTree testPlanTree = SaveService.loadTree(new File(testPath));

        Summariser summer = null;
        String summariserName = JMeterUtils.getPropDefault("summariser.name", "summary");
        if (summariserName.length() > 0) {
            summer = new Summariser(summariserName);
        }
        ResultCollector logger = new ResultCollector(summer);
        logger.setFilename(logFilePath);
        testPlanTree.add(testPlanTree.getArray()[0], logger);
        jmeter.configure(testPlanTree);
        jmeter.run();


    }

    public static HeaderManager buildHeaders(String accessToken,ArrayList<String> headers) {
        String hash = accessToken;
        String authorization = "Bearer " + hash;
        HeaderManager manager = new HeaderManager();
        manager.add(new Header("Authorization", authorization));
        manager.add(new Header("Accept", "application/json, text/plain"));
        manager.add(new Header("Content-Type", "application/json; charset=utf-8"));
        manager.add(new Header("Sec-Fetch-Mode", "cors"));

        for(int i=0;i<headers.size();i++){
            String[] headerValues = headers.get(i).split("/");
            manager.add(new Header(headerValues[0], headerValues[1]));
        }
        manager.setName("HTTP Header Manager");
        manager.setEnabled(true);
        manager.setProperty(TestElement.TEST_CLASS, HeaderManager.class.getName());
        manager.setProperty(TestElement.GUI_CLASS, HeaderPanel.class.getName());
        return manager;
    }

    public static ThreadGroup buildThreadGroupWithLoop(int loops, int threads) {
        // Loop Controller
        LoopController loopController = new LoopController();
        loopController.setLoops(loops);
        loopController.setFirst(true);
        loopController.setName("Loop controller");
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.initialize();

        // Thread Group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Thread Group");
        threadGroup.setNumThreads(threads);
        threadGroup.setRampUp(1);
        threadGroup.setSamplerController(loopController);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
        return threadGroup;
    }

    public static HTTPSamplerProxy httpSamplerLoad(String domain, String path, String method, String testName) {
        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();
        httpSampler.setDomain(domain);//cmp-qa.cloudamize.com
        httpSampler.setPort(80);
        httpSampler.setPath(path);//manage/v1/performance/filters/metrics/resourceid/i-8ab025b8
        httpSampler.setMethod(method);
        httpSampler.setName(testName);
        httpSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        httpSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
        return httpSampler;
    }

}