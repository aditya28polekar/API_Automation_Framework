package api.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utility.ExtentReporterUtility;
import utility.LoggerUtlity;

import java.util.Arrays;

public class TestListener implements ITestListener {
	Logger logger;

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger = LoggerUtlity.getLogger(result.getTestClass().getRealClass());
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger = LoggerUtlity.getLogger(result.getTestClass().getRealClass());
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger = LoggerUtlity.getLogger(result.getTestClass().getRealClass());
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		logger = LoggerUtlity.getLogger(result.getTestClass().getRealClass());
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");

	}

	public void onStart(ITestContext context) {
		logger = LoggerUtlity.getLogger(this.getClass());
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger = LoggerUtlity.getLogger(this.getClass());
		logger.info("Test Suite Completed");
		ExtentReporterUtility.flushReport();
	}
}
