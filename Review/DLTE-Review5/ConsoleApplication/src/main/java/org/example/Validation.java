package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    //pin validation 6 digits
    public boolean isValidPin(int pin) {
        String pinString = String.valueOf(pin);
        return pinString.length() == 6;
    }
    //email validation
    public static boolean isValidEmail(String email) {
        //shreya.s.poojary@example.com
        //domain must contain single .
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPhoneNumber(long phoneNumber) {
        //phone number 10 digits
        String regex = "(\\d{10})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Long.toString(phoneNumber));
        return matcher.matches();
    }

}