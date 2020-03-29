package com.midtrans.qa.testcases;

import com.midtrans.qa.base.TestBase;
import com.midtrans.qa.pages.SignUpScreen;
import com.midtrans.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FailedPaymentTest extends TestBase {
	SignUpScreen signUpScreen;
	TestUtil testUtil;

	public FailedPaymentTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		signUpScreen = new SignUpScreen(driver);
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws Exception {
		String name=generateRandomString(5,Mode.ALPHA);
		String email=generateRandomString(5,Mode.ALPHA)+"@example.in";
		String phone=generateRandomString(10,Mode.NUMERIC);
		String city=generateRandomString(5,Mode.ALPHA);
		String address=generateRandomString(10,Mode.ALPHA);
		String postalCode=generateRandomString(5,Mode.NUMERIC);

		Assert.assertTrue(isFound(signUpScreen.buyNowBtn));
		signUpScreen.buyNowBtn.click();

		Assert.assertTrue(isFound(signUpScreen.emailTextField));
		sendText(signUpScreen.nameTextField,name);
		sendText(signUpScreen.emailTextField,email);
		sendText(signUpScreen.phoneNoTextField,phone);
		sendText(signUpScreen.cityTextField,city);
		sendText(signUpScreen.addressTextfield,address);
		sendText(signUpScreen.postalCodeTxtField,postalCode);
		signUpScreen.checkoutBtn.click();

		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		signUpScreen.continueBtn.click();

		Thread.sleep(3000);
		Assert.assertTrue(isFound(signUpScreen.creditCardBtn));
		signUpScreen.creditCardBtn.click();

		Thread.sleep(3000);
		Assert.assertTrue(isFound(signUpScreen.payNowBtn));
		sendText(signUpScreen.creditCardNumberTxtField,"4911111111111113");
		sendText(signUpScreen.creditCardExpiryTxtField,"0223");
		sendText(signUpScreen.creditCardCvvTxtField,"123");
		signUpScreen.promoCodeCheckBox.click();
		signUpScreen.payNowBtn.click();

		Thread.sleep(15000);
		driver.switchTo().frame(0);
		Assert.assertTrue(isFound(signUpScreen.creditCardOtpTxtField));
		sendText(signUpScreen.creditCardOtpTxtField,"112233");
		signUpScreen.okBtn.click();

		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Assert.assertTrue(isFound(signUpScreen.retryDoneBtn));
		signUpScreen.retryDoneBtn.click();

		Thread.sleep(3000);
		Assert.assertTrue(isFound(signUpScreen.creditCardBtn));
		Reporter.log("This scriot verifies failed payment test");

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
