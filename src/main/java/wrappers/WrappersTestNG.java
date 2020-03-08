package wrappers;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WrappersTestNG {
	
	public void invokeBrowser(String browser, String url);
	
	public void clickByXpath(String xpath) throws IOException;
	
	public void enterByXpath(String data, String xpath) throws IOException;
	
	public void selectByXpath(String value);
	
	public void getText(String text);
	
	public void verifyText(String text);
	
	public void switchWindows();
	
	public void implicitWait();
	
	public void explicitWait(String xpath);
	
	
	
	

}
