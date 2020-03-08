package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrapper extends GenericWrapper {

	@BeforeSuite
	public void beforeSuit() {
		startReport();

	}

	@BeforeTest
	public void beforeTest() {
		// reserved

	}

	@BeforeMethod
	public void startBrowser() {
		// startTest("testname", "testdescription");
		invokeBrowser("chrome", "https://www.w3schools.com");
	}

	@AfterMethod
	public void closeBrowsers() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
		// reserved
	}

	@AfterTest
	public void afterTest() {
		endTest();
		endReport();
	}

}
