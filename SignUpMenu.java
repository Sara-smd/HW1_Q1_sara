package views;

import models.Result;
import models.enums.SignUpMenuCommands;
import controllers.SignUpMenuController;

import java.util.regex.Matcher;
/*
Explanation:
- This is a view class for the SignUpMenu.
- This class should use to check inputs and print outputs for the SignUpMenu.
- notice that : this class should not have any logic and just use it to get inputs and handle it to use correct methods in controller.
 */

public class SignUpMenu implements AppMenu {
    private final SignUpMenuController controller = new SignUpMenuController();

    @Override
    public void check(String input) {
        Matcher matcher;
        if((matcher = SignUpMenuCommands.Register.getMatcher(input)) != null) {
            System.out.println(controller.Register(matcher.group("username"),
                                                    matcher.group("password"),
                                                    matcher.group("email"),
                                                    matcher.group("name")));
        }
        else if((matcher = SignUpMenuCommands.GoToLoginMenu.getMatcher(input)) != null) {
            System.out.println(controller.GoToLoginMenu());
        }
        else if((matcher = SignUpMenuCommands.Exit.getMatcher(input)) != null) {
            controller.Exit();
        }
        else {
            System.out.println(new Result(false, "invalid command!"));
        }
    }
}
