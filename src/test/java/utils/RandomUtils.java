package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

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
        return String.valueOf(getRandomInt(fromYear, toYear));
    }

    public String getState() {
        String[] array = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(array);
    }

    public String getCity(String state) {
        return switch (state) {
            case ("NCR") -> {
                String[] arrayNCR = {"Delhi", "Gurgaon", "Noida"};
                yield faker.options().option(arrayNCR);
            }
            case ("Uttar Pradesh") -> {
                String[] arrayUttar = {"Agra", "Lucknow", "Merrut"};
                yield faker.options().option(arrayUttar);
            }
            case ("Haryana") -> {
                String[] arrayHaryana = {"Karnal", "Panipat"};
                yield faker.options().option(arrayHaryana);
            }
            case ("Rajasthan") -> {
                String[] arrayRajasthan = {"Jaipur", "Jaiselmer"};
                yield faker.options().option(arrayRajasthan);
            }
            default -> "No found";
        };
    }

    public String getDay() {
        int dateDay = getRandomInt(1, 28);
        return String.valueOf(dateDay).length() < 2 ? String.format("0%s", dateDay) : String.format("%s", dateDay);
    }
}
