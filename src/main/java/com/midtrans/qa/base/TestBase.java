package com.midtrans.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.midtrans.qa.util.TestUtil;
import com.midtrans.qa.util.WebEventListener;

public class TestBase {

	public static enum Mode {

		NUMERIC("1234567890"),
		SYMBOLIC("'-=[];,./~!@#$%^&*()_+{}:\" <>?"),
		SPECIAL(SYMBOLIC.getStringValue() + "\\"),

		/* LATIN */
		ALPHA("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
		ALPHANUMERIC(ALPHA.getStringValue() + NUMERIC.getStringValue()),
		ALPHANUMERICSPECIALCHAR(ALPHANUMERIC.getStringValue() + SPECIAL.getStringValue()),
		ALPHACAPITAL("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
		ALPHANUMERICSYMBOLIC(ALPHANUMERIC.getStringValue() + SYMBOLIC.getStringValue());

		private final String stringValue;

		Mode(String s) {
			stringValue = s;
		}

		public String getStringValue() {
			return stringValue;
		}
	}
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/midtrans"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome") || browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/resources/chromedriver");
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF") || browserName.equals("firefox") || browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/resources/geckodriver");
			driver = new FirefoxDriver(); 
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	public boolean isFound(WebElement element) {
		Long timeOut = TestUtil.IMPLICIT_WAIT;
		try {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
				if (element.isDisplayed()) {
					driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
					return true;
				} else {
					return false;
				}
			}catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
			return false;
		}
	}

	/**
	 * This method generates random character depending on modes(Alphabetic,Alphanumeric,numeric) and length
	 * @param length the length of string
	 * @param mode   different types of mode
	 * @return String of characters
	 * @throws Exception
	 */
	public static String generateRandomString(int length, Mode mode) throws Exception {

		StringBuffer buffer = new StringBuffer();
		String characters = mode.getStringValue();
		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

	public void sendText(WebElement element,String text){
		element.click();
		element.clear();
		element.sendKeys(text);
	}
}
