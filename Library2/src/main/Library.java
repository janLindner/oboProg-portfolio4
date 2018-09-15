package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    public ArrayList<Book> books = new ArrayList();

    public ArrayList<Client> clients = new ArrayList();

    public void addBook (Book book) {
        books.add (book);
    }

    public void printListOfBooks () {
        for (Book book : books) {
            if (!book.isCompactDisc()) {
                System.out.println(book.booktitle + " # " + book.getAuthor() + " # " +book.category);
            } else {
                System.out.println(book.booktitle + " # " + book.getAuthor() + " # CD");
            }
        }
    }

    public List<String> bookBorrowedBy(String title){
        LinkedList<String> clientsBorrowedThisBook = new LinkedList<>();
        for(Client client:clients){
            List<String> borrowedBooks = client.borrowedBooks.stream().map(book -> book.booktitle).collect(Collectors.toList());
            if(borrowedBooks.contains(title)){
                clientsBorrowedThisBook.add(client.name);
            }
        }
        return clientsBorrowedThisBook;
    }

}