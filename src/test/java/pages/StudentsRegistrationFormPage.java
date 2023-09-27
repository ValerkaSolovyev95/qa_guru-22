package pages;

import com.codeborne.selenide.SelenideElement;
import components.Calendar;
import components.FillingForm;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;


public class StudentsRegistrationFormPage extends BasePage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $x("//*[contains(text(),'Male')]"),
            phoneInput = $("#userNumber"),
            dateOfBirth = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesCheckBox = $("label[for='hobbies-checkbox-2']"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateField = $("#state"),
            stateFieldSelect = $("#react-select-3-input"),
            cityField = $("#city"),
            cityFieldSelect = $("#react-select-4-input");
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

    public StudentsRegistrationFormPage choiceGender() {
        gender.click();
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

    public StudentsRegistrationFormPage choiceSubject(String subjectFirstLatter) {
        subjectInput.setValue(subjectFirstLatter)
                .pressEnter();
        return this;
    }

    public StudentsRegistrationFormPage choiceHobby() {
        hobbiesCheckBox.click();
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
        stateFieldSelect
                .setValue(state)
                .pressEnter();
        return this;
    }

    public StudentsRegistrationFormPage setCity(String city) {
        cityField.click();
        cityFieldSelect
                .setValue(city)
                .pressEnter();
        return this;
    }

    public StudentsRegistrationFormPage submitButtonClick() {
        executeJavaScript("document.getElementById('submit').click()");
        return this;
    }

    public StudentsRegistrationFormPage closeButtonClick() {
        executeJavaScript("document.getElementById('closeLargeModal').click()");
        return this;
    }

    public StudentsRegistrationFormPage assertionsForm(
            String title,
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
        FillingForm.assertTitle(title);
        FillingForm.assertTable(
                userName,
                userLastName,
                userEmail,
                userSex,
                userPhone,
                userSubject,
                userPhoto,
                userAddress,
                userState,
                userCity
        );
        return this;
    }

    public StudentsRegistrationFormPage assertionTitleForm(String titleText) {
        FillingForm.assertTitle(titleText);
        return this;
    }

}
