package controllers;
/*
Explanation:
- This is a controller class for the login menu Controller.
- This class will be used to implement functions that do log in menu operations.
- notice that this class should not have any input and output and just use it to implement functionalities.
 */
import models.App;
import models.Result;
import models.User;
import models.enums.Menu;

public class LoginMenuController {
    public Result Login(String username, String password) {
        for (User user : App.users)
            if(user.getUsername().equals(username)) {
                if(user.getPassword().equals(password)) {
                    App.setLoggedInUser(user);
                    App.setCurrentMenu(Menu.Dashboard);
                    return new Result(true, "user logged in successfully.you are now in dashboard!");
                }
                else
                    return new Result(false, "password is incorrect!");
            }
        return new Result(false, "username doesn't exist!");
    }

    public Result ForgetPassword(String username, String email) {
        for(User user : App.users)
            if(user.getUsername().equals(username)) {
                if(user.getEmail().equals(email)) {
                    return new Result(true, "password : " + user.getPassword());
                }
                else
                    return new Result(false, "email doesn't match!");
            }
        return new Result(false, "username doesn't exist!");
    }

    public Result GoToSignUpMenu() {
        App.setCurrentMenu(Menu.SignUpMenu);
        return new Result(true, "you are now in signup menu!");
    }

    public Result Exit() {
        App.setCurrentMenu(Menu.ExitMenu);
        return new Result(true, "");
    }
}
