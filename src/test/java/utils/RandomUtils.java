package utils;

import com.github.javafaker.Faker;
import java.time.format.DateTimeFormatter;
import java.time.*;
import java.util.*;

public class RandomUtils {

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

    public static String getFirstName = faker.name().firstName();
    public static String getLastName = faker.name().lastName();
    public static String getFullName = getFirstName + " " + getLastName;

    public static String getEmail = faker.internet().emailAddress();
    public static String getGender = faker.options().option(gender);
    public static String getNumber = faker.numerify("##########");
    public static String getCurrentAddress = faker.address().streetAddress();
    public static String getSubjects = faker.options().option(subjects);

    public static String getYear = localDate.format(DateTimeFormatter.ofPattern("yyyy"));
    public static String getMonth = localDate.format(DateTimeFormatter.ofPattern("MMMM", new Locale("en")));
    public static String getDay = localDate.format(DateTimeFormatter.ofPattern("d"));
    public static String getDateOfBirth = getDay + " " + getMonth + "," + getYear;

    public static String getHobbies = faker.options().option(hobbies);

    public static String getSelectState = List.of("NCR", "Uttar Pradesh", "Haryana", "Rajasthan")
            .get(faker.random().nextInt(4));
    static List<String> cities = getSelectState.equals("NCR") ? List.of(NCR) :
            getSelectState.equals("Uttar Pradesh") ? List.of(UttarPradesh) :
                    getSelectState.equals("Haryana") ? List.of(Haryana) :
                            List.of(Rajasthan);
    public static String getSelectCity = cities.get(faker.random().nextInt(cities.size()));
    public static String getStateAndCity = getSelectState + " " + getSelectCity;
}