package demo_qa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FillingFormComponent {
    private static SelenideElement titleForm = $("#example-modal-sizes-title-lg"),
    tableForm = $(".table-responsive");

    public static void assertTitle(String titleText) {
        titleForm.shouldHave(text(titleText));
    }

    public static void verifyResult(String value) {
        tableForm.shouldHave(text(value));
    }
}