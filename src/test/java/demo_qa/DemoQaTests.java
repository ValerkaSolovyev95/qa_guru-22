package demo_qa;

import org.junit.jupiter.api.Test;
import demo_qa.pages.StudentsRegistrationFormPage;

import static demo_qa.pages.components.FillingFormComponent.assertTitle;
import static demo_qa.pages.components.FillingFormComponent.verifyResult;
import static io.qameta.allure.Allure.step;

class DemoQaTests extends BaseTest {
    StudentsRegistrationFormPage studentsRegistrationFormPage = new StudentsRegistrationFormPage();
    UserTestData userTestData;

    @Test
    void fieldsCheckTest() {
        step("Подготовить данные студента", () -> userTestData = new UserTestData());
        step("Открыть страницу с формой регистрации", () -> studentsRegistrationFormPage.openPage(
                        UserTestData.AUTOMATION_PRACTICE_FORM
                )
        );
        step("Заполнить поле имя студента", () -> studentsRegistrationFormPage.setFirstName(
                        userTestData.firstName
                )
        );
        step("Заполнить поле фамилия студента", () -> studentsRegistrationFormPage.setLastName(
                        userTestData.lastName
                )
        );
        step("Заполнить поле email студента", () -> studentsRegistrationFormPage.setEmail(
                        userTestData.emailAddress
                )
        );
        step("Установить пол студента", () -> studentsRegistrationFormPage.selectGender(userTestData.gender));
        step("Заполнить поле телефон студента", () -> studentsRegistrationFormPage.setPhone(
                        userTestData.phoneNumber
                )
        );
        step("Установить значение календаря", () -> studentsRegistrationFormPage.setCalendar(
                        userTestData.userDataMonth,
                        userTestData.dataYear,
                        userTestData.dataDay
                )
        );
        step("Выбрать образовательный предмет", () -> studentsRegistrationFormPage.selectSubject(
                        UserTestData.subjectFirstLatter
                )
        );
        step("Выбрать хобби", () -> studentsRegistrationFormPage.selectHobby(userTestData.hobby));
        step("Загрузить фото", () -> studentsRegistrationFormPage.uploadPhoto(userTestData.image));
        step("Заполнить адрес", () -> studentsRegistrationFormPage.setCurrentAddress(userTestData.fullAddress));
        step("Выбрать штат", () -> studentsRegistrationFormPage.setState(userTestData.userDataState));
        step("Выбрать город", () -> studentsRegistrationFormPage.setCity(userTestData.userDataCity));
        step("Нажать на кнопку подтверждения регистрации", () -> studentsRegistrationFormPage.submitButtonClick());
        step("Поверить в форме имя студента", () -> verifyResult(userTestData.firstName));
        step("Поверить в форме фамилию студента", () -> verifyResult(userTestData.lastName));
        step("Поверить в форме email студента", () -> verifyResult(userTestData.emailAddress));
        step("Поверить в форме пол студента", () -> verifyResult(userTestData.gender));
        step("Поверить в форме номер телефона студента", () -> verifyResult(userTestData.phoneNumber));
        step("Поверить в форме образовательный предмет студента", () -> verifyResult(userTestData.defaultSubject));
        step("Поверить в форме фотографию студента", () -> verifyResult(userTestData.image));
        step("Поверить в форме адрес студента", () -> verifyResult(userTestData.fullAddress));
        step("Поверить в форме штат студента", () -> verifyResult(userTestData.userDataState));
        step("Поверить в форме город студента", () -> verifyResult(userTestData.userDataCity));
    }

    @Test
    void checkMandatoryFields() {
        step("Подготовить данные студента", () -> userTestData = new UserTestData());
        step("Открыть страницу с формой регистрации", () -> studentsRegistrationFormPage.openPage(
                        UserTestData.AUTOMATION_PRACTICE_FORM
                )
        );
        step("Заполнить поле имя студента", () -> studentsRegistrationFormPage.setFirstName(
                        userTestData.firstName
                )
        );
        step("Заполнить поле фамилия студента", () -> studentsRegistrationFormPage.setLastName(
                        userTestData.lastName
                )
        );
        step("Заполнить поле email студента", () -> studentsRegistrationFormPage.setEmail(
                        userTestData.emailAddress
                )
        );
        step("Установить пол студента", () -> studentsRegistrationFormPage.selectGender(userTestData.gender));
        step("Заполнить поле телефон студента", () -> studentsRegistrationFormPage.setPhone(
                        userTestData.phoneNumber
                )
        );
        step("Нажать на кнопку подтверждения регистрации", () -> studentsRegistrationFormPage.submitButtonClick());
        step("Проверить что в заголовок имеет текст \"Thanks for submitting the form\"", () -> assertTitle(
                        UserTestData.TITLE_TEXT
                )
        );
    }
}
