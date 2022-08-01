package page_objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaTextBox {
    private final static String FULL_NAME = "#userName"
            ,USER_EMAIL = "#userEmail"
            ,CURRENT_ADDRESS = "#currentAddress"
            ,PERMANENT_ADDRESS = "#permanentAddress"
            ,BUTTON_SUBMIT = "#submit"
            ,BORDER = ".border"
            ,BORDER_NAME = "#name"
            ,BORDER_EMAIL = "#email"
            ,BORDER_CURR_ADDRESS = "#currentAddress"
            ,BORDER_PERM_ADDRESS = "#permanentAddress";
    private String userFullName
            ,userEmail
            ,currentAddress
            ,permanentAddress;

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    private void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public DemoQaTextBox inputFullName(String fullName) {
        $(FULL_NAME).setValue(fullName);
        setUserFullName(fullName);
        return this;
    }
    public DemoQaTextBox inputEmail(String email) {
        $(USER_EMAIL).setValue(email);
        setUserEmail(email);
        return this;
    }
    public DemoQaTextBox inputCurrentAddress(String currentAddress) {
        $(CURRENT_ADDRESS).setValue(currentAddress);
        setCurrentAddress(currentAddress);
        return this;
    }
    public DemoQaTextBox inputPermanentAddress(String permanentAddress) {
        $(PERMANENT_ADDRESS).setValue(permanentAddress);
        setPermanentAddress(permanentAddress);
        return this;
    }

    public void clickSubmit() {
        $(BUTTON_SUBMIT).click();
    }

    public void verifySubmitBorder() {
        $(BORDER).$(BORDER_NAME).shouldHave(text(getUserFullName()));
        $(BORDER).$(BORDER_EMAIL).shouldHave(text(getUserEmail()));
        $(BORDER).$(BORDER_CURR_ADDRESS).shouldHave(text(getCurrentAddress()));
        $(BORDER).$(BORDER_PERM_ADDRESS).shouldHave(text(getPermanentAddress()));
    }
}
