package testcase.w3schools;

import org.testng.annotations.Test;

import wrappers.ProjectWrapper;

public class Testcase extends ProjectWrapper {

	// public RemoteWebDriver driver;
	@Test
	public void testCaseForW3SChools() throws InterruptedException {
		//implicitWait();
		// invokeBrowser("chrome", "https://www.w3schools.com");
		clickByXpath("//*[@id='mySidenav']/div/a[1]");

		clickByXpath("//a[@title='Search W3Schools']");

		enterByXpath("do usefull", "//input[@id='gsc-i-id1']");

	}

}
