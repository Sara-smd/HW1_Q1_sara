package controllers;

import models.App;
import models.Group;
import models.Result;
import models.User;
import models.enums.DashboardCommands;
import models.enums.GroupType;
import models.enums.Menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Explanation:
- This is a controller class for the dashboard Controller.
- This class will be used to implement functions that do dashboard operations.
- notice that this class should not have any input and output and just use it to implement functionalities.
 */
public class DashboardController {
    public Result CreateGroup(String groupName, String groupType) {
        Matcher matcher;
        if((matcher = DashboardCommands.GroupName.getMatcher(groupName)) == null ||
            groupName.length() < 4 || groupName.length() > 30)
            return new Result(false, "group name format is invalid!");
        if((matcher = GroupType.Home.getMatcher(groupType)) == null &&
                (matcher = GroupType.Trip.getMatcher(groupType)) == null &&
                (matcher = GroupType.ZanOBache.getMatcher(groupType)) == null &&
                (matcher = GroupType.Other.getMatcher(groupType)) == null)
            return new Result(false, "group type is invalid!");

        Group group = new Group(groupName, App.getLastID(), groupType, App.getLoggedInUser());
        App.increaseLastID();
        App.groups.add(group);
        App.getLoggedInUser().getGroups().add(group);
        return new Result(true, "group created successfully!");
    }

    public void ShowMyGroups() {
        for(Group group : App.getLoggedInUser().getGroups()) {
            System.out.println("group name : " + group.getName());
            System.out.println("id : " + group.getId());
            System.out.println("type : " + group.getType());
            System.out.println("creator : " + group.getCreator().getName());
            System.out.println("members :");
            for(User member : group.getMembers()) {
                System.out.println(member.getName());
            }
            System.out.println("--------------------");
        }
    }

    public Result AddUser(String username, String email, String id) {
        Matcher matcher = DashboardCommands.Number.getMatcher(id);
        if(matcher == null)
            return new Result(false, "group not found!");
        int groupID = toInt(id);
        for(User user : App.users)
            if(user.getUsername().equals(username)) {
                if(groupID >= App.getLastID())
                    return new Result(false, "group not found!");
                Group group = App.groups.get(groupID - 1);
                for(User member : group.getMembers())
                    if(member.getUsername().equals(username))
                        return new Result(false, "user already in the group!");
                if(!user.getEmail().equals(email))
                    return new Result(false, "the email provided does not match the username!");
                if(!group.getCreator().equals(App.getLoggedInUser()))
                    return new Result(false, "only the group creator can add users!");

                group.getMembers().add(user);
                user.getGroups().add(group);
                return new Result(true, "user added to the group successfully!");
            }
        return new Result(false, "user not found!");
    }

    public Result Logout() {
        App.setLoggedInUser(null);
        App.setCurrentMenu(Menu.LoginMenu);
        return new Result(true, "user logged out successfully.you are now in login menu!");
    }

    public void Exit() {
        App.setCurrentMenu(Menu.ExitMenu);
    }

    private int toInt(String number) {
        int result = 0;
        for(int i = 0; i < number.length(); i++) {
            result *= 10;
            result += number.charAt(i) - '0';
        }
        return result;
    }
}