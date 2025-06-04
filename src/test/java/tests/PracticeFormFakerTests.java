package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationComponent;
import utils.RandomUtils;

import static pages.RegistrationPage.*;

public class PracticeFormFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultRegistrationComponent checkResultRegistration = new CheckResultRegistrationComponent();
    private final RandomUtils faker = new RandomUtils();

    @Test
    void fillFullPracticeFormTest() {

        registrationPage.openPage()
                .setFirstName(faker.getFirstName)
                .setLastName(faker.getLastName)
                .setEmail(faker.getEmail)
                .setGender(faker.getGender)
                .setNumber(faker.getNumber)
                .setDateOfBirth(faker.getDay, faker.getMonth, faker.getYear)
                .setSubjects(faker.getSubjects)
                .setHobbies(faker.getHobbies)
                .setUploadPicture(faker.getImg)
                .setCurrentAddress(faker.getCurrentAddress)
                .setSelectState(faker.getSelectState)
                .setSelectCity(faker.getSelectCity)
                .setSubmit();

        checkResultRegistration.checkResult(checkName, faker.getFullName)
                .checkResult(checkEmail, faker.getEmail)
                .checkResult(checkGender, faker.getGender)
                .checkResult(checkMobile, faker.getNumber)
                .checkResult(checkDateOfBirth, faker.getDateOfBirth)
                .checkResult(checkSubjects, faker.getSubjects)
                .checkResult(checkHobbies, faker.getHobbies)
                .checkResult(checkPicture, faker.getImg)
                .checkResult(checkAddress, faker.getCurrentAddress)
                .checkResult(checkStateAndCity, faker.getStateAndCity);
    }

    @Test
    void fillMinimumPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(faker.getFirstName)
                .setLastName(faker.getLastName)
                .setGender(faker.getGender)
                .setNumber(faker.getNumber)
                .setSubmit();

        checkResultRegistration.checkResult(checkName, faker.getFullName)
                .checkResult(checkGender, faker.getGender)
                .checkResult(checkMobile, faker.getNumber)
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