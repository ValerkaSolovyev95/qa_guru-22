import utils.RandomUtils;

public class UserTestData {
    public RandomUtils userData = new RandomUtils();
    public static final String AUTOMATION_PRACTICE_FORM = "automation-practice-form";
    public String firstName = userData.faker.name().firstName();
    public String lastName = userData.faker.name().lastName();
    public String emailAddress = userData.faker.internet().emailAddress();
    public String phoneNumber = userData.getPhoneNumber();
    public String userDataMonth = userData.getMonth();
    public String dataYear = userData.getYear(1980, 2000);
    public String fullAddress = userData.faker.address().fullAddress();
    public String defaultSubject = "English";
    public String userDataState = userData.getState();
    public String userDataCity = userData.getCity(userDataState);
    public static final String TITLE_TEXT = "Thanks for submitting the form";
    public String dataDay = userData.getDay();
    public static String subjectFirstLatter = "e";
    public String image = "msk.jpg";
    public String hobby = userData.getHobby();
    public String gender = userData.getGender();
}
