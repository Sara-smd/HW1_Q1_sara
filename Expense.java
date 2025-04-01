package models;
/*
Explanation:
- when we create an expense, we need to store some information about it.
- Expense is something that we need to make it an object.
- put those information here and use them in your code.
 */

import java.util.HashMap;

public class Expense{
    private final User head;
    private final HashMap<User, Integer> expenseParts;

    public Expense(User head, HashMap<User, Integer> expenseParts) {
        this.head = head;
        this.expenseParts = expenseParts;
    }

    public User getHead() {
        return head;
    }

    public HashMap<User, Integer> getExpenseParts() {
        return expenseParts;
    }
}
