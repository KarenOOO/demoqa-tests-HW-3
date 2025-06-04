package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationComponent;

import static pages.RegistrationPage.*;
import static utils.RandomUtils.*;

public class PracticeFormFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultRegistrationComponent checkResultRegistration = new CheckResultRegistrationComponent();

    @Test
    void fillFullPracticeFormTest() {

        registrationPage.openPage()
                .setFirstName(getFirstName)
                .setLastName(getLastName)
                .setEmail(getEmail)
                .setGender(getGender)
                .setNumber(getNumber)
                .setDateOfBirth(getDay, getMonth, getYear)
                .setSubjects(getSubjects)
                .setHobbies(getHobbies)
                .setUploadPicture(apple)
                .setCurrentAddress(getCurrentAddress)
                .setSelectState(getSelectState)
                .setSelectCity(getSelectCity)
                .setSubmit();

        checkResultRegistration.checkResult(checkName, getFullName)
                .checkResult(checkEmail, getEmail)
                .checkResult(checkGender, getGender)
                .checkResult(checkMobile, getNumber)
                .checkResult(checkDateOfBirth, getDateOfBirth)
                .checkResult(checkSubjects, getSubjects)
                .checkResult(checkHobbies, getHobbies)
                .checkResult(checkPicture, apple)
                .checkResult(checkAddress, getCurrentAddress)
                .checkResult(checkStateAndCity, getStateAndCity);
    }

    @Test
    void fillMinimumPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(getFirstName)
                .setLastName(getLastName)
                .setGender(getGender)
                .setNumber(getNumber)
                .setSubmit();

        checkResultRegistration.checkResult(checkName, getFullName)
                .checkResult(checkGender, getGender)
                .checkResult(checkMobile, getNumber)
                ;
    }

    @Test
    void fillPracticeFormNegTest() {
        registrationPage.openPage()
                .setFirstName("")
                .setLastName("")
                .setEmail("1234")
                .setNumber("999")
                .setSubmit();

        checkResultRegistration.checkValidation();
    }
}