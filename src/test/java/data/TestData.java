package data;

import utils.RandomUtils;
import java.time.LocalDate;

public class TestData {

    public static String checkName = "Student Name";
    public static String checkEmail = "Student Email";
    public static String checkGender = "Gender";
    public static String checkMobile = "Mobile";
    public static String checkDateOfBirth = "Date of Birth";
    public static String checkSubjects = "Subjects";
    public static String checkHobbies = "Hobbies";
    public static String checkPicture = "Picture";
    public static String checkAddress = "Address";
    public static String checkStateAndCity = "State and City";

    public final String firstName = RandomUtils.getFirstName();
    public final String lastName = RandomUtils.getLastName();
    public final String fullName = firstName + " " + lastName;

    public final String email = RandomUtils.getEmail();
    public final String gender = RandomUtils.getGender();
    public final String phone = RandomUtils.getPhoneNumber();
    public final String address = RandomUtils.getAddress();
    public final String subject = RandomUtils.getSubject();
    public final String hobby = RandomUtils.getHobby();
    public final String img = RandomUtils.getImageName();

    public final LocalDate birthDate = RandomUtils.getRandomBirthday();
    public final String birthDay = RandomUtils.getBirthDay(birthDate);
    public final String birthMonth = RandomUtils.getBirthMonth(birthDate);
    public final String birthYear = RandomUtils.getBirthYear(birthDate);
    public final String dateOfBirth = birthDay + " " + birthMonth + "," + birthYear;

    public final String state = RandomUtils.getState();
    public final String city = RandomUtils.getCity(state);
    public final String stateAndCity = state + " " + city;
}
