package controllers;
/*
Explanation:
- This is a controller class for the sign-up menu Controller.
- This class will be used to implement functions that do sign up menu operations.
- notice that this class should not have any input and output and just use it to implement functionalities.
 */

import models.App;
import models.Result;
import models.User;
import models.enums.Menu;
import models.enums.SignUpMenuCommands;

import java.util.regex.Matcher;

public class SignUpMenuController {
    public Result Register(String username, String password, String email, String name) {
        Matcher matcher;
        if((matcher = SignUpMenuCommands.Username.getMatcher(username)) == null ||
                username.length() < 4 || username.length() > 10)
            return new Result(false, "username format is invalid!");
        for(User user : App.users)
            if(user.getUsername().equals(username))
                return new Result(false, "this username is already taken!");
        if((matcher = SignUpMenuCommands.Password.getMatcher(password)) == null ||
                (matcher = SignUpMenuCommands.InvalidPasswordI.getMatcher(password)) != null ||
                (matcher = SignUpMenuCommands.InvalidPasswordII.getMatcher(password)) != null ||
                (matcher = SignUpMenuCommands.InvalidPasswordIII.getMatcher(password)) != null ||
                (matcher = SignUpMenuCommands.InvalidPasswordIV.getMatcher(password)) != null ||
                password.length() < 6 || password.length() > 12)
            return new Result(false, "password format is invalid!");
        if((matcher = SignUpMenuCommands.Email.getMatcher(email)) == null ||
            matcher.group("user").length() < 4 || matcher.group("user").length() > 10 ||
            matcher.group("domain").length() < 3 || matcher.group("domain").length() > 7)
            return new Result(false, "email format is invalid!");
        if((matcher = SignUpMenuCommands.Name.getMatcher(name)) == null)
            return new Result(false, "name format is invalid!");

        App.setCurrentMenu(Menu.LoginMenu);
        App.users.add(new User(username, password, email, name));
        return new Result(true, "user registered successfully.you are now in login menu!");
    }

    public Result GoToLoginMenu() {
        App.setCurrentMenu(Menu.LoginMenu);
        return new Result(true, "you are now in login menu!");
    }

    public void Exit() {
        App.setCurrentMenu(Menu.ExitMenu);
    }
}
