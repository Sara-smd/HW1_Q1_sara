package models;

import models.enums.Menu;
import views.AppMenu;

import java.util.ArrayList;

/*
Explanation:
- In out app, we need somewhere to keep our general data like list of users and list of groups and logged-in user etc.
- This class is the place for that.
- Put your general data here and use them in your code.
- you should put some functions here to manage your data too.
 */
public class App {
    public static final ArrayList<User> users = new ArrayList<>();
    public static final ArrayList<Group> groups = new ArrayList<>();
    private static int lastID = 1;
    private static User loggedInUser = null;
    private static Menu currentMenu = Menu.SignUpMenu;

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static int getLastID() {
        return lastID;
    }

    public static Menu getCurrentMenu() {
        return currentMenu;
    }

    public static void setLoggedInUser(User loggedInUser) {
        App.loggedInUser = loggedInUser;
    }

    public static void increaseLastID() {
        App.lastID++;
    }

    public static void setCurrentMenu(Menu currentMenu) {
        App.currentMenu = currentMenu;
    }
}
