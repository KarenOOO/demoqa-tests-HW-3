package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultRegistrationComponent {

    public static SelenideElement checkStudentRegistration = $(".table-responsive"),
            checkUserForm = $("#userForm");

    public CheckResultRegistrationComponent checkResult(String key, String value) {
        checkStudentRegistration.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public CheckResultRegistrationComponent checkValidation() {
        checkUserForm.$(".was-validated");

        return this;
    }
}
