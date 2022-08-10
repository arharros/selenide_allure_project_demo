package page_objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTextBox {

    private final static String FULL_NAME_CSS = "#userName"
            , USER_EMAIL_CSS = "#userEmail"
            , CURRENT_ADDRESS_CSS = "#currentAddress"
            , PERMANENT_ADDRESS_CSS = "#permanentAddress"
            , BUTTON_SUBMIT_CSS = "#submit"
            , BORDER_CSS = ".border"
            , BORDER_NAME_CSS = "#name"
            , BORDER_EMAIL_CSS = "#email"
            , BORDER_CURR_ADDRESS_CSS = "#currentAddress"
            , BORDER_PERM_ADDRESS_CSS = "#permanentAddress";
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

    @Step("Открываем тестовую страницу TexBox")
    public void openTestPage() {
        open("/text-box");
    }

    @Step("Вводим Имя и Фамилию")
    public DemoQaTextBox inputFullName(String fullName) {
        $(FULL_NAME_CSS).setValue(fullName);
        setUserFullName(fullName);
        return this;
    }



    @Step("Вводим E-Mail")
    public DemoQaTextBox inputEmail(String email) {
        $(USER_EMAIL_CSS).setValue(email);
        setUserEmail(email);
        return this;
    }

    @Step("Вводим текущий адрес")
    public DemoQaTextBox inputCurrentAddress(String currentAddress) {
        $(CURRENT_ADDRESS_CSS).setValue(currentAddress);
        setCurrentAddress(currentAddress);
        return this;
    }

    @Step("Вводим адрес прописки")
    public DemoQaTextBox inputPermanentAddress(String permanentAddress) {
        $(PERMANENT_ADDRESS_CSS).setValue(permanentAddress);
        setPermanentAddress(permanentAddress);
        return this;
    }

    @Step("Нажимаем кнопку подтверждения")
    public void clickSubmit() {
        $(BUTTON_SUBMIT_CSS).click();
    }

    @Step("Проверяем наличие введеных данных: Имя Фамилия, E-Mail, Текущий адрес, Адрес Прописки")
    public void verifySubmitBorder() {
        $(BORDER_CSS).$(BORDER_NAME_CSS).shouldHave(text(getUserFullName()));
        $(BORDER_CSS).$(BORDER_EMAIL_CSS).shouldHave(text(getUserEmail()));
        $(BORDER_CSS).$(BORDER_CURR_ADDRESS_CSS).shouldHave(text(getCurrentAddress()));
        $(BORDER_CSS).$(BORDER_PERM_ADDRESS_CSS).shouldHave(text(getPermanentAddress()));
    }
}
