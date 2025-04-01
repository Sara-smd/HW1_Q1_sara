package models;
/*
Explanation:
- In our app, we have groups that have some information.
- Group is something that we need to make it an object because it looks like an object (:
- put those information here and use them in your code.
 */

import java.util.ArrayList;

public class Group {
    private final String name;
    private final int id;
    private final String type;
    private final User creator;
    private final ArrayList<User> members;
    private final ArrayList<Expense> expenses;

    public Group(String name, int id, String type, User creator) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.creator = creator;
        this.members = new ArrayList<>();
        this.members.add(creator);
        this.expenses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public User getCreator() {
        return creator;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
}
