package main;

public class Book extends Literature{

    public Book() {
        this.itemType = "BOOK";
    }

    public Book(String author, String publisher, int pageCount, String itemID) {
        this.itemType = "BOOK";
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.itemID = itemID;
    }
}
