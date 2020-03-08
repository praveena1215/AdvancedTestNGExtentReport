package wrappers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import utils.ExtentReport;

public class GenericWrapper extends ExtentReport implements WrappersTestNG {

	public RemoteWebDriver driver;

	public void invokeBrowser(String browser, String url) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);

	}

	public void clickByXpath(String xpath) {
		// TODO Auto-generated method stub

		try {
			driver.findElementByXPath(xpath).click();
			// System.out.println("Element was found and click done sucessfully"
			// +xpath);
			reportStep("PASS", "Element was found and actioned");

		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			// System.err.println("Element not interactable " +xpath);
			try {
				reportStep("FAIL", "Error captured");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			// System.err.println("Element is not selectable :" + xpath);
			try {
				reportStep("Fail", "Error captured");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
		} catch (WebDriverException e) {
			// TODO: handle exception
			// System.err.println("Browser closed due to unknown error");
			try {
				reportStep("FAIL", "Error captured");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				capture(driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void enterByXpath(String data, String xpath) {
		// TODO Auto-generated method stub

		try {
			driver.findElementByXPath(xpath).sendKeys(data);
			// System.out.println("Text entered sucusefully " +data);
			try {
				reportStep("Pass", "No Error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			// System.err.println("Element is not interactable " +xpath);
			try {
				reportStep("Fail", "Element is not interacable");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
		} catch (ElementNotSelectableException e) {
			// TODO: handle exception
			// System.err.println("Element is not selectable" +xpath);
			try {
				reportStep("Fail", "Element is not selectable");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}
		} catch (WebDriverException e) {
			// System.err.println("Browser closed due to unknown error");
			// TODO: handle exception
			try {
				reportStep("Fail", "Browser closed due to un known error");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
			}

		} finally {
			try {
				capture(driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	public void selectByXpath(String value) {
		// TODO Auto-generated method stub
		WebElement dropdown = driver.findElement(By.xpath("value"));
		Select options = new Select(dropdown);
		options.selectByValue(value);
		System.out.println("Value selected iin drop doen correctly :" + value);

	}

	public void getText(String text) {
		// TODO Auto-generated method stub

	}

	public void verifyText(String text) {
		// TODO Auto-generated method stub

	}

	public void switchWindows() {
		// TODO Auto-generated method stub

	}

	public void implicitWait() {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void explicitWait(String xpath) {
		// TODO Auto-generated method stub

	}

}
