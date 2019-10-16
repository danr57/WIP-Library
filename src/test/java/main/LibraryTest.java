package main;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {

    private Library lib = new Library();
    LiteratureFactory factory = new LiteratureFactory();

    @Test
    public void testAddItem() {
        populateLibrary();
        assertEquals("Items are not creating properly. Item count: "
                + lib.getItems().size(), 5, lib.getItems().size());
    }

    @Test
    public void testRemoveItem() {
        populateLibrary();
        List<Item> itemsToRemove = new ArrayList<>();
        for (Item item : lib.getItems()) {
            if (item.itemType.equals("MAGAZINE")) {
                itemsToRemove.add(item);
            }
        }
        for (Item item : itemsToRemove) {
            lib.removeItem(item);
        }
        assertEquals("Items are not deleting properly", 3, lib.getItems().size());
    }

    @Test
    public void testRemoveCheckedOutItem() {
        Item book = new Book();
        Person barry = new Person("Steve Roddy");
        lib.addItem(book);
        lib.checkout(barry, book);
        lib.removeItem(book);
        assertEquals("Items are able to be deleted when checked out", 1, lib.getItems().size());
    }

    @Test
    public void testUpdateItem() {
//TODO: add functionality to update items
    }

    @Test
    public void testCheckOut() {
        Item book = factory.newItem("BOOK", "Andy McNab", "Penguin", 368);
        lib.addItem(book);
        Person terry = new Person("Terry");
        lib.registerMember(terry);
        lib.checkout(terry, book);
        assertEquals("Checkout not working", 1, terry.getCheckedOutItems().size());
        assertTrue("Checkout not working", book.checkedOut);
    }

    @Test
    public void testCheckIn() {
        Item book = factory.newItem("BOOK", "Andy McNab", "Penguin", 368);
        lib.addItem(book);
        Person terry = new Person("Terry");
        lib.registerMember(terry);
        lib.checkout(terry, book);
        lib.checkin(terry, book);
        assertEquals("Checkin not working", 0, terry.getCheckedOutItems().size());
        assertFalse("Checkin not working", book.checkedOut);
    }

    @Test
    public void testRegisterMember() {
        lib.registerMember(new Person("Terry"));
        assertEquals("Members aren't registering correctly", 1, lib.getMembers().size());
    }

    @Test
    public void testDeleteMember() {
        lib.registerMember(new Person("John"));
        lib.registerMember(new Person("Dave"));
        lib.registerMember(new Person("Alex"));
        Person matchingObject = lib.getMembers()
                .stream()
                .filter(p -> p.getName().equals("John"))
                .findAny()
                .orElse(null);
        lib.deleteMember(matchingObject);
        assertEquals("Person not deleted", 2, lib.getMembers().size());
    }

    @Test
    public void testUpdateMember() {
//TODO: add functionality to update members
    }

    private void populateLibrary() {
        for (int i = 0; i < 3; i++) {
            lib.addItem(new Book());
        }
        lib.addItem(new Magazine());
        lib.addItem(new Magazine());
    }


}