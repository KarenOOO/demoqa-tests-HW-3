import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 5 sec
    }

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Иванов");
        $("#userEmail").setValue("1234@bk.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9993434333");
        $("#dateOfBirthInput")
                .sendKeys(Keys.chord(Keys.CONTROL, "a"),
                        "30 May 1998", Keys.ENTER);
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("FileForTests.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#state").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#city").$(byText("Lucknow")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name"), text("Иван Иванов"));
        $(".table-responsive").shouldHave(text("Student Email"), text("1234@bk.ru"));
        $(".table-responsive").shouldHave(text("Gender"), text("Male"));
        $(".table-responsive").shouldHave(text("Mobile"), text("9993434333"));
        $(".table-responsive").shouldHave(text("Date of Birth"), text("30 May,1998"));
        $(".table-responsive").shouldHave(text("Subjects"), text("Maths"));
        $(".table-responsive").shouldHave(text("Hobbies"), text("Sports"));
        $(".table-responsive").shouldHave(text("Picture"), text("FileForTests.jpg"));
        $(".table-responsive").shouldHave(text("Address"), text("Some street 1"));
        $(".table-responsive").shouldHave(text("State and City"), text("Uttar Pradesh Lucknow"));
    }
}