package alami.test

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable

public class EmailVerificationStep {
	WebDriver driver = DriverFactory.getWebDriver()

	@Given("User already login to mail account")
	def navigateToTempMail() {
		WebUI.navigateToUrl(GlobalVariable.tempMailUrl)
		driver.manage().sleep(6000)
		WebUI.click(findTestObject('Object Repository/TemporaryEmail/refresh_button'))
		WebUI.click(findTestObject('Object Repository/TemporaryEmail/inbox_button'))
	}

	@And("Verification link is sent to user mail")
	def verifyEmailVerificationIsSent() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/TemporaryEmail/verificationMailSubject'))
		WebUI.click(findTestObject('Object Repository/TemporaryEmail/verificationMailSubject'))
		WebUI.refresh()
		//repetition to handle dynamic ads from temporary email
		WebUI.click(findTestObject('Object Repository/TemporaryEmail/inbox_button'))
		WebUI.click(findTestObject('Object Repository/TemporaryEmail/verificationMailSubject'))
	}

	@When("User click email activation button")
	def clickEmailVerificationButton() {
		WebUI.scrollToElement(findTestObject('Object Repository/TemporaryEmail/emailVerification_button'), 5)
		WebUI.click(findTestObject('Object Repository/TemporaryEmail/emailVerification_button'))
	}

	@Then("User should directed to email activation success page")
	def directedToEmailVerificationSuccessPage() {
		WebUI.switchToWindowIndex(1)
		WebUI.verifyTextPresent("Alhamdulillah!", true)
	}
}
