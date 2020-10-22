package stepDefinitions;

import core.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DataBaseUtility;

public class SqlQueryStepDefinition extends Base {
	
	
		@Given("^User connects to PostgreSQL$")
		public void user_connects_to_PostgreSQL() throws Throwable {
			DataBaseUtility.setupConnection();
			logger.info("Connection has been established");
		}
		@When("^User sends \"([^\"]*)\"$")
		public void user_sends(String query) throws Throwable {
			DataBaseUtility.runQuery(query);
			logger.info(query + " : has been executed");
		}
		@Then("^User should get all information from that table$")
		public void user_should_get_all_information_from_that_table() throws Throwable {
			DataBaseUtility.returnResult();
			logger.info("ResultSet is stored in csv file in outcome folder");
			DataBaseUtility.closeDBConnection();
			logger.info("DataBase connection has been closed");

	}



}
