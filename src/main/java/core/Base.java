package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Base {
	
	// in this class we difine property of the below classes and will use them to child classes
	// WebDriver
	//Logger
	//properties class
	
	
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	private String projectPropertyFilePath = ".\\src\\test\\resources\\InputData\\projectProp.properties";
	private String log4jFilePath = ".\\src\\test\\resources\\InputData\\log4j.properties";
	
	public Base() {
	
		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader (projectPropertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger = logger.getLogger("logger File");
		PropertyConfigurator.configure(log4jFilePath);
	}
	/**
	 * this method will return value of browser name 
	 * such as chrome, Firefox, IE, and Headless browser
	 * @return
	 */
	
	public static String getBrowserName() {
		String browserName = properties.getProperty("browser");
		return browserName;
	}
	
	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}
	/**
	 * this method will return implicit wait time and parse it to long data type as 
	 * implicilty wait method in selenium accepts long datatype.
	 * @return
	 */
	public static Long getImpWait() {
		String imptWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(imptWait);
	}
	
	/**
	 * this method will return pageLoadTimeOut wait and parse it to long data type as 
	 * pageLoadTimeOut wait method in selenium accepts long datatype.
	 * @return
	 */
	public static Long getPagetLoadTimeOut() {
		String pageLoadTimeOut = properties.getProperty("pageLoadTimeOut");
		return Long.parseLong(pageLoadTimeOut); 
	}
	
	/**
	 * this method will initialize the weddriver whenver we call it
	 */
	public static void initializeDriver() {
		driver.get(getURL());
	}
	
	/**
	 * this method will close and quit all windows after each execution.
	 */
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
