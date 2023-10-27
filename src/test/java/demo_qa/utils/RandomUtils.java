package demo_qa.utils;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomUtils {
    public static Faker faker = new Faker();

    public String getGender() {
        String[] array = {"Male", "Female", "Other"};
        return faker.options().option(array);
    }

    public String getHobby() {
        String[] array = {"Sports", "Reading", "Music"};
        return faker.options().option(array);
    }

    public String getPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getMonth() {
        String[] array = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        return faker.options().option(array);
    }

    public String getYear(int fromYear, int toYear) {
        return String.valueOf(faker.number().numberBetween(fromYear, toYear));
    }

    public String getState() {
        String[] array = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(array);
    }

    public static String getCity(String state) {
        String[] arrayNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] arrayUttar = {"Agra", "Lucknow", "Merrut"};
        String[] arrayHaryana = {"Karnal", "Panipat"};
        String[] arrayRajasthan = {"Jaipur", "Jaiselmer"};
        Map<String, String[]> cityMap = new HashMap<>();
        cityMap.put("NCR", arrayNCR);
        cityMap.put("Uttar Pradesh", arrayUttar);
        cityMap.put("Haryana", arrayHaryana);
        cityMap.put("Rajasthan", arrayRajasthan);
        return faker.options().option(cityMap.get(state));
    }

    public String getDay() {
        int dateDay = faker.number().numberBetween(1, 28);
        return String.valueOf(dateDay).length() < 2 ? String.format("0%s", dateDay) : String.format("%s", dateDay);
    }
}
