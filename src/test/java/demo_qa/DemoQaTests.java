package demo_qa;

import org.junit.jupiter.api.Test;
import demo_qa.pages.StudentsRegistrationFormPage;

import static demo_qa.pages.components.FillingFormComponent.assertTitle;
import static demo_qa.pages.components.FillingFormComponent.verifyResult;

class DemoQaTests extends BaseTest{
    StudentsRegistrationFormPage studentsRegistrationFormPage = new StudentsRegistrationFormPage();

    @Test
    void fieldsCheckTest() {
        UserTestData userTestData = new UserTestData();
        studentsRegistrationFormPage.openPage(UserTestData.AUTOMATION_PRACTICE_FORM)
                .setFirstName(userTestData.firstName)
                .setLastName(userTestData.lastName)
                .setEmail(userTestData.emailAddress)
                .selectGender(userTestData.gender)
                .setPhone(userTestData.phoneNumber)
                .setCalendar(userTestData.userDataMonth, userTestData.dataYear, userTestData.dataDay)
                .selectSubject(UserTestData.subjectFirstLatter)
                .selectHobby(userTestData.hobby)
                .uploadPhoto(userTestData.image)
                .setCurrentAddress(userTestData.fullAddress)
                .setState(userTestData.userDataState)
                .setCity(userTestData.userDataCity)
                .submitButtonClick();
        verifyResult(userTestData.firstName);
        verifyResult(userTestData.lastName);
        verifyResult(userTestData.emailAddress);
        verifyResult(userTestData.gender);
        verifyResult(userTestData.phoneNumber);
        verifyResult(userTestData.defaultSubject);
        verifyResult(userTestData.image);
        verifyResult(userTestData.fullAddress);
        verifyResult(userTestData.userDataState);
        verifyResult(userTestData.userDataCity);
    }

    @Test
    void checkMandatoryFields() {
        UserTestData userTestData = new UserTestData();
        studentsRegistrationFormPage.openPage(UserTestData.AUTOMATION_PRACTICE_FORM)
                .setFirstName(userTestData.firstName)
                .setLastName(userTestData.lastName)
                .setEmail(userTestData.emailAddress)
                .selectGender(userTestData.gender)
                .setPhone(userTestData.phoneNumber)
                .submitButtonClick();
        assertTitle(UserTestData.TITLE_TEXT);
    }
}
