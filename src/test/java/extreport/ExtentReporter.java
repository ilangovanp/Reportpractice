package extreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;
	private static ExtentTest testSuite;
	private static ExtentTest testCase;
	
	public static void createExtentSparkReport(String filePath) {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(filePath);
		extent.attachReporter(spark);
	}
	
	public static void createTestSuites(String testsuiteName) {
		testSuite = extent.createTest(testsuiteName);
	}
	
	public static void createTestCase(String testcaseName) {
		testCase = testSuite.createNode(testcaseName);				
	}
	
	public static void reportStep(String status, String description) {
		switch (status.toUpperCase()) {
		case "PASS":
			testCase.log(Status.PASS, description);
			break;
		case "FAIL":
			testCase.log(Status.FAIL, description);
			throw new RuntimeException("FAILED: Due to -> "+description);
		case "WARNING":
			testCase.log(Status.WARNING, description);
			break;
		case "INFO":
			testCase.log(Status.INFO, description);
			break;
		case "SKIP":
			testCase.log(Status.SKIP, description);
			break;
		default:
			throw new RuntimeException("Error: Given status was not supported by ExtentReprots plugin");
		}
	}
	
	public static void flushExtentSparkReport() {
		extent.flush();
	}

}