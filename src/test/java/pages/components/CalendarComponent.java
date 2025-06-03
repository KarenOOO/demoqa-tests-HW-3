package pages.components;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CalendarComponent {

    private final SelenideElement monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select")
                    ;

    private final ElementsCollection dayOfBirth =
            $$( ".react-datepicker__day:not(.react-datepicker__day--outside-month)" );

    public void setDate(String day, String month, String year) {
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption(year);
        dayOfBirth.findBy(exactText(day)).click();
    }
}
