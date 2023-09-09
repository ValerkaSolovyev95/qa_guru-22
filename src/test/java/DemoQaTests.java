import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTests {
    private static final String URL_DEMO_QA = "https://demoqa.com/automation-practice-form";
    public static final String USER_NAME = "Валерий";
    public static final String USER_LAST_NAME = "Соловьев";
    public static final String USER_EMAIL = "val241423@gmail.com";
    public static final String USER_PHONE = "9103647859";
    public static final String DEFAULT_MONTH = "November";
    public static final String DEFAULT_YEAR = "1995";
    public static final String DEFAULT_ADDRESS = "Красная площадь, 1";
    public static final String DEFAULT_SEX = "Male";
    public static final String DEFAULT_SUBJECT = "English";
    public static final String DEFAULT_PICTURE = "msk.jpg";
    public static final String DEFAULT_STATE = "NCR";
    public static final String DEFAULT_CITY = "Delhi";
    public static final String TITLE_TEXT = "Thanks for submitting the form";

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
        open(URL_DEMO_QA);
    }

    @Test
    void fieldsCheckTest() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue(USER_NAME);
        $("#lastName").setValue(USER_LAST_NAME);
        $("#userEmail").setValue(USER_EMAIL);
        $(By.xpath("//*[contains(text(),'Male')]")).click();
        $("#userNumber").setValue(USER_PHONE);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(DEFAULT_MONTH);
        $(".react-datepicker__year-select").selectOption(DEFAULT_YEAR);
        $(".react-datepicker__day--027").click();
        $("#subjectsInput")
                .setValue("e")
                .pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("msk.jpg");
        $("#currentAddress").setValue(DEFAULT_ADDRESS);
        $("#state").click();
        $("#react-select-3-input")
                .setValue(DEFAULT_STATE)
                .pressEnter();
        $("#city").click();
        $("#react-select-4-input")
                .setValue(DEFAULT_CITY)
                .pressEnter();
        executeJavaScript("document.getElementById('submit').click()");
        $("#example-modal-sizes-title-lg").shouldHave(text(TITLE_TEXT));
        $(".table-responsive").shouldHave(
                text(String.format("%s %s", USER_NAME, USER_LAST_NAME)),
                text(USER_EMAIL),
                text(DEFAULT_SEX),
                text(USER_PHONE),
                text(DEFAULT_SUBJECT),
                text(DEFAULT_PICTURE),
                text(DEFAULT_ADDRESS),
                text(String.format("%s %S", DEFAULT_STATE, DEFAULT_CITY))
        );
        executeJavaScript("document.getElementById('closeLargeModal').click()");
    }

}
