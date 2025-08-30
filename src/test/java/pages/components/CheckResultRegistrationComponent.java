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
    public CheckResultRegistrationComponent checkResult(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    @Step("Проверка валидации обязательных полей")
    public void checkValidation() {
        checkUserForm.shouldHave(cssClass("was-validated"));
    }
}
