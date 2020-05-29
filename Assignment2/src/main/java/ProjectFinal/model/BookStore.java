package ProjectFinal.model;

import ProjectFinal.utilities.XmlParser;

import java.util.ArrayList;
import java.util.List;

public class BookStore extends ModelStore {
	private static ArrayList<Book> bookList;
	private static boolean isListSet =false;

	public BookStore(){
		if(!isListSet) {
			bookList = XmlParser.getBooksFromXml();
			isListSet =true;
		}
	}

	public boolean insertInStore(Book b){
		bookList.add(b);
		notifyObservers();
		return true;
	}

	public boolean deleteFromStore(Book b){
		bookList.remove(b);
		notifyObservers();
		return true;
	}

	public boolean updateInStore(Book b){
		for (Book book : bookList) {
			if(book.getId()==b.getId()){
				book.setAuthor(b.getAuthor());
				book.setGenre(b.getGenre());
				book.setPrice(b.getPrice());
				book.setStock(b.getStock());
				book.setTitle(b.getTitle());
				return true;
			}
		}
		return false;
	}


	public ArrayList<Book> searchBook(String searchString) {
		System.out.println("Searching for books"+bookList.size());
		ArrayList<Book> matches = new ArrayList<Book>();

		if (searchString == null || searchString.equals("") || searchString.equals(" ")) {
			System.out.println("Input is null, returning: "+bookList.size());
			return bookList;
		}

		for (Book book : bookList) {
			getBookById(searchString, matches, book);
			getBookByGenre(searchString, matches, book);
			getBookByTitle(searchString, matches, book);
			getBookByAuthor(searchString, matches, book);
		}
		System.out.println(matches.toString());
		return matches;
	}

	private void getBookByGenre(String searchString, List<Book> matches, Book book) {
		if (book.getGenre().equals(searchString) || book.getGenre().contains(searchString)) {
			matches.add(book);
		}
	}

	private void getBookByTitle(String searchString, List<Book> matches, Book book) {
		if (book.getTitle().equals(searchString) || book.getTitle().contains(searchString)) {
			matches.add(book);
		}
	}

	private void getBookByAuthor(String searchString, List<Book> matches, Book book) {
		if (book.getAuthor().equals(searchString) || book.getAuthor().contains(searchString)) {
			matches.add(book);
		}
	}

	private void getBookById(String searchString, List<Book> matches, Book book) {
		try {
			if (book.getId() == Integer.parseInt(searchString) || String.valueOf(book.getId()).contains(searchString)) {
				matches.add(book);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<Book> getStoreList() {
		return bookList;
	}

	@Override
	public String toString() {
		return "BookStore{" +
				"bookList=" + bookList +
				'}';
	}
}
