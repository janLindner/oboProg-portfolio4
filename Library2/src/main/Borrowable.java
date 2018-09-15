package main;

public class Borrowable {

  private String title;
  private String copyrighted;
  private String category;

  public Borrowable(String title,String copyrighted,String category){
    this.title = title;
    this.copyrighted = copyrighted;
    this.category = category;
  }

  public String getTitle() {
    return title;
  }

  public String getCopyrighted() {
    return copyrighted;
  }

  public String getCategory() {
    return category;
  }

  public boolean hasCategory (String category) {
    return this.category.equals(category);
  }

}
