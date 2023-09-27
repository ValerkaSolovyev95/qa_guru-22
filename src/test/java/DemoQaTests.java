import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.StudentsRegistrationFormPage;


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
    private static final String DEFAULT_DAY = "27";
    public static final String SUBJECT_FIRST_LATTER = "e";
    public static final String FILE_NAME = "msk.jpg";
    StudentsRegistrationFormPage studentsRegistrationFormPage = new StudentsRegistrationFormPage();

    @BeforeEach
    void setUp() {
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fieldsCheckTest() {
        studentsRegistrationFormPage.openPage(URL_DEMO_QA)
                .setFirstName(USER_NAME)
                .setLastName(USER_LAST_NAME)
                .setEmail(USER_EMAIL)
                .choiceGender()
                .setPhone(USER_PHONE)
                .setCalendar(DEFAULT_MONTH, DEFAULT_YEAR, DEFAULT_DAY)
                .choiceSubject(SUBJECT_FIRST_LATTER)
                .choiceHobby()
                .uploadPhoto(FILE_NAME)
                .setCurrentAddress(DEFAULT_ADDRESS)
                .setState(DEFAULT_STATE)
                .setCity(DEFAULT_CITY)
                .submitButtonClick()
                .assertionsForm(
                        TITLE_TEXT,
                        USER_NAME,
                        USER_LAST_NAME,
                        USER_EMAIL,
                        DEFAULT_SEX,
                        USER_PHONE,
                        DEFAULT_SUBJECT,
                        DEFAULT_PICTURE,
                        DEFAULT_ADDRESS,
                        DEFAULT_STATE,
                        DEFAULT_CITY
                        )
                .closeButtonClick();
    }

    @Test
    void checkMandatoryFields() {
        studentsRegistrationFormPage.openPage(URL_DEMO_QA)
                .setFirstName(USER_NAME)
                .setLastName(USER_LAST_NAME)
                .setEmail(USER_EMAIL)
                .choiceGender()
                .setPhone(USER_PHONE)
                .submitButtonClick()
                .assertionTitleForm(TITLE_TEXT);
    }
}
