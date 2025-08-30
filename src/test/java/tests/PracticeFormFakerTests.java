package tests;

import data.TestData;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationComponent;

import static data.TestData.*;

@Epic("Demoqa")
@Feature("Header")
@Story("Regress")
@Owner("Karen")
@Severity(SeverityLevel.NORMAL)

@DisplayName("Форма регистрации студента")
public class PracticeFormFakerTests extends TestBase {

    private RegistrationPage registrationPage;
    private CheckResultRegistrationComponent checkResultRegistration;
    private TestData testData;

    @BeforeEach
    @Step("Открываем страницу и проверяем заголовок")
    public void setUp() {
        registrationPage = RegistrationPage.openPage();
        testData = new TestData();
        checkResultRegistration = CheckResultRegistrationComponent.checkMainPage(PracticeForm);
    }

    @Test
    @Tag("Web")
    @Story("Позитивный тест")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация с заполнением всех полей и проверка")

    void fillFullPracticeFormTest() {

        registrationPage.deleteElement()
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

        checkResultRegistration
                .checkResult(checkName, testData.fullName)
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
    @Tag("Web")
    @Story("Позитивный тест")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Регистрация с заполнением обязательных полей и проверка")

    void fillMinimumPracticeFormTest() {
        registrationPage.deleteElement()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .setSubmit();

        checkResultRegistration
                .checkResult(checkName, testData.fullName)
                .checkResult(checkGender, testData.gender)
                .checkResult(checkMobile, testData.phone)
        ;
    }

    @Test
    @Tag("NEGATIVE")
    @Story("Негативный тест")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Попытка регистрации с пустыми обязательными полями")

    void fillPracticeFormNegTest() {
        registrationPage.deleteElement()
                .setFirstName("")
                .setLastName("")
                .setEmail("1234")
                .setNumber("999")
                .setSubmit();

        checkResultRegistration.checkValidation();
    }
}