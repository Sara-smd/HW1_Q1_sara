package models.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
Explanation:
- we have commands in our sign-up menu and this commands need regexes to be checked.
- put those regexes here and use them in your code.
- this regexes need some functions, put those functions in here.
 */
public enum SignUpMenuCommands{
    Register("\\s*register\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-n\\s+(?<name>\\S+)\\s*"),
    GoToLoginMenu("\\s*go\\s+to\\s+login\\s+menu\\s*"),
    Exit("exit"),
    Username("[a-zA-Z][\\w\\-\\.]*"),
    Password("[a-zA-Z\\d!@#$%^&*]+"),
    InvalidPasswordI("[A-Z\\d!@#$%^&*]+"),
    InvalidPasswordII("[a-z\\d!@#$%^&*]+"),
    InvalidPasswordIII("[a-zA-Z!@#$%^&*]+"),
    InvalidPasswordIV("[a-zA-Z\\d]+"),
    Email("(?<user>[a-zA-Z][\\w\\-\\.]*)@(?<domain>[a-z]+[\\-.]?[a-z]+)\\.(?<TLD>org|com|net|edu)"),
    Name("[a-zA-Z]+(\\-\\b)?[a-zA-Z]*");

    private final String pattern;

    SignUpMenuCommands(String pattern) {
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
