package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	public static ExtentReports report;
	public static ExtentTest test;

	public String testCaseName;
	public String testCaseDescription;
	public String author, category;

	public static void startReport() {
		// TODO Auto-generated method stu
		report = new ExtentReports("./Reports/newreport.html", true);
		test = report.startTest("W3schools");

	}
     

	public static void reportStep(String status, String description) throws IOException {

		if (status.equalsIgnoreCase("PASS")) {
			test.log(LogStatus.PASS, description);
		} else if (status.equalsIgnoreCase("Fail")) {
			test.log(LogStatus.FAIL, description);

		} else if (status.equalsIgnoreCase("SKIP")) {
			test.log(LogStatus.SKIP, description);

		} else if (status.equals("WARN")) {
			test.log(LogStatus.WARNING, description);

		}

	}

	public static String capture(WebDriver driver) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("./Screenshots/Errimage" + System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

	public void endTest() {
		report.endTest(test);

	}

	public void endReport() {
		report.flush();
	}
}
