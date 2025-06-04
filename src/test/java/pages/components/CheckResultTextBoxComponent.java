package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckResultTextBoxComponent {

    private final SelenideElement nameInput = $("#output #name"),
            emailInput = $("#output #email"),
            currentAddress = $("#output #currentAddress"),
            permanentAddress = $("#output #permanentAddress")
                    ;

    public CheckResultTextBoxComponent checkResultName(String value) {
        nameInput.shouldHave(text(value));

        return this;
    }

    public CheckResultTextBoxComponent checkResultEmail(String value) {
        emailInput.shouldHave(text(value));

        return this;
    }

    public CheckResultTextBoxComponent checkResultCurrentAddress(String value) {
        currentAddress.shouldHave(text (value));

        return this;
    }

    public void checkResultPermanentAddress(String value) {
        permanentAddress.shouldHave(text (value));
    }
}
