package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class Calendar {
    SelenideElement monthSelect = $(".react-datepicker__month-select"),
    yearSelect = $(".react-datepicker__year-select");

    public void setupCalendar(String month, String year, String day) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);
        String selector = String.format(".react-datepicker__day--0%s",day);
        $(selector).click();
    }
}
