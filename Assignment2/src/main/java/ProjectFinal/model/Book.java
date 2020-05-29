package ProjectFinal.model;

public class Book extends Model {
	private String genre;
	private String title;
	private String author;
	private double price;
	private int stock;
	private int id;
	private BookStore bookStore;

	public Book(int id, String genre, String title, String author, double price, int stock) {
		this.id=id;
		this.genre = genre;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
	}

	public Book() {
	}

	public BookStore getBookStore() {
		bookStore=new BookStore();
		return bookStore;
	}

	public Book setBookStore(BookStore bookStore) {
		this.bookStore = bookStore;
		return this;
	}
	public void sellBook(){
		System.out.println(this.toString());
		this.stock--;
		System.out.println(this.toString());
		setChanged();
		notifyObservers();
	}

	public Model updateModel(Model x){
		this.setAuthor(((Book)x).getAuthor());
		this.setGenre(((Book)x).getGenre());
		this.setId(((Book)x).getId());
		this.setPrice(((Book)x).getPrice());
		this.setStock(((Book)x).getStock());
		this.setTitle(((Book)x).getTitle());
		setChanged();
		notifyObservers();
		return this;
	}

	@Override
	public <T extends ModelStore> T returnStore() {

		return (T) bookStore;
	}

	@Override
	public String toString() {
		return "Book{" +
				"genre='" + genre + '\'' +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", price=" + price +
				", stock=" + stock +
				'}';
	}

	public String getGenre() {
		return genre;
	}

	public Book setGenre(String genre) {
		this.genre = genre;
		setChanged();
		notifyObservers();
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Book setTitle(String title) {
		this.title = title;
		setChanged();
		notifyObservers();
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public Book setAuthor(String author) {
		this.author = author;
		setChanged();
		notifyObservers();
		return this;
	}

	public double getPrice() {
		return price;
	}

	public Book setPrice(double price) {
		this.price = price;
		setChanged();
		notifyObservers();
		return this;
	}

	public int getStock() {
		return stock;
	}

	public Book setStock(int stock) {
		this.stock = stock;
		setChanged();
		notifyObservers();
		return this;
	}

	public int getId() {
		return id;
	}

	public Book setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers();
		return this;
	}
}
