package page_objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DemoQaPracticeForm {
    private static final String FIRST_NAME = "#firstName";
    private static final String LAST_NAME = "#lastName";
    private static final String USER_EMAIL = "#userEmail";
    private static final String MOBILE_NUMBER = "#userNumber";

    private static final String GENDER_MALE = ".custom-control.custom-radio label[for='gender-radio-1']";
    private static final String GENDER_MALE_SELECTED_OR_NOT = ".custom-control.custom-radio #gender-radio-1";
    private static final String GENDER_FEMALE = ".custom-control.custom-radio label[for='gender-radio-2']";
    private static final String GENDER_FEMALE_SELECTED_OR_NOT = ".custom-control.custom-radio #gender-radio-2";
    private static final String GENDER_OTHER = ".custom-control.custom-radio label[for='gender-radio-3']";
    private static final String GENDER_OTHER_SELECTED_OR_NOT = ".custom-control.custom-radio #gender-radio-3";

    private static final String HOBBIES_SPORTS = ".custom-control.custom-checkbox label[for='hobbies-checkbox-1']";
    private static final String HOBBIES_READING = ".custom-control.custom-checkbox label[for='hobbies-checkbox-2']";
    private static final String HOBBIES_MUSIC = ".custom-control.custom-checkbox label[for='hobbies-checkbox-3']";

    private static final String SUBJECTS = "div#subjectsContainer #subjectsInput";
    private static final String CURRENT_ADDRESS = "#currentAddress";

    private static final String DATE_OF_BIRTH = "#dateOfBirthInput";
    private static final String DATEPICKER_MONTH = ".react-datepicker__month-select";
    private static final String DATEPICKER_YEAR = ".react-datepicker__year-select";
    private static final String DATEPICKER_DAY = ".react-datepicker__month div.react-datepicker__day--0";
    private static final String DAY_NOT_THIS_MONTH = ":not([class*='outside-month'])";

    private static final String UPLOAD_FILE = "#uploadPicture";

    private static final String STATE = "#state";
    private static final String CITY = "#city";

    private static final String SUBMIT_BUTTON = "#submit";

    private static final String TABLE_RESPONSIVE = ".table-responsive";


    public void inputFirstName(String firstName) {
        $(FIRST_NAME).setValue(firstName);
    }

    public void inputLastName(String lastName) {
        $(LAST_NAME).setValue(lastName);
    }

    public void inputUserEmail(String userEmail) {
        $(USER_EMAIL).setValue(userEmail);
    }

    public void inputMobileNumber(String mobileNumber) {
        $(MOBILE_NUMBER).setValue(mobileNumber);
    }

    public void selectMaleGender() {
        if (!$(GENDER_MALE_SELECTED_OR_NOT).isSelected()) {
            $(GENDER_MALE).click();
        }
    }

    public void selectFemaleGender() {
        if (!$(GENDER_FEMALE_SELECTED_OR_NOT).isSelected()) {
            $(GENDER_FEMALE).click();
        }
    }

    public void selectOtherGender() {
        if (!$(GENDER_OTHER_SELECTED_OR_NOT).isSelected()) {
            $(GENDER_OTHER).click();
        }
    }

    public void inputCurrentAddress(String currentAddress) {
        $(CURRENT_ADDRESS).setValue(currentAddress);
    }

    public void inputSubjects(String subjects) {
        $(SUBJECTS).setValue(subjects).pressEnter();
    }

    public void selectSportsHobbies() {
        $(HOBBIES_SPORTS).click();

    }

    public void selectReadingHobbies() {
        $(HOBBIES_READING).click();

    }

    public void selectMusicHobbies() {
        $(HOBBIES_MUSIC).click();

    }

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

    public void uploadFile() {
        $(UPLOAD_FILE).uploadFromClasspath("img/summer.jpg");
    }

    public void selectState(String state) {
        $(STATE).click();
        $(byText(state)).click();
    }

    public void selectCity(String city) {
        $(CITY).click();
        $(byText(city)).click();
    }

    public void clickSubmit() {
        $(SUBMIT_BUTTON).click();
    }

    public void verifySubmitForm( String firstName, String lastName, String userEmail, String mobileNumber) {
        $(TABLE_RESPONSIVE).$(byText("Student Name")).parent().shouldHave(text(firstName+" "+lastName));
        $(TABLE_RESPONSIVE).$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(TABLE_RESPONSIVE).$(byText("Mobile")).parent().shouldHave(text(mobileNumber));
    }


}
