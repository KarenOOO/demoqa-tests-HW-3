package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private SelenideElement
            nameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage setName(String value) {
        nameInput.setValue(value);

        return this;
    }

    public TextBoxPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    public TextBoxPage setSubmit() {
        submitButton.click();

        return this;
    }
}
