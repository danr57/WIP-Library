package main;

public class Magazine extends Literature {

    private int issue;
    private String editor;

    public Magazine() {
        this.itemType = "MAGAZINE";
    }

    public Magazine(String title, String publisher, int pageCount, int issue, String editor, String itemID) {
        this.itemType = "MAGAZINE";
    }
}
