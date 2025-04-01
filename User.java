package models;

/*
Explanation:
- User is definitely an object in our app.
- put the information that you need to store about the user here.
- you can put some functions here to manage the user data too.
 */

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private final String email;
    private final String name;
    private int currencyValue;
    private String currencyName;
    private final ArrayList<Group> groups;

    public User(String username, String password, String email, String name) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.currencyValue = 5;
        this.currencyName = "GTC";
        this.groups = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getCurrencyValue() {
        return currencyValue;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCurrencyValue(int currencyValue) {
        this.currencyValue = currencyValue;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void addGroup(Group group) {
        this.groups.add(group);
    }
}
