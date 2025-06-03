package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationComponent;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultRegistrationComponent checkResultRegistration = new CheckResultRegistrationComponent();

    @Test
    void fillFullPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setEmail("1234@bk.ru")
                .setGender("Male")
                .setNumber("9993434333")
                .setDateOfBirth("27", "April", "1998")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setUploadPicture("FileForTests.jpg")
                .setCurrentAddress("Some street 1")
                .setSelectState("Uttar Pradesh")
                .setSelectCity("Lucknow")
                .setSubmit();

        checkResultRegistration.checkResult("Student Name", "Иван Иванов")
                .checkResult("Student Email", "1234@bk.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9993434333")
                .checkResult("Date of Birth", "27 April,1998")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "FileForTests.jpg")
                .checkResult("Address", "Some street 1")
                .checkResult("State and City", "Uttar Pradesh Lucknow");
    }

    @Test
    void fillMinimumPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setGender("Male")
                .setNumber("9993434333")
                .setSubmit();

        checkResultRegistration.checkResult("Student Name", "Иван Иванов")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9993434333")
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