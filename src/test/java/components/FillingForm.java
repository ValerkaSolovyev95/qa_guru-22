package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FillingForm {
    private static SelenideElement titleForm = $("#example-modal-sizes-title-lg"),
    tableForm = $(".table-responsive");

    public static void assertTitle(String titleText) {
        titleForm.shouldHave(text(titleText));
    }

    public static void assertTable(
            String userName,
            String userLastName,
            String userEmail,
            String userSex,
            String userPhone,
            String userSubject,
            String userPhoto,
            String userAddress,
            String userState,
            String userCity
    ) {
        tableForm.shouldHave(text(String.format("%s %s", userName, userLastName)));
        tableForm.shouldHave(text(userEmail));
        tableForm.shouldHave(text(userSex));
        tableForm.shouldHave(text(userPhone));
        tableForm.shouldHave(text(userSubject));
        tableForm.shouldHave(text(userPhoto));
        tableForm.shouldHave(text(userAddress));
        tableForm.shouldHave(text(String.format("%s %S", userState, userCity)));
    }
}