package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckResultRegistrationComponent {


    private final SelenideElement
            checkStudentRegistration = $(".table-responsive"),
            checkUserForm = $("#userForm");
    private static final SelenideElement checkPracticeForm = $(".practice-form-wrapper");

    @Step("Проверка заголовка формы регистрации")
    public static CheckResultRegistrationComponent checkMainPage(String value) {
        checkPracticeForm.shouldHave(text(value));

        return new CheckResultRegistrationComponent();
    }

    @Step("Проверка введенного имени и фамилия")
    public CheckResultRegistrationComponent checkResultFullName(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка введенной почты")
    public CheckResultRegistrationComponent checkResultEmail(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка выбранного пола")
    public CheckResultRegistrationComponent checkResultGender(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка введенного номера телефона")
    public CheckResultRegistrationComponent checkResultMobile(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка введенной даты рождения")
    public CheckResultRegistrationComponent checkResultDateOfBirth(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка выбранного предмета")
    public CheckResultRegistrationComponent checkResultSubjects(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка выбранного хобби")
    public CheckResultRegistrationComponent checkResultHobbies(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка загруженной картинки")
    public CheckResultRegistrationComponent checkResultPicture(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка введенного адреса")
    public CheckResultRegistrationComponent checkResultAddress(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка выбранного штата и города")
    public CheckResultRegistrationComponent checkResultStateAndCity(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка валидации обязательных полей")
    public void checkValidation() {
        checkUserForm.shouldHave(cssClass("was-validated"));
    }
}
