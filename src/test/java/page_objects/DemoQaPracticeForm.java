package page_objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaPracticeForm {
    private static final String FIRST_NAME = "#firstName"
        ,LAST_NAME = "#lastName"
        ,USER_EMAIL = "#userEmail"
        ,MOBILE_NUMBER = "#userNumber"
        ,GENDER_MALE = ".custom-control.custom-radio label[for='gender-radio-1']"
        ,GENDER_MALE_SELECTED_OR_NOT = ".custom-control.custom-radio #gender-radio-1"
        ,GENDER_FEMALE = ".custom-control.custom-radio label[for='gender-radio-2']"
        ,GENDER_FEMALE_SELECTED_OR_NOT = ".custom-control.custom-radio #gender-radio-2"
        ,GENDER_OTHER = ".custom-control.custom-radio label[for='gender-radio-3']"
        ,GENDER_OTHER_SELECTED_OR_NOT = ".custom-control.custom-radio #gender-radio-3"
        ,HOBBIES_SPORTS = ".custom-control.custom-checkbox label[for='hobbies-checkbox-1']"
        ,HOBBIES_READING = ".custom-control.custom-checkbox label[for='hobbies-checkbox-2']"
        ,HOBBIES_MUSIC = ".custom-control.custom-checkbox label[for='hobbies-checkbox-3']"
        ,SUBJECTS = "div#subjectsContainer #subjectsInput"
        ,CURRENT_ADDRESS = "#currentAddress"
        ,DATE_OF_BIRTH = "#dateOfBirthInput"
        ,DATEPICKER_MONTH = ".react-datepicker__month-select"
        ,DATEPICKER_YEAR = ".react-datepicker__year-select"
        ,DATEPICKER_DAY = ".react-datepicker__month div.react-datepicker__day--0"
        ,DAY_NOT_THIS_MONTH = ":not([class*='outside-month'])"
        ,UPLOAD_FILE = "#uploadPicture"
        ,STATE = "#state"
        ,CITY = "#city"
        ,SUBMIT_BUTTON = "#submit"
        ,TABLE_RESPONSIVE = ".table-responsive";

    @Step("Открываем тестовую страницу DemoQaPracticeForm")
    public void openTestPage() {
        open("/automation-practice-form");
    }
    @Step("Вводим Имя {firstName}")
    public void inputFirstName(String firstName) {
        $(FIRST_NAME).setValue(firstName);
    }

    @Step("Вводим Фамилию {lastName}")
    public void inputLastName(String lastName) {
        $(LAST_NAME).setValue(lastName);
    }

    @Step("Вводим E-mail {userEmail}")
    public void inputUserEmail(String userEmail) {
        $(USER_EMAIL).setValue(userEmail);
    }

    @Step("Вводим мобильный телефон {mobileNumber}")
    public void inputMobileNumber(String mobileNumber) {
        $(MOBILE_NUMBER).setValue(mobileNumber);
    }

    @Step("Выбираем \"Мужской\" пол")
    public void selectMaleGender() {
        if (!$(GENDER_MALE_SELECTED_OR_NOT).isSelected()) {
            $(GENDER_MALE).click();
        }
    }

    @Step("Выбираем \"Женский\" пол")
    public void selectFemaleGender() {
        if (!$(GENDER_FEMALE_SELECTED_OR_NOT).isSelected()) {
            $(GENDER_FEMALE).click();
        }
    }

    @Step("Выбираем \"Другой\" пол")
    public void selectOtherGender() {
        if (!$(GENDER_OTHER_SELECTED_OR_NOT).isSelected()) {
            $(GENDER_OTHER).click();
        }
    }
    @Step("Вводим адрес {currentAddress}")
    public void inputCurrentAddress(String currentAddress) {
        $(CURRENT_ADDRESS).setValue(currentAddress);
    }

    @Step("Вводим предмет обучения {subjects}")
    public void inputSubjects(String subjects) {
        $(SUBJECTS).setValue(subjects).pressEnter();
    }

    @Step("Выбираем хобби: Спорт")
    public void selectSportsHobbies() {
        $(HOBBIES_SPORTS).click();

    }

    @Step("Выбираем хобби: Чтение")
    public void selectReadingHobbies() {
        $(HOBBIES_READING).click();

    }

    @Step("Выбираем хобби: Музыка")
    public void selectMusicHobbies() {
        $(HOBBIES_MUSIC).click();

    }

    @Step("Вводим Дату Рождения {day}, {month}, {year}")
    public void inputDateOfBirth(String day, String month, String year) {
        $(DATE_OF_BIRTH).click();
        $(DATEPICKER_MONTH).click();
        $(DATEPICKER_MONTH).selectOption(month);
        $(DATEPICKER_MONTH).click();

        $(DATEPICKER_YEAR).click();
        $(DATEPICKER_YEAR).selectOption(year);
        $(DATEPICKER_YEAR).click();
        $(DATEPICKER_DAY+day+DAY_NOT_THIS_MONTH).click();
    }

    @Step("Загружаем файл")
    public void uploadFile() {
        $(UPLOAD_FILE).uploadFromClasspath("img/summer.jpg");
    }

    @Step("Выбираем Штат: {state}")
    public void selectState(String state) {
        $(STATE).click();
        $(byText(state)).click();
    }

    @Step("Выбираем Город: {city}")
    public void selectCity(String city) {
        $(CITY).click();
        $(byText(city)).click();
    }

    @Step("Нажимаем кнопку подтвердить")
    public void clickSubmit() {
        $(SUBMIT_BUTTON).click();
    }

    @Step("Проверяем наличие Имени: {firstName}, Фамилии: {lastName}, E-mail: {userEmail} и Телефона: {mobileNumber} в табеле!")
    public void verifySubmitForm( String firstName, String lastName, String userEmail, String mobileNumber) {
        $(TABLE_RESPONSIVE).$(byText("Student Name")).parent().shouldHave(text(firstName+" "+lastName));
        $(TABLE_RESPONSIVE).$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(TABLE_RESPONSIVE).$(byText("Mobile")).parent().shouldHave(text(mobileNumber));
    }


}
