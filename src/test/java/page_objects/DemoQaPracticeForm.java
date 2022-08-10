package page_objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaPracticeForm {
    private static final String FIRST_NAME_CSS = "#firstName"
        , LAST_NAME_CSS = "#lastName"
        , USER_EMAIL_CSS = "#userEmail"
        , MOBILE_NUMBER_CSS = "#userNumber"
        , GENDER_MALE_CSS = ".custom-control.custom-radio label[for='gender-radio-1']"
        , GENDER_MALE_SELECTED_OR_NOT_CSS = ".custom-control.custom-radio #gender-radio-1"
        , GENDER_FEMALE_CSS = ".custom-control.custom-radio label[for='gender-radio-2']"
        , GENDER_FEMALE_SELECTED_OR_NOT_CSS = ".custom-control.custom-radio #gender-radio-2"
        , GENDER_OTHER_CSS = ".custom-control.custom-radio label[for='gender-radio-3']"
        , GENDER_OTHER_SELECTED_OR_NOT_CSS = ".custom-control.custom-radio #gender-radio-3"
        , HOBBIES_SPORTS_CSS = ".custom-control.custom-checkbox label[for='hobbies-checkbox-1']"
        , HOBBIES_READING_CSS = ".custom-control.custom-checkbox label[for='hobbies-checkbox-2']"
        , HOBBIES_MUSIC_CSS = ".custom-control.custom-checkbox label[for='hobbies-checkbox-3']"
        , SUBJECTS_CSS = "div#subjectsContainer #subjectsInput"
        , CURRENT_ADDRESS_CSS = "#currentAddress"
        , DATE_OF_BIRTH_CSS = "#dateOfBirthInput"
        , DATEPICKER_MONTH_CSS = ".react-datepicker__month-select"
        , DATEPICKER_YEAR_CSS = ".react-datepicker__year-select"
        , DATEPICKER_DAY_CSS = ".react-datepicker__month div.react-datepicker__day--0"
        , DAY_NOT_THIS_MONTH_CSS = ":not([class*='outside-month'])"
        , UPLOAD_FILE_CSS = "#uploadPicture"
        , STATE_CSS = "#state"
        , CITY_CSS = "#city"
        , SUBMIT_BUTTON_CSS = "#submit"
        , TABLE_RESPONSIVE_CSS = ".table-responsive";

    @Step("Открываем тестовую страницу DemoQaPracticeForm")
    public void openTestPage() {
        open("/automation-practice-form");
    }

    @Step("Вводим Имя {firstName}")
    public void inputFirstName(String firstName) {
        $(FIRST_NAME_CSS).setValue(firstName);
    }

    @Step("Вводим Фамилию {lastName}")
    public void inputLastName(String lastName) {
        $(LAST_NAME_CSS).setValue(lastName);
    }

    @Step("Вводим E-mail {userEmail}")
    public void inputUserEmail(String userEmail) {
        $(USER_EMAIL_CSS).setValue(userEmail);
    }

    @Step("Вводим мобильный телефон {mobileNumber}")
    public void inputMobileNumber(String mobileNumber) {
        $(MOBILE_NUMBER_CSS).setValue(mobileNumber);
    }

    @Step("Выбираем \"Мужской\" пол")
    public void selectMaleGender() {
        if (!$(GENDER_MALE_SELECTED_OR_NOT_CSS).isSelected()) {
            $(GENDER_MALE_CSS).click();
        }
    }

    @Step("Выбираем \"Женский\" пол")
    public void selectFemaleGender() {
        if (!$(GENDER_FEMALE_SELECTED_OR_NOT_CSS).isSelected()) {
            $(GENDER_FEMALE_CSS).click();
        }
    }

    @Step("Выбираем \"Другой\" пол")
    public void selectOtherGender() {
        if (!$(GENDER_OTHER_SELECTED_OR_NOT_CSS).isSelected()) {
            $(GENDER_OTHER_CSS).click();
        }
    }
    @Step("Вводим адрес {currentAddress}")
    public void inputCurrentAddress(String currentAddress) {
        $(CURRENT_ADDRESS_CSS).setValue(currentAddress);
    }

    @Step("Вводим предмет обучения {subjects}")
    public void inputSubjects(String subjects) {
        $(SUBJECTS_CSS).setValue(subjects).pressEnter();
    }

    @Step("Выбираем хобби: Спорт")
    public void selectSportsHobbies() {
        $(HOBBIES_SPORTS_CSS).click();

    }

    @Step("Выбираем хобби: Чтение")
    public void selectReadingHobbies() {
        $(HOBBIES_READING_CSS).click();

    }

    @Step("Выбираем хобби: Музыка")
    public void selectMusicHobbies() {
        $(HOBBIES_MUSIC_CSS).click();

    }

    @Step("Вводим Дату Рождения {day}, {month}, {year}")
    public void inputDateOfBirth(String day, String month, String year) {
        $(DATE_OF_BIRTH_CSS).click();
        $(DATEPICKER_MONTH_CSS).click();
        $(DATEPICKER_MONTH_CSS).selectOption(month);
        $(DATEPICKER_MONTH_CSS).click();

        $(DATEPICKER_YEAR_CSS).click();
        $(DATEPICKER_YEAR_CSS).selectOption(year);
        $(DATEPICKER_YEAR_CSS).click();
        $(DATEPICKER_DAY_CSS +day+ DAY_NOT_THIS_MONTH_CSS).click();
    }

    @Step("Загружаем файл")
    public void uploadFile() {
        $(UPLOAD_FILE_CSS).uploadFromClasspath("img/summer.jpg");
    }

    @Step("Выбираем Штат: {state}")
    public void selectState(String state) {
        $(STATE_CSS).click();
        $(byText(state)).click();
    }

    @Step("Выбираем Город: {city}")
    public void selectCity(String city) {
        $(CITY_CSS).click();
        $(byText(city)).click();
    }

    @Step("Нажимаем кнопку подтвердить")
    public void clickSubmit() {
        $(SUBMIT_BUTTON_CSS).click();
    }

    @Step("Проверяем наличие Имени: {firstName}, Фамилии: {lastName}, E-mail: {userEmail} и Телефона: {mobileNumber} в табеле!")
    public void verifySubmitForm( String firstName, String lastName, String userEmail, String mobileNumber) {
        $(TABLE_RESPONSIVE_CSS).$(byText("Student Name")).parent().shouldHave(text(firstName+" "+lastName));
        $(TABLE_RESPONSIVE_CSS).$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(TABLE_RESPONSIVE_CSS).$(byText("Mobile")).parent().shouldHave(text(mobileNumber));
    }


}
