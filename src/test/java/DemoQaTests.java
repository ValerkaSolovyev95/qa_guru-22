import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.StudentsRegistrationFormPage;
import utils.RandomUtils;

import static pages.components.FillingForm.assertTitle;
import static pages.components.FillingForm.verifyResult;

public class DemoQaTests extends BaseTest{
    private static final RandomUtils userData = new RandomUtils();
    private static final Faker faker = new Faker();
    private static final String URL_DEMO_QA = "automation-practice-form";
    public static final String USER_NAME = faker.name().firstName();
    public static final String USER_LAST_NAME = faker.name().lastName();
    public static final String USER_EMAIL = faker.internet().emailAddress();
    public static final String USER_PHONE = userData.getPhoneNumber();
    public static final String DEFAULT_MONTH = userData.getMonth();
    public static final String DEFAULT_YEAR = userData.getYear(1980, 2000);
    public static final String DEFAULT_ADDRESS = faker.address().fullAddress();
    public static final String DEFAULT_SUBJECT = "English";
    public static final String DEFAULT_PICTURE = "msk.jpg";
    public static final String DEFAULT_STATE = userData.getState();
    public static final String DEFAULT_CITY = userData.getCity(DEFAULT_STATE);
    public static final String TITLE_TEXT = "Thanks for submitting the form";
    private static final String DEFAULT_DAY = userData.getDay();
    public static final String SUBJECT_FIRST_LATTER = "e";
    public static final String FILE_NAME = "msk.jpg";
    public static final String DEFAULT_GENDER = userData.getGender();
    StudentsRegistrationFormPage studentsRegistrationFormPage = new StudentsRegistrationFormPage();

    @Test
    void fieldsCheckTest() {
        studentsRegistrationFormPage.openPage(URL_DEMO_QA)
                .setFirstName(USER_NAME)
                .setLastName(USER_LAST_NAME)
                .setEmail(USER_EMAIL)
                .selectGender(DEFAULT_GENDER)
                .setPhone(USER_PHONE)
                .setCalendar(DEFAULT_MONTH, DEFAULT_YEAR, DEFAULT_DAY)
                .selectSubject(SUBJECT_FIRST_LATTER)
                .selectHobby(userData.getHobby())
                .uploadPhoto(FILE_NAME)
                .setCurrentAddress(DEFAULT_ADDRESS)
                .setState(DEFAULT_STATE)
                .setCity(DEFAULT_CITY)
                .submitButtonClick();
        verifyResult(USER_NAME);
        verifyResult(USER_LAST_NAME);
        verifyResult(USER_EMAIL);
        verifyResult(DEFAULT_GENDER);
        verifyResult(USER_PHONE);
        verifyResult(DEFAULT_SUBJECT);
        verifyResult(DEFAULT_PICTURE);
        verifyResult(DEFAULT_ADDRESS);
        verifyResult(DEFAULT_STATE);
        verifyResult(DEFAULT_CITY);
    }

    @Test
    void checkMandatoryFields() {
        studentsRegistrationFormPage.openPage(URL_DEMO_QA)
                .setFirstName(USER_NAME)
                .setLastName(USER_LAST_NAME)
                .setEmail(USER_EMAIL)
                .selectGender(DEFAULT_GENDER)
                .setPhone(USER_PHONE)
                .submitButtonClick();
        assertTitle(TITLE_TEXT);
    }
}
