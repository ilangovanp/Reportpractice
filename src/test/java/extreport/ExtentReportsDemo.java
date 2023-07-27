package extreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class ExtentReportsDemo {

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/index.html");
		extent.attachReporter(spark);
		ExtentTest testsuite = extent.createTest("ExtentReportsDemoTestSuite");
		ExtentTest testcase = testsuite.createNode("ExtentReportsDemoTestCase");
		testcase.log(Status.PASS, "Test step pass");
		testcase.log(Status.FAIL, "Test step fail");
		testcase.log(Status.WARNING, "Test step warning");
		testcase.log(Status.INFO, "Test step info");
		testcase.log(Status.SKIP, "Test step skip");
		extent.flush();
	}

}
