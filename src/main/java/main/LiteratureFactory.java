package main;

import java.util.UUID;

public class LiteratureFactory {
    public Item newItem(String itemType, String author, String publisher, int pageCount) {

        String itemID = UUID.randomUUID().toString();

        if (itemType == null) {
            return null;
        }

        switch (itemType) {
            case "BOOK":
                return new Book(author, publisher, pageCount, itemID);
            case "MAGAZINE":
                return new Magazine();
            case "GOVDOC":

                return new GovernmentDocument();
        }
        return null;
    }


}
