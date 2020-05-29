package example3.model;

import java.util.ArrayList;


public class BookStore extends java.util.Observable {
	private ArrayList<Book> bookList;

	public BookStore() {
		bookList = new ArrayList<Book>();
	}

	public void addBook(Book b) {
		bookList.add(b);
		setChanged();
		notifyObservers();
	}

	public void initBookList() {
		bookList = new ArrayList<Book>();
		bookList.add(new Book(1, "Omul in cautarea sensului vietii", "Frankl", 2005, 70, 10));
		bookList.add(new Book(2, "English", "oxford", 1998, 135, 15));
		setChanged();
		notifyObservers();
	}
}
