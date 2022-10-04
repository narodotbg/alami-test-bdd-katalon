package alami.test

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

public class LoginStep {
	@When("User input valid email")
	def inputLoginEmail() {
		WebUI.setText(findTestObject('Object Repository/Login Page/email_field'), GlobalVariable.email)
	}

	@And("User input valid password")
	def inputLoginPassowrd() {
		WebUI.setEncryptedText(findTestObject('Object Repository/Login Page/password_field'), GlobalVariable.password)
	}

	@And("User click login button")
	def clickLoginButton() {
		WebUI.click(findTestObject('Object Repository/Login Page/login_button'))
	}

	@Then("User should directed to dashboard page")
	def verifyDashboardPage() {
		String pageTitle = WebUI.getWindowTitle()
		WebUI.verifyMatch("Alami - Dashboard", pageTitle, true)
	}
}
