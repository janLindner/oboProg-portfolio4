package main;

import java.util.ArrayList;

public class Client {

	private String name;
	private String address;
	private ArrayList<String> favoriteCategories = new ArrayList();
	private ArrayList<Borrowable> borrowed = new ArrayList();

	public Client (String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName(){
		return name;
	}

	public String getAddress(){
		return address;
	}

	public void returnBorrowable (String title) {
		Borrowable toReturn = null;
		for (Borrowable borrowable:borrowed) {
			if (borrowable.getTitle().equals(title)) {
				toReturn = borrowable;
			}
		}

		borrowed.remove(toReturn);
	}
	
	public boolean isFavoriteCategory (String category) {
	    return favoriteCategories.contains (category);
	}

}