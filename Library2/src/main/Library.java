package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<CompactDisc> compactDiscs;

    private ArrayList<Client> clients;

    public Library(){
        books = new ArrayList<>();
        compactDiscs = new ArrayList<>();
        clients = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addCompactDisc(CompactDisc compactDisc){
        compactDiscs.add(compactDisc);
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<CompactDisc> getCompactDiscs() {
        return compactDiscs;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Borrowable> getAllBorrowables(){
        ArrayList<Borrowable> allBorrowables = new ArrayList<>();
        allBorrowables.addAll(books);
        allBorrowables.addAll(compactDiscs);
        return allBorrowables;
    }

    public void printListOfBooks () {
        getAllBorrowables().forEach(borrowable -> System.out.println(borrowable.getTitle() + " # " + borrowable.getCopyrighted() + " # " + borrowable.getCategory()));
    }

    /*public List<String> bookBorrowedBy(String title){
        LinkedList<String> clientsBorrowedThisBook = new LinkedList<>();
        for(Client client:clients){
            List<String> borrowedBooks = client.borrowedBooks.stream().map(book -> book.getBooktitle()).collect(Collectors.toList());
            if(borrowedBooks.contains(title)){
                clientsBorrowedThisBook.add(client.getName());
            }
        }
        return clientsBorrowedThisBook;
    }

    public void deleteBook (Book book) {
        libRary.books.remove (this);
        for (Client client : libRary.clients) {
            client.borrowedBooks.remove (this);
        }
    }*/

}