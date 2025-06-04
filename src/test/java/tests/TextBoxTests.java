package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.CheckResultTextBoxComponent;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    CheckResultTextBoxComponent CheckResultTextBox = new CheckResultTextBoxComponent();

    @Test
    void fillFullPracticeFormTest() {
        textBoxPage.openPage()
                .setName("Иван")
                .setEmail("1234@bk.ru")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .setSubmit()
                ;

        CheckResultTextBox.checkResultName("Иван")
                .checkResultEmail("1234@bk.ru")
                .checkResultCurrentAddress("Some street 1")
                .checkResultPermanentAddress("Another street 1");
    }
}