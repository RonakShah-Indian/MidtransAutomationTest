package com.midtrans.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * SignUp Screen locators
 */
public class SignUpScreen {

    public SignUpScreen(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.BUY_NOW_BTN)
    public WebElement buyNowBtn;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.NAME_TEXTFIELD)
    public WebElement nameTextField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.EMAIL_TEXTFIELD)
    public WebElement emailTextField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.PHONENO_TEXTFIELD)
    public WebElement phoneNoTextField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.CITY_TEXTFIELD)
    public WebElement cityTextField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.ADDRESS_TEXTFIELD)
    public WebElement addressTextfield;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.POSTAL_CODE_TEXTFIELD)
    public WebElement postalCodeTxtField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.CHECKOUT_BTN)
    public WebElement checkoutBtn;

    @FindBy(how = How.CLASS_NAME, using = Locators.SignUpPage.CONTINUE_BTN)
    public WebElement continueBtn;

    @FindBy(how = How.CLASS_NAME, using = Locators.SignUpPage.CREDIT_CARD_BTN)
    public WebElement creditCardBtn;

    @FindBy(how = How.NAME, using = Locators.SignUpPage.CREDIT_CARD_NUMBER_TEXTFIELD)
    public WebElement creditCardNumberTxtField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.CREDIT_CARD_CVV_TEXTFIELD)
    public WebElement creditCardCvvTxtField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.CREDIT_CARD_EXPIRY_TEXTFIELD)
    public WebElement creditCardExpiryTxtField;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.PROMO_CODE_CHECKBOX)
    public WebElement promoCodeCheckBox;

    @FindBy(how = How.CLASS_NAME, using = Locators.SignUpPage.PAY_NOW_BTN)
    public WebElement payNowBtn;

    @FindBy(how = How.XPATH, using = Locators.SignUpPage.CREDIT_CARD_OTP_TEXTFIELD)
    public WebElement creditCardOtpTxtField;

    @FindBy(how = How.CLASS_NAME, using = Locators.SignUpPage.OK_BTN)
    public WebElement okBtn;

    @FindBy(how = How.CLASS_NAME, using = Locators.SignUpPage.RETRY_DONE_BTN)
    public WebElement retryDoneBtn;



}
