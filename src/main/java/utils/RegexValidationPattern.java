package utils;

import java.util.regex.Pattern;

public class RegexValidationPattern {

    private static String emailRegexPattern = "^(.+)@(.+)$";

    private static String phoneNumberRegexPattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    public RegexValidationPattern(){

    }

    public boolean validateEmail(String email){
        return Pattern.compile(emailRegexPattern, Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }

    public boolean validatePhoneNumber(String phoneNumber){
        return Pattern.compile(phoneNumberRegexPattern).matcher(phoneNumber).matches();
    }

}
