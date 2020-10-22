package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.WebDriverUtility;
// obecj reportsiorty
public class RegisterFormPageObj extends Base {
	
	// store webElement of register form UI
	
	// we need to create a constructor
		public RegisterFormPageObj() {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//a[text()='Register']")
		private WebElement register;
		@FindBy(id = "input-firstname")
		private WebElement firstNameField;
		@FindBy(id = "input-lastname")
		private WebElement lastNameField;
		@FindBy(id = "input-email")
		private WebElement emailField;
		@FindBy(id = "input-telephone")
		private WebElement phoneField;
		@FindBy(id = "input-password")
		private WebElement passwordField;
		@FindBy(id = "input-confirm")
		private WebElement passwordConfirmField;
		@FindBy(xpath = "(//input[@name='newsletter'])[1]")
		private WebElement yesSubscribe;
		@FindBy(xpath = "(//input[@name='newsletter'])[2]")
		private WebElement noSubscribe;
		@FindBy(xpath = "//input[@name='agree']")
		private WebElement privacyPolicy;
		@FindBy(xpath = "//input[@class='btn btn-primary']")
		private WebElement continueButton;
		@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Your Account Has Been Created!')]")
		private WebElement yourAcctCreatedMessage;
		// we start writting methods for
		public void clickOnRegister() {
			WebDriverUtility.clickOnElement(register); // this is the same as register.click
		}
		public void enterFirstName(String fName) {
			firstNameField.sendKeys(fName);
		}
		public void enterLastName(String lName) {
			lastNameField.sendKeys(lName);
		}
		public void enterEmail(String email) {
			emailField.sendKeys(email);
		}
		public void enterPhone(String phone) {
			phoneField.sendKeys(phone);
		}
		public void enterPassword(String password) {
			passwordField.sendKeys(password);
		}
		public void enterPasswordConfirm(String passwordConfirm) {
			passwordConfirmField.sendKeys(passwordConfirm);
		}
		public void selectYesOnSubscribe() {
			if (!yesSubscribe.isSelected())
				yesSubscribe.click();
		}
		public void clickOnPrivacyPolicy() {
			privacyPolicy.click();
		}
		public void clickOnContinueButton() {
			continueButton.click();
		}
		public String getSuccessfullAccountCreationMessage() {
			String successMessage = yourAcctCreatedMessage.getText();
			return successMessage;
		}
	
	

}
