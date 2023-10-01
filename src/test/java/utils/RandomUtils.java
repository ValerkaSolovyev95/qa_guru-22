package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static int getRandomInt(int min , int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getGender() {
        String[] array = {"Male", "Female", "Other"};
        return array[getRandomInt(0, array.length - 1)];
    }

    public String getHobby() {
        String[] array = {"Sports", "Reading", "Music"};
        return array[getRandomInt(0, array.length - 1)];
    }

    public String getPhoneNumber() {
        return String.format("%s%s%s", getRandomInt(900, 999), getRandomInt(111, 999), getRandomInt(1111, 9999));
    }

    public String getMonth() {
        String[] array = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"};
        return array[getRandomInt(0, array.length - 1)];
    }

    public String getYear(int fromYear, int toYear) {
        return String.valueOf(getRandomInt(fromYear, toYear));
    }

    public String getState() {
        String[] array = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return array[getRandomInt(0, array.length - 1)];
    }

    public String getCity(String state) {
        return switch (state) {
            case ("NCR") -> {
                String[] arrayNCR = {"Delhi", "Gurgaon", "Noida"};
                yield arrayNCR[getRandomInt(0, arrayNCR.length - 1)];
            }
            case ("Uttar Pradesh") -> {
                String[] arrayUttar = {"Agra", "Lucknow", "Merrut"};
                yield arrayUttar[getRandomInt(0, arrayUttar.length - 1)];
            }
            case ("Haryana") -> {
                String[] arrayHaryana = {"Karnal", "Panipat"};
                yield arrayHaryana[getRandomInt(0, arrayHaryana.length - 1)];
            }
            case ("Rajasthan") -> {
                String[] arrayRajasthan = {"Jaipur", "Jaiselmer"};
                yield arrayRajasthan[getRandomInt(0, arrayRajasthan.length - 1)];
            }
            default -> "No found";
        };
    }

    public String getDay() {
        int dateDay = getRandomInt(1, 28);
        return String.valueOf(dateDay).length() < 2 ? String.format("0%s", dateDay) : String.format("%s", dateDay);
    }
}
