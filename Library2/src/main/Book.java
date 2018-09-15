package main;

import java.util.ArrayList;

public class Book extends Borrowable{

    private String author;
    private ArrayList<String> pageContent;
    private boolean compactDisc;

    public Book (String title,String author) {
        super(title,author,"Roman");
        this.author = author;
        this.pageContent = new ArrayList<>();
    }

    public String getAuthor(){
        return author;
    }

    public ArrayList<String> getPageContent() {
        return pageContent;
    }

    public void addPage (String text_of_page) {
        pageContent.add (text_of_page);
    }
    
    public boolean contains (String text) {
        boolean found = false;
        int page = 0;
        while (!found && page < pageContent.size()) {
            found = pageContent.contains (text);
            page++;
        }
        return found;
    }

}