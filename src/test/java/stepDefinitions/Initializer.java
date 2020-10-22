package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.media.jfxmedia.logging.Logger;

import core.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer extends Base{
	
	//cucumber provides hooks and we have two hooks
	// Before Hooks and After Hooks
	// Before Hooks u ses @Before tag and will run block of code before each scenario
	// in Before Hooks we Usually define block of codes to initialize browser
	//manage webdriver
	//log scenario name
	// after Hooks Uses @after tag and will run block of code after each scenario 
	// in After hooks we usually defiene block of codes to get scenario statues 
	// and tear down or close brower
	
	@Before
	public void beforeHooks(Scenario scenario) {
		
		// before each scenario we can print or log the name of scenario we will execute 
		logger.info("Scenario " + scenario.getName() + "Started");
		//we write a swich statement to create obeject of browsers (Chrome, IE, FireFox)
		// we use WebdriverManager to replace System.setproperty (driver and executable file)
		String browser = getBrowserName();
		switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver= new FirefoxDriver();
			break;
			default:
				WebDriverManager.chromedriver().setup();
				driver =new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(getPagetLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(getImpWait(), TimeUnit.SECONDS);
	}
	@After
	public void afterHooks(Scenario scenario) {
		// tear down will close browser and all tabs after each execution.
		tearDown();
		// get status of execution and log it 
		logger.info(scenario.getName() + "   " + scenario.getStatus());
	}
	

}
