package controllers;
/*
Explanation:
- This is a controller class for the profile menu Controller.
- This class will be used to implement functions that do profile menu operations.
- notice that this class should not have any input and output and just use it to implement functionalities.
 */

import models.App;
import models.Result;
import models.User;
import models.enums.Currency;
import models.enums.Menu;
import models.enums.ProfileMenuCommands;
import models.enums.SignUpMenuCommands;

import java.util.regex.Matcher;

public class ProfileMenuController {
    public void ShowUserInfo() {
        System.out.println("username : " + App.getLoggedInUser().getUsername());
        System.out.println("password : " + App.getLoggedInUser().getPassword());
        System.out.println("currency : " + App.getLoggedInUser().getCurrencyName());
        System.out.println("email : " + App.getLoggedInUser().getEmail());
        System.out.println("name : " + App.getLoggedInUser().getName());
    }

    public Result ChangeCurrency(String newCurrency) {
        Matcher matcher;
        if((matcher = Currency.GalacticCoin.getMatcher(newCurrency)) != null) {
            App.getLoggedInUser().setCurrencyName(newCurrency);
            App.getLoggedInUser().setCurrencyValue(5);
            return new Result(true, "your currency changed to " + newCurrency +" successfully!");
        }
        if((matcher = Currency.StarDollar.getMatcher(newCurrency)) != null) {
            App.getLoggedInUser().setCurrencyName(newCurrency);
            App.getLoggedInUser().setCurrencyValue(2);
            return new Result(true, "your currency changed to " + newCurrency +" successfully!");
        }
        if((matcher = Currency.QuantumNote.getMatcher(newCurrency)) != null) {
            App.getLoggedInUser().setCurrencyName(newCurrency);
            App.getLoggedInUser().setCurrencyValue(1);
            return new Result(true, "your currency changed to " + newCurrency +" successfully!");
        }
        return new Result(false, "currency format is invalid!");
    }

    public Result ChangeUsername(String newUsername) {
        if(App.getLoggedInUser().getUsername().equals(newUsername))
            return new Result(false, "please enter a new username!");
        for(User user : App.users)
            if(user.getUsername().equals(newUsername))
                return new Result(false, "this username is already taken!");
        Matcher matcher;
        if((matcher = ProfileMenuCommands.Username.getMatcher(newUsername)) == null ||
                newUsername.length() < 4 || newUsername.length() > 10)
            return new Result(false, "new username format is invalid!");

        App.getLoggedInUser().setUsername(newUsername);
        return new Result(true, "your username changed to <new-username> successfully!");
    }

    public Result ChangePassword(String oldPassword, String newPassword) {
        if(!App.getLoggedInUser().getPassword().equals(oldPassword))
            return new Result(false, "password incorrect!");
        if(App.getLoggedInUser().getPassword().equals(newPassword))
            return new Result(false, "please enter a new password!");
        Matcher matcher;
        if((matcher = SignUpMenuCommands.Password.getMatcher(newPassword)) == null ||
                (matcher = SignUpMenuCommands.InvalidPasswordI.getMatcher(newPassword)) != null ||
                (matcher = SignUpMenuCommands.InvalidPasswordII.getMatcher(newPassword)) != null ||
                (matcher = SignUpMenuCommands.InvalidPasswordIII.getMatcher(newPassword)) != null ||
                (matcher = SignUpMenuCommands.InvalidPasswordIV.getMatcher(newPassword)) != null ||
                newPassword.length() < 6 || newPassword.length() > 12)
            return new Result(false, "password format is invalid!");
        App.getLoggedInUser().setPassword(newPassword);
        return new Result(true, "your password changed successfully!");
    }

    public Result Back() {
        App.setCurrentMenu(Menu.Dashboard);
        return new Result(true, "you are now in dashboard!");
    }

    public void Exit() {
        App.setCurrentMenu(Menu.ExitMenu);
    }
}
