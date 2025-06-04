package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckResultRegistrationComponent {

    private final SelenideElement checkStudentRegistration = $(".table-responsive"),
            checkUserForm = $("#userForm");

    public CheckResultRegistrationComponent checkResult(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public void checkValidation() {
        checkUserForm.shouldHave(cssClass("was-validated"));
    }
}
