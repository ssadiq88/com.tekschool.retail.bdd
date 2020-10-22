package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.ElementNotInteractableException;

import core.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPageObj;
import pageObjects.MyAccountPageObj;
import utilities.WebDriverUtility;

public class LoginTestStepDefinition extends Base {
	
	LoginPageObj loginPageObj = new LoginPageObj();  
	MyAccountPageObj myAccountPageObj = new MyAccountPageObj();

	
	// we need to get to retail website
	
	

	@Given("^User is on Retail website$")
	public void user_is_on_Retail_website() throws Throwable {
	  Base.initializeDriver();
	  logger.info("Retail page is opened");
	  String actualPageTitle =loginPageObj.getPageTitle();
	  String expectedPageTitle ="TEK SCHOOL";
	  Assert.assertEquals(expectedPageTitle, actualPageTitle);
	  logger.info("Page title is verified");
	  WebDriverUtility.screenShot();
	  
	}

	@When("^User click on MyAccount$")
	public void user_click_on_MyAccount() throws Throwable {
		loginPageObj.clickOnMyAccount();
		logger.info("User click on My Account");
		
		
	    
	}

	@When("^User click on Login$")
	public void user_click_on_Login() throws Throwable {
		loginPageObj.clickOnLogin();
		logger.info("User click on Login");
		WebDriverUtility.wait(3000);
		WebDriverUtility.screenShot();
	    
	}

	// in Cucumber in order to pass values from scenario steps as a parameter we need to replace values with (.+) and 
	// and also we need to pass parameters as string to associated java methods
	@When("^User enter username '(.+)' and password '(.+)'$")
	public void user_enter_username_sdet_tekschool_us_and_password_sdet(String userName, String password) throws Throwable {
		loginPageObj.enterEmailAddress(userName);
		logger.info("User enter email address");
		loginPageObj.enterPassword(password);
		logger.info("User enter password");
		WebDriverUtility.screenShot();
	    
	}

	@When("^User click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		loginPageObj.clickOnloginButton();
		logger.info("User click on Login button");
	}
	@Then("^User should be logged in to MyAccount dashboard$")
	public void user_should_be_logged_in_to_MyAccount_dashboard() throws Throwable {
		Assert.assertTrue(myAccountPageObj.isMyAccountDisplayed());
		Assert.assertTrue(myAccountPageObj.isMyOrdersDisplayed());
		WebDriverUtility.screenShot();
	}
	@And("^User click on Logout$")
	public void user_click_on_logout() throws Throwable {
		// in order to handle the exception we can use try catch blocks.
		try {
			myAccountPageObj.clickOnLogOut();
		} catch (ElementNotInteractableException e) {
			myAccountPageObj.clickOnLogOut();
		}
	}
	@Then("^User Should be logged out from MyAccount dashboard$")
	public void user_should_be_logged_out_from_myAccount_dashboard() throws Throwable {
		Assert.assertTrue(myAccountPageObj.isLogOutConfirmationTextDisplayed());
		WebDriverUtility.screenShot();
		WebDriverUtility.wait(5000);
	}
	
	
	
}
