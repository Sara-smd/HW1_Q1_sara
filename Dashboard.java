package views;
/*
Explanation:
- This is a view class for the dashboard.
- This class should use to check inputs and print outputs for the dashboard.
- notice that : this class should not have any logic and just use it to get inputs and handle it to use correct methods in controller.
 */

import controllers.DashboardController;
import models.Result;
import models.enums.DashboardCommands;

import java.util.regex.Matcher;

public class Dashboard implements AppMenu {
    private final DashboardController controller = new DashboardController();

    @Override
    public void check(String input) {
        Matcher matcher;
        if((matcher = DashboardCommands.CreateGroup.getMatcher(input)) != null) {
            System.out.println(controller.CreateGroup(matcher.group("groupName"),
                                                      matcher.group("groupType")));
        }
        else if((matcher = DashboardCommands.ShowMyGroups.getMatcher(input)) != null) {
            controller.ShowMyGroups();
        }
        else if((matcher = DashboardCommands.AddUser.getMatcher(input)) != null) {
            System.out.println(controller.AddUser(matcher.group("username"),
                                                  matcher.group("email"),
                                                  matcher.group("groupId")));
        }
        else if((matcher = DashboardCommands.AddExpense.getMatcher(input)) != null) {
            //TODO
        }
        else if((matcher = DashboardCommands.ShowBalance.getMatcher(input)) != null) {
            //TODO
        }
        else if((matcher = DashboardCommands.SettleUp.getMatcher(input)) != null) {
            //TODO
        }
        else if((matcher = DashboardCommands.GoToProfileMenu.getMatcher(input)) != null) {
            //TODO
        }
        else if((matcher = DashboardCommands.Logout.getMatcher(input)) != null) {
            System.out.println(controller.Logout());
        }
        else if((matcher = DashboardCommands.Exit.getMatcher(input)) != null) {
            controller.Exit();
        }
        else {
            System.out.println(new Result(false, "invalid command!"));
        }
    }

}
