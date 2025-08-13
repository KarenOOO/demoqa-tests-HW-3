package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            selectState = $("#state"),
            selectCity = $("#city"),
            submitButton = $("#submit")
    ;

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Переходим на форму регистрации студента")
    public static RegistrationPage openPage() {
        open("automation-practice-form");

        return new RegistrationPage();
    }

    @Step("Удаляем банеры на странице")
    public RegistrationPage deleteElement() {
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Заполняем поле имя")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем поле фамилия")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем поле почта")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Указываем пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    @Step("Указываем номер телефона")
    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    @Step("Заполняем дату рождения")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Заполняем поле хобби")
    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    @Step("Загружаем изображение")
    public RegistrationPage setUploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("Указываем любимый предмет")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Заполняем поле адресс")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    @Step("Заполняем поле штат")
    public RegistrationPage setSelectState(String value) {
        selectState.click();
        selectState.$(byText(value)).click();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage setSelectCity(String value) {
        selectCity.click();
        selectCity.$(byText(value)).click();

        return this;
    }

    @Step("Отправляем анкету")
    public void setSubmit() {
        submitButton.click();
    }
}
