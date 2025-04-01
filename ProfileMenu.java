package views;
/*
Explanation: 
- This is a view class for profile menu.
- This class should use to check inputs and print outputs for profile menu.
- notice that : this class should not have any logic and just use it to get inputs and handle it to use correct methods in controller.
 */


import controllers.DashboardController;
import controllers.ProfileMenuController;
import models.Result;
import models.enums.ProfileMenuCommands;

import java.util.regex.Matcher;

public class ProfileMenu implements AppMenu {
    private final ProfileMenuController controller = new ProfileMenuController();

    @Override
    public void check(String input) {
        Matcher matcher;
        if((matcher = ProfileMenuCommands.ShowUserInfo.getMatcher(input)) != null) {
            controller.ShowUserInfo();
        }
        else if((matcher = ProfileMenuCommands.ChangeCurrency.getMatcher(input)) != null) {
            System.out.println(controller.ChangeCurrency(matcher.group("newCurrency")));
        }
        else if((matcher = ProfileMenuCommands.ChangeUsername.getMatcher(input)) != null) {
            System.out.println(controller.ChangeUsername(matcher.group("newUsername")));
        }
        else if((matcher = ProfileMenuCommands.ChangePassword.getMatcher(input)) != null) {
            System.out.println(controller.ChangePassword(matcher.group("oldPassword"),
                                                         matcher.group("newPassword")));
        }
        else if((matcher = ProfileMenuCommands.Back.getMatcher(input)) != null) {
            System.out.println(controller.Back());
        }
        else if((matcher = ProfileMenuCommands.Exit.getMatcher(input)) != null) {
            controller.Exit();
        }
        else {
            System.out.println(new Result(false, "invalid command!"));
        }
    }
}
