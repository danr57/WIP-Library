package main;

import java.util.ArrayList;
import java.util.List;


public class Library {

    private List<Item> items = new ArrayList<>();

    private List<Person> members = new ArrayList<>();

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        if (!item.checkedOut) {
            this.items.remove(item);
        } else {
            System.out.printf("Error! This item is currently checked out by %s (UUID: %s)%n", item.checkedOutBy.getName(), item.checkedOutBy.getUniqueID());
            System.out.println("Please recover the item before attempting to remove it from the library system.");
        }
    }

//    TODO: ideally this would update the item rather than creating and replacing it with a new object
    public void updateItem(Item itemToReplace, Item updatedItem) {
        updatedItem.itemID = itemToReplace.itemID;
        this.items.remove(itemToReplace);
        this.items.add(updatedItem);
    }

    public Item findByUUID(String uuid) {
        return getItems()
                .stream()
                .filter(i -> i.itemID.equals(uuid))
                .findAny()
                .orElse(null);
    }

    public List<Item> getItems() {
        return items;
    }

    public void checkin(Person person, Item item) {
        person.checkinItem(item);
        item.checkedOut = false;
        item.checkedOutBy = null;
    }

    public void checkout(Person person, Item item) {
        person.checkoutItem(item);
        item.checkedOut = true;
        item.checkedOutBy = person;
    }

    public void registerMember(Person person) {
        this.members.add(person);
    }

    public void deleteMember(Person person) {
        this.members.remove(person);
    }

    public void updateMemberName(Person memberToUpdate, String name) {
        Person matchingPerson = this.getMembers()
                .stream()
                .filter(person -> person.getName().equals(memberToUpdate.getName()))
                .findAny()
                .orElse(null);
        assert matchingPerson != null;
        matchingPerson.setName(name);
    }

    public List<Person> getMembers() {
        return members;
    }
}