package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Person {
    private String name;
    private List<Item> checkedOutItems = new ArrayList<>();
    private final String uniqueID;

    public Person(String name) {
        this.name = name;
        uniqueID = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getCheckedOutItems() {
        return checkedOutItems;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void checkoutItem(Item item) {
        checkedOutItems.add(item);
    }

    public void checkinItem(Item item) {
        this.checkedOutItems.remove(item);
    }
}
