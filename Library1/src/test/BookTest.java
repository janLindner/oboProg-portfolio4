package test;

import main.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

  private Book book;

  @Before
  public void init(){
    book = new Book("Titel des Buches","Murietta Highines");
  }

  @Test
  public void shouldAddPage(){
    assertEquals(0,book.pageContent.size());
    book.addPage("Amazing Text");
    assertEquals(1,book.pageContent.size());
  }

  @Test
  public void shouldContainText(){
    book.addPage("Amazing Text in this Book");
    book.addPage("Hi everyone.");
    book.addPage("I love programming.");

    assertTrue(book.contains("I love programming."));
    assertTrue(book.contains("Hi everyone."));
    assertTrue(book.contains("Amazing Text in this Book"));
  }

  @Test
  public void shouldNotContainText(){
    book.addPage("Not so amazing.");

    assertFalse(book.contains("Not"));
    assertFalse(book.contains("so"));
    assertFalse(book.contains("amazing."));
    assertTrue(book.contains("Not so amazing."));
  }

}