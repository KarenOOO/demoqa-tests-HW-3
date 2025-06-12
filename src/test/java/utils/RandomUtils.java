package utils;

import com.github.javafaker.Faker;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;

public class RandomUtils {

    private static final Faker faker = new Faker();

    private static final String[] img = {"FileForTests.jpg", "dog.jpg", "cat.jpg"};
    private static final String[] gender = {"Male", "Female", "Other"};
    private static final String[] subjects = {"Maths", "Economics", "Arts"};
    private static final String[] hobbies = {"Sports", "Reading", "Music"};
    private static final String[] NCR = {"Delhi", "Gurgaon", "Noida"};
    private static final String[] UttarPradesh = {"Agra", "Lucknow", "Merrut"};
    private static final String[] Haryana = {"Karnal", "Panipat"};
    private static final String[] Rajasthan = {"Jaipur", "Jaiselmer"};

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        return faker.options().option(gender);
    }

    public static String getPhoneNumber() {
        return faker.numerify("##########");
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    public static String getSubject() {
        return faker.options().option(subjects);
    }

    public static String getHobby() {
        return faker.options().option(hobbies);
    }

    public static String getImageName() {
        return faker.options().option(img);
    }

    public static LocalDate getRandomBirthday() {
        return faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String getBirthDay(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("d"));
    }

    public static String getBirthMonth(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMMM", new Locale("en")));
    }

    public static String getBirthYear(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy"));
    }

    public static String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option(NCR);
            case "Uttar Pradesh" -> faker.options().option(UttarPradesh);
            case "Haryana" -> faker.options().option(Haryana);
            case "Rajasthan" -> faker.options().option(Rajasthan);
            default -> "Delhi";
        };
    }
}