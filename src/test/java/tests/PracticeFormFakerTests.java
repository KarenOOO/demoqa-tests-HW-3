package tests;

import data.TestData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationComponent;

import static data.TestData.*;

public class PracticeFormFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultRegistrationComponent checkResultRegistration = new CheckResultRegistrationComponent();
    TestData testData = new TestData();


    @Test
    void fillFullPracticeFormTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .setUploadPicture(testData.img)
                .setCurrentAddress(testData.address)
                .setSelectState(testData.state)
                .setSelectCity(testData.city)
                .setSubmit();

        checkResultRegistration.checkResult(checkName, testData.fullName)
                .checkResult(checkEmail, testData.email)
                .checkResult(checkGender, testData.gender)
                .checkResult(checkMobile, testData.phone)
                .checkResult(checkDateOfBirth, testData.dateOfBirth)
                .checkResult(checkSubjects, testData.subject)
                .checkResult(checkHobbies, testData.hobby)
                .checkResult(checkPicture, testData.img)
                .checkResult(checkAddress, testData.address)
                .checkResult(checkStateAndCity, testData.stateAndCity);
    }

    @Test
    void fillMinimumPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .setSubmit();

        checkResultRegistration.checkResult(checkName, testData.fullName)
                .checkResult(checkGender, testData.gender)
                .checkResult(checkMobile, testData.phone)
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