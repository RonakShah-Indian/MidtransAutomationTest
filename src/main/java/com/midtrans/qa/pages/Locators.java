package com.midtrans.qa.pages;


/**
 * Contains elements locator
 */
public class Locators {

    /* SIGN UP Page Locators */
    public static final class SignUpPage {


        public static final String BUY_NOW_BTN="//a[@class='btn buy']";

        public static final String NAME_TEXTFIELD = "//tr[1]//td[2]//input[1]";
        public static final String EMAIL_TEXTFIELD = "//tr[2]//td[2]//input[1]";
        public static final String PHONENO_TEXTFIELD = "//tr[3]//td[2]//input[1]";
        public static final String CITY_TEXTFIELD = "//tr[4]//td[2]//input[1]";
        public static final String ADDRESS_TEXTFIELD = "//textarea[contains(text(),'MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11')]";
        public static final String POSTAL_CODE_TEXTFIELD = "//tr[6]//td[2]//input[1]";
        public static final String CHECKOUT_BTN = "//div[@class='cart-checkout']";

        public static final String CONTINUE_BTN = "show";

        public static final String CREDIT_CARD_BTN = "list-content";
        public static final String CREDIT_CARD_NUMBER_TEXTFIELD = "cardnumber";//name
        public static final String CREDIT_CARD_CVV_TEXTFIELD = "//*[@id=\"application\"]/div[3]/div/div/div/form/div[2]/div[3]/input";
        public static final String CREDIT_CARD_EXPIRY_TEXTFIELD = "//*[@id=\"application\"]/div[3]/div/div/div/form/div[2]/div[2]/input";
        public static final String PROMO_CODE_CHECKBOX="//*[@id=\"application\"]/div[3]/div/div/div/form/div[4]/div[2]/div[4]/div/label/input";
        public static final String PAY_NOW_BTN="show";

        public static final String CREDIT_CARD_OTP_TEXTFIELD = "/html/body/div/form/div[5]/div/input";
        public static final String OK_BTN="btn-success";

        public static final String RETRY_DONE_BTN="show";

    }
}
