package example3.model;


public class Book  extends java.util.Observable {
	private int id;
	private String title;
	private String author;
	private int year;
	private int price;
	private int stock;

	public Book(int id, String title, String author, int year, int price, int stock) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.stock = stock;
	}

	public void updateBook(int id, String title, String author, int year, int price, int stock) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
		this.stock = stock;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
		setChanged();
		notifyObservers();
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
		setChanged();
		notifyObservers();
	}

}
