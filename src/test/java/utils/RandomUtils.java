package utils;

import com.github.javafaker.Faker;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;

public class RandomUtils {

    static String[] img = {"FileForTests.jpg", "dog.jpg", "cat.jpg"};
    static String[] gender = {"Male", "Female", "Other"};
    static String[] subjects = {"Maths", "Economics", "Arts"};
    static String[] hobbies = {"Sports", "Reading", "Music"};
    static String[] NCR = {"Delhi", "Gurgaon", "Noida"};
    static String[] UttarPradesh = {"Agra", "Lucknow", "Merrut"};
    static String[] Haryana = {"Karnal", "Panipat"};
    static String[] Rajasthan = {"Jaipur", "Jaiselmer"};

    static Faker faker = new Faker();

    static Date randomDate = faker.date().birthday();
    static LocalDate localDate = randomDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    public final String getFirstName = faker.name().firstName();
    public final String getLastName = faker.name().lastName();
    public final String getFullName = getFirstName + " " + getLastName;

    public final String getEmail = faker.internet().emailAddress();
    public final String getGender = faker.options().option(gender);
    public final String getNumber = faker.numerify("##########");
    public final String getCurrentAddress = faker.address().streetAddress();
    public final String getSubjects = faker.options().option(subjects);

    public final String getYear = localDate.format(DateTimeFormatter.ofPattern("yyyy"));
    public final String getMonth = localDate.format(DateTimeFormatter.ofPattern("MMMM", new Locale("en")));
    public final String getDay = localDate.format(DateTimeFormatter.ofPattern("d"));
    public final String getDateOfBirth = getDay + " " + getMonth + "," + getYear;

    public final String getHobbies = faker.options().option(hobbies);
    public final String getImg = faker.options().option(img);

    public final String getSelectState = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public final String getSelectCity = switch (getSelectState) {
        case "NCR" -> faker.options().option(NCR);
        case "Uttar Pradesh" -> faker.options().option(UttarPradesh);
        case "Haryana" -> faker.options().option(Haryana);
        case "Rajasthan" -> faker.options().option(Rajasthan);
        default -> "Delhi";
    };
    public final String getStateAndCity = getSelectState + " " + getSelectCity;
}