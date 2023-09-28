package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.FillingForm;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class StudentsRegistrationFormPage extends BasePage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateField = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            cityField = $("#city"),
            submitButton = $("#submit"),
            hobbiesWrapper = $("#hobbiesWrapper");

    private Calendar calendar = new Calendar();
    private FillingForm fillingForm = new FillingForm();

    public StudentsRegistrationFormPage openPage(String url) {
        open(url);
        removeBanner();
        return this;
    }

    public StudentsRegistrationFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public StudentsRegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public StudentsRegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public StudentsRegistrationFormPage selectGender(String gender) {
        $x(String.format("//*[contains(text(),'%s')]", gender)).click();
        return this;
    }

    public StudentsRegistrationFormPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public StudentsRegistrationFormPage setCalendar(String month, String year, String day) {
        dateOfBirth.click();
        calendar.setupCalendar(month, year, day);
        return this;
    }

    public StudentsRegistrationFormPage selectSubject(String subjectFirstLatter) {
        subjectInput.setValue(subjectFirstLatter)
                .pressEnter();
        return this;
    }

    public StudentsRegistrationFormPage uploadPhoto(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public StudentsRegistrationFormPage setCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public StudentsRegistrationFormPage setState(String state) {
        stateField.click();
        stateCityWrapper.$(byText(state)).click();
        return this;
    }

    public StudentsRegistrationFormPage setCity(String city) {
        cityField.click();
        stateCityWrapper.$(byText(city)).click();
        return this;
    }

    public StudentsRegistrationFormPage submitButtonClick() {
        submitButton.click();
        return this;
    }

    public StudentsRegistrationFormPage closeButtonClick() {
        executeJavaScript("document.getElementById('closeLargeModal').click()");
        return this;
    }

    public StudentsRegistrationFormPage selectHobby(String hobby) {
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }
}
