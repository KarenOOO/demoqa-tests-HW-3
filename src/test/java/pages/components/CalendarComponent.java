package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public static SelenideElement monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select"),
            dayOfBirth = $(".react-datepicker__day--027:not(.react-datepicker__day--outside-month)")
                    ;

    public void setDate(String day, String month, String year) {
        monthOfBirth.selectOption("April");
        yearOfBirth.selectOption("1998");
        dayOfBirth.click();
    }
}
