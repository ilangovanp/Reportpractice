package extreport;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bootcamp.framework.utils.ExtentReporter;

public class ExtentReporterTest {
	
	private String suiteName;
	
	@BeforeSuite
	public void beforeSutie() {
		ExtentReporter.createExtentSparkReport("./report/index.html");
	}
	
	@BeforeTest
	public void beforeTest() {
		suiteName = "TC001_Validate_Creation_Of_Account";
	}
	
	@BeforeClass
	public void beforeClass() {
		ExtentReporter.createTestSuites(suiteName);
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentReporter.createTestCase(method.getName());
	}
	
	@Test
	public void testReportSteps1() {
		ExtentReporter.reportStep("Pass", "This is a logging event for ExtentReporterTest 1, and it passed!");
		ExtentReporter.reportStep("Pass", "This is a logging event for ExtentReporterTest 2, and it passed!");
		ExtentReporter.reportStep("Fail", "This is a logging event for ExtentReporterTest 3, and it failed!");
	}
	
	@Test
	public void testReportSteps2() {
		ExtentReporter.reportStep("Pass", "This is a logging event for ExtentReporterTest 1, and it passed!");
		ExtentReporter.reportStep("Pass", "This is a logging event for ExtentReporterTest 2, and it passed!");
		//ExtentReporter.reportStep("Fail", "This is a logging event for ExtentReporterTest 3, and it failed!");
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentReporter.flushExtentSparkReport();
	}

}