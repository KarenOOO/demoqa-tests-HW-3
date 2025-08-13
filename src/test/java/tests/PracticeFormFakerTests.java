package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationComponent;

import static data.TestData.*;

@Epic("Demoqa")
@Feature("Header")
@Story("Регестрация")
@Owner("medina")
@Severity(SeverityLevel.NORMAL)

@DisplayName("Форма регистрации — тесты")
public class PracticeFormFakerTests extends TestBase {

    private RegistrationPage registrationPage;
    private CheckResultRegistrationComponent checkResultRegistration;
    private TestData testData;

    @BeforeEach
    public void setUp() {
        registrationPage = RegistrationPage.openPage();
        testData = new TestData();
        checkResultRegistration = new CheckResultRegistrationComponent();
    }

    @DisplayName("Регистрация с заполнением всех полей")
    @Tag("Web")
    @Test
    void fillFullPracticeFormTest() {

        registrationPage.setFirstName(testData.firstName)
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

    @DisplayName("Регистрация с заполнением обязательных полей")
    @Tag("Web")
    @Test
    void fillMinimumPracticeFormTest() {
        registrationPage
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

    @DisplayName("Попытка регистрации с пустыми полями")
    @Tag("Web")
    @Test
    void fillPracticeFormNegTest() {
        registrationPage
                .setFirstName("")
                .setLastName("")
                .setEmail("1234")
                .setNumber("999")
                .setSubmit();

        checkResultRegistration.checkValidation();
    }
}