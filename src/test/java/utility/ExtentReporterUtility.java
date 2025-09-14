package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.Header;

import java.util.List;

public class ExtentReporterUtility {
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void setupSparkReporter(String reportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//src//test//resources//test-reports//" + reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}

	public static void createExtentTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}

	public static void flushReport() {
		extentReports.flush();
	}

	public static void logJson(String json){
		extentTest.get().info(MarkupHelper.createCodeBlock(json , CodeLanguage.JSON));
	}
	public static void logHeaders(List<Header> headersList){
		String[][] arrayHeaders  = headersList.stream().map(header -> new String[] {header.getName() , header.getValue()})
				.toArray(String[][] :: new);
		//This toArray collects all those String[] arrays into a final String[][]—a 2D array of strings.

		/*
		* [
  			["Content-Type", "application/json"],
  			["Authorization", "Bearer xyz"],
  			["Accept", "application/json"]
		]*/

		extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
	}

}
