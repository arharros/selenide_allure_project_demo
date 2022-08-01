package tests;


import org.junit.jupiter.api.Test;
import page_objects.DemoQaPracticeForm;
import page_objects.DemoQaTextBox;
import page_objects.TestsBase;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class MainTest extends TestsBase {
    String firstName = "Ivan"
            ,lastName = "Ivanov"
            ,userEmail = "ivanov@company.com"
            ,mobileNumber = "1234567891"
            ,currentAddress = "Kurchatova 10-25"
            ,permanentAddress = "Pirogova 2"
            ,subject1 = "Maths"
            ,subject2 = "Chemistry"
            ,state = "Rajasthan"
            ,city = "Jaiselmer"
            ,dayOfBirth = "28"
            ,monthOfBirth = "April"
            ,yearOfBirth = "1983";


    @Test
    public void PracticeFormTest() {
        open("/automation-practice-form");
        DemoQaPracticeForm practiceForm = new DemoQaPracticeForm();
        practiceForm.inputFirstName(firstName);
        practiceForm.inputLastName(lastName);
        practiceForm.inputUserEmail(userEmail);
        practiceForm.inputMobileNumber(mobileNumber);
        practiceForm.selectMaleGender();
        practiceForm.selectSportsHobbies();
        practiceForm.selectReadingHobbies();
        practiceForm.selectMusicHobbies();
        practiceForm.inputCurrentAddress(currentAddress);
        practiceForm.uploadFile();
        practiceForm.inputSubjects(subject1);
        practiceForm.inputSubjects(subject2);
        practiceForm.selectState(state);
        practiceForm.selectCity(city);
        practiceForm.inputDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        practiceForm.clickSubmit();
        practiceForm.verifySubmitForm(firstName, lastName, userEmail, mobileNumber);
    }

    @Test
    public void TextBoxText() {
        open("/text-box");
        DemoQaTextBox textBox = new DemoQaTextBox();
        textBox.inputFullName(firstName+" "+lastName)
                .inputEmail(userEmail)
                .inputCurrentAddress(currentAddress)
                .inputPermanentAddress(permanentAddress)
                .clickSubmit();
        textBox.verifySubmitBorder();
    }





}
