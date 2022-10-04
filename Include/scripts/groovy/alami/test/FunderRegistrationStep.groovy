package alami.test
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.commons.javaflow.bytecode.Continuable

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

public class RegisterSteps {

	@When("User open browser")
	def openBroswer() {
	}

	@And("User navigate to alami login page")
	def navigateToUrl() {
		WebUI.navigateToUrl(GlobalVariable.alamiUrl)
	}

	@Then("User should directed to alami login page")
	def directedToLoginPage() {
	}

	@When("User click daftar disini")
	def clickRegister(){
		WebUI.click(findTestObject('Login Page/register_button'))
	}

	@And("User click Pemberi Dana")
	def clickFunderOption() {
		WebUI.click(findTestObject('Register Page/funders_option'))
	}

	@Then("User should directed to Registrasi Pemberi Dana page")
	def directedToRegisterPage() {
	}

	@When("User fill full name text field")
	def inputFullName() {
		WebUI.setText(findTestObject('Register Page/fundersFullName_field'), GlobalVariable.fullName)
	}

	@And("User fill email text field")
	def inputEmail() {
		WebUI.setText(findTestObject('Register Page/fundersEmail_field'), GlobalVariable.email)
	}

	@And("User fill phone number field")
	def inputPhoneNumber() {
		WebUI.setText(findTestObject('Register Page/fundersPhoneNumber_field'), GlobalVariable.phoneNumber)
	}

	@And("User fill password field")
	def inputPassword() {
		WebUI.setEncryptedText(findTestObject('Register Page/fundersPassword_field'), GlobalVariable.password)
	}

	@And("User choose account type individual")
	def chooseAccountTypeIndividual(){
		WebUI.click(findTestObject('Register Page/fundersInstitusi_radiobutton'))
	}

	@And("User fill referral code")
	def inputReferralCode() {
	}

	@And("User choose referral source instagram")
	def chooseRefSourcceIg() {
		WebUI.selectOptionByValue(findTestObject('Register Page/fundersReferral_dropdown'), '2', true)
	}

	@And("User click continue button")
	def clickRegisterContinue() {
		WebUI.click(findTestObject('Register Page/fundersNext_button'))
	}

	@Then("User should directed to privacy policy & term of use page")
	def directedToPrivacyPolicyPage() {
		WebUI.verifyTextPresent("Kebijakan Privasi & Ketentuan Pengguna", true)
	}

	@When("User scroll and read privacy policy & term")
	def scrollPrivacyPolicy() {
		WebUI.scrollToElement(findTestObject('Register Page/fundersTermConditions_end_text'), 5)
	}

	@And("User check privacy policy agreement")
	def checkAgreementCheckbox() {
		WebUI.click(findTestObject('Register Page/fundersTermConditionsAgreement_checkbox'))
	}

	@And("User click privacy policy continue button")
	def clickAgreementContinue() {
		WebUI.click(findTestObject('Register Page/privacyContinue_button'))
	}

	@Then("User should directed to registration success page")
	def directedToSuccessPage() {
		WebUI.verifyElementPresent(findTestObject('Register Page/registerSuccess_page'), 5)
	}
}