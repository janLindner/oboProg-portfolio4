package test;

import main.Book;
import main.Client;
import main.CompactDisc;
import main.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LibraryTest {

  private Client client;
  private Library library;
  private Book book;
  private CompactDisc cd;

  @Before
  public void init(){
    client = new Client("Albert Schweitzer","Tollestrasse 1a");
    library = new Library();
    library.addClient(client);
    book = new Book("Der Herr der Ringe", "Steve Jobs");
    cd = new CompactDisc("Der Hobbit. Extended Cut.", "Harry Potter");
    library.addBook(book);
    library.addCompactDisc(cd);
    assertTrue(library.getClients().contains(client));
    assertEquals(2,library.getAllBorrowables().size());
    assertTrue(library.getBooks().contains(book));
    assertTrue(library.getCompactDiscs().contains(cd));
  }

  @Test
  public void shouldPrintListOfBooks(){
    library.printListOfBooks();
  }

  @Test
  public void shouldBorrowBook(){
    assertFalse(client.borrowedBooks.contains(book));
    book.addAndBorrowBook(library,client);
    assertTrue(client.borrowedBooks.contains(book));
    assertEquals(1,client.borrowedBooks.size());
  }

  @Test
  public void shouldBorrowCD(){
    assertFalse(client.borrowedBooks.contains(cd));
    cd.addAndBorrowCD(library,client);
    assertTrue(client.borrowedBooks.contains(cd));
    assertEquals(1,client.borrowedBooks.size());
  }

  @Test
  public void shouldDeleteBook(){
    assertTrue(library.books.contains(book));
    book.deleteBook(library);
    assertFalse(library.books.contains(book));
  }

  @Test
  public void shouldDeleteCD(){
    assertTrue(library.books.contains(cd));
    cd.deleteBook(library);
    assertFalse(library.books.contains(cd));
  }

  @Test
  public void shouldBorrowAndReturnBook(){
    book.addAndBorrowBook(library,client);
    assertTrue(client.borrowedBooks.contains(book));
    client.returnBook(book.booktitle);
    assertFalse(client.borrowedBooks.contains(book));
  }

  @Test
  public void shouldBorrowAndReturnCD(){
    cd.addAndBorrowCD(library,client);
    assertTrue(client.borrowedBooks.contains(cd));
    client.returnBook(cd.booktitle);
    assertFalse(client.borrowedBooks.contains(cd));
  }

  @Test
  public void shouldNotBorrowBookIfBorrowedAsCD(){
    book.addAndBorrowCD(library,client);
    assertFalse(client.borrowedBooks.contains(book));
  }

  @Test
  public void shouldNotBorrowCDIfBorrowedAsBook(){
    cd.addAndBorrowBook(library,client);
    assertFalse(client.borrowedBooks.contains(cd));
  }

  @Test
  public void shouldGiveClientsBorrowedBook(){
    Client client2 = new Client("Maximilian","Maximilianstrasse 9");
    Client client3 = new Client("Maria","Marienstrasse 10");
    client2.addToLibrary(library);
    client3.addToLibrary(library);

    book.addAndBorrowBook(library,client);
    book.addAndBorrowBook(library,client2);
    book.addAndBorrowBook(library,client3);

    assertTrue(client.borrowedBooks.contains(book));
    assertTrue(client2.borrowedBooks.contains(book));
    assertTrue(client3.borrowedBooks.contains(book));

    List<String> list = library.bookBorrowedBy("Der Herr der Ringe");
    list.stream().forEach(item -> System.out.println(item));

  }

}