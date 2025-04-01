package models.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Explanation:
- we have commands in our profile menu and this commands need regexes to be checked.
- put those regexes here and use them in your code.
- this regexes need some functions, put those functions in here.
 */

public enum ProfileMenuCommands {
    ShowUserInfo("\\s*show\\s+user\\s+info\\s*"),
    ChangeCurrency("\\s*change-currency\\s+-n\\s+(?<newCurrency>\\S+)\\s*"),
    ChangeUsername("\\s*change-username\\s+-n\\s+(?<newUsername>\\S+)\\s*"),
    ChangePassword("\\s*change-password\\s+-o\\s+(?<oldPassword>\\S+)\\s+-n\\s+(?<newPassword>\\S+)\\s*"),
    Back("\\s*back\\s*"),
    Exit("exit"),
    Username("[a-zA-Z][\\w\\-\\.]*"),
    Password("[a-zA-Z\\d!@#$%^&*]+"),
    InvalidPasswordI("[A-Z\\d!@#$%^&*]+"),
    InvalidPasswordII("[a-z\\d!@#$%^&*]+"),
    InvalidPasswordIII("[a-zA-Z!@#$%^&*]+"),
    InvalidPasswordIV("[a-zA-Z\\d]+");

    private final String pattern;

    ProfileMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if(matcher.matches())
            return matcher;
        else
            return null;
    }
}
