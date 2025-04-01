package models.enums;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/*
Explanation:
- we have commands in our dashboard and this commands need regexes to be checked.
- put those regexes here and use them in your code.
- this regexes need some functions, put those functions in here.
 */
public enum DashboardCommands  {
    CreateGroup("\\s*create-group\\s+-n\\s+(?<groupName>.*\\S)\\s+-t\\s+(?<groupType>\\S+)\\s*"),
    ShowMyGroups("\\s*show\\s+my\\s+groups\\s*"),
    AddUser("\\s*add-user\\s+-u\\s+(?<username>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-g\\s+(?<groupId>\\S+)\\s*"),
    AddExpense("\\s*add-expense\\s+-g\\s+(?<groupId>)\\s+-s\\s+(?<splitMethod>\\S+)\\s+-t\\s+(?<totalExpense>\\S+)\\s+-n\\s+(?<numberOfUsers>\\S+)\\s*"),
    ShowBalance("\\s*show\\s+balance\\s+-u\\s+(?<username>\\S+)\\s*"),
    SettleUp("\\s*settle-up\\s+-u\\s+(?<username>\\S+)\\s+-m\\s+(?<inputMoney>\\S+)\\s*"),
    GoToProfileMenu("\\s*go\\s+to\\s+profile\\s+menu\\s*"),
    Logout("\\s*logout\\s*"),
    Exit("exit"),
    GroupName("[a-zA-Z\\d !@#$%^&*]+"),
    Number("[1-9]\\d*");

    private final String pattern;

    DashboardCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.matches())
            return matcher;
        else
            return null;
    }
}
