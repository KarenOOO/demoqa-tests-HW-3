package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultTextBoxComponent {

    public static SelenideElement nameInput = $("#output #name"),
            emailInput = $("#output #email"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress")
                    ;

    public CheckResultTextBoxComponent checkResultName(String value) {
        nameInput.$(byText(value));

        return this;
    }

    public CheckResultTextBoxComponent checkResultEmail(String value) {
        emailInput.$(byText(value));

        return this;
    }

    public CheckResultTextBoxComponent checkResultCurrentAddress(String value) {
        currentAddress.$(byText(value));

        return this;
    }

    public CheckResultTextBoxComponent checkResultPermanentAddress(String value) {
        permanentAddress.$(byText(value));

        return this;
    }
}
