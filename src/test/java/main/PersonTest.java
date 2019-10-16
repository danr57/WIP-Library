package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person steveRoddy = new Person("Steve Roddy");
    Item book = new Book();

    @Test
    public void testCreation(){
        assertEquals("The person's name is not being correctly assigned",
                "Steve Roddy", steveRoddy.getName());
        assertFalse("The person is not being given a UUID",
                steveRoddy.getUniqueID().isEmpty());
    }

    @Test
    public void testCheckout() {
        steveRoddy.checkoutItem(book);
        assertEquals("The person is not receiving the item checked out", 1, steveRoddy.getCheckedOutItems().size());
    }

    @Test
    public void testCheckin() {
        testCheckout();
        steveRoddy.checkinItem(book);
        assertEquals("The person is keeping the item after checking it in", 0, steveRoddy.getCheckedOutItems().size());
    }
}
