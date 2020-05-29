package ProjectFinal.view;

import ProjectFinal.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class AdminView extends View implements java.util.Observer {
	public UserStore userStore;
	public User u;

	public BookStore bookStore;
	public Book b;
	public ArrayList<Book> bookList;
	public ArrayList<User> userList;

	public DefaultTableModel bookTable;
	public DefaultTableModel userTable;

	public JLabel jLabelUserId;
	public JLabel jLabelUserUsername;
	public JLabel jLabelUserRole;
	public JLabel jLabelUserName;
	public JLabel jLabelUserPassword;

	public JTextField jTextFieldUserId;
	public JTextField jTextFieldUserUsername;
	public JTextField jTextFieldUserRole;
	public JTextField jTextFieldUserName;
	public JTextField jTextFieldUserPassword;

	public JButton jButtonUserDelete;
	public JButton jButtonUserUpdate;
	public JButton jButtonUserCreate;

	public JLabel jLabelBookId;
	public JLabel jLabelBookTitle;
	public JLabel jLabelBookGenre;
	public JLabel jLabelBookAuthor;
	public JLabel jLabelBookPrice;
	public JLabel jLabelBookStock;

	public JTextField jTextFieldBookId;
	public JTextField jTextFieldBookTitle;
	public JTextField jTextFieldBookGenre;
	public JTextField jTextFieldBookAuthor;
	public JTextField jTextFieldBookPrice;
	public JTextField jTextFieldBookStock;

	public JButton jButtonBookDelete;
	public JButton jButtonBookUpdate;
	public JButton jButtonBookCreate;

	public User getUserObject(){
		User u=new User();
		u.setId(Integer.parseInt(jTextFieldUserId.getText()));
		u.setUsername(jTextFieldUserUsername.getText());
		u.setRole(jTextFieldUserRole.getText());
		u.setName(jTextFieldUserName.getText());
		u.setPassword(jTextFieldUserPassword.getText());
		return u;
	}

	public Book getBookObject(){
		Book b=new Book();
		b.setId(Integer.parseInt(jTextFieldBookId.getText()));
		b.setAuthor(jTextFieldBookAuthor.getText());
		b.setGenre(jTextFieldBookGenre.getText());
		b.setPrice(Double.parseDouble(jTextFieldBookPrice.getText()));
		b.setStock(Integer.parseInt(jTextFieldBookStock.getText()));
		b.setTitle(jTextFieldBookTitle.getText());
		return b;
	}

	public void addBookDeleteListener(ActionListener a){
		jButtonBookDelete.addActionListener(a);
	}

	public void addBookUpdateListener(ActionListener a){
		jButtonBookUpdate.addActionListener(a);
	}

	public void addBookCreateListener(ActionListener a){
		jButtonBookCreate.addActionListener(a);
	}

	public void addUserDeleteListener(ActionListener a){
		jButtonUserDelete.addActionListener(a);
	}
	public void addUserUpdateListener(ActionListener a){
		jButtonUserUpdate.addActionListener(a);
	}
	public void addUserCreateListener(ActionListener a){
		jButtonUserCreate.addActionListener(a);
	}

	public AdminView(UserStore userStore, User u, BookStore bookStore, Book b){
		this.bookStore=bookStore;
		this.userStore=userStore;
		this.u=u;
		this.b=b;
		bookList= this.bookStore.getStoreList();
		userList= this.userStore.getStoreList();
		initComponents();
		initObservers();
		refreshInfoBook();
		refreshInfoUser();
	}
	private void initObservers() {
		for (User user : userList) {
			user.addObserver(this);
		}
		for (Book book : bookList) {
			book.addObserver(this);
		}
	}

	private void userCRUD(){
		jLabelUserId = new JLabel("User Id: ");
		jLabelUserId.setBounds(0, 300,160, 50);
		jLabelUserUsername = new JLabel("User Username: ");
		jLabelUserUsername.setBounds(160, 300,160, 50);
		jLabelUserRole = new JLabel("User Role:");
		jLabelUserRole.setBounds(320, 300,160, 50);
		jLabelUserName = new JLabel("User Name:");
		jLabelUserName.setBounds(480, 300,160, 50);
		jLabelUserPassword = new JLabel("User Password:");
		jLabelUserPassword.setBounds(640, 300,160, 50);


		jTextFieldUserId = new JTextField();
		jTextFieldUserId.setBounds(0, 350,160, 50);
		jTextFieldUserUsername = new JTextField();
		jTextFieldUserUsername.setBounds(160, 350,160, 50);
		jTextFieldUserRole = new JTextField();
		jTextFieldUserRole.setBounds(320, 350,160, 50);
		jTextFieldUserName = new JTextField();
		jTextFieldUserName.setBounds(480, 350,160, 50);
		jTextFieldUserPassword = new JTextField();
		jTextFieldUserPassword.setBounds(640, 350,160, 50);


		jButtonUserDelete = new JButton("Delete");
		jButtonUserDelete.setBounds(0, 400,266, 50);
		jButtonUserUpdate = new JButton("Update");
		jButtonUserUpdate.setBounds(266, 400,266, 50);
		jButtonUserCreate = new JButton("Insert");
		jButtonUserCreate.setBounds(532, 400,266, 50);

		add(jLabelUserId);
		add(jLabelUserUsername);
		add(jLabelUserRole);
		add(jLabelUserPassword);
		add(jLabelUserName);
		add(jTextFieldUserId);
		add(jTextFieldUserUsername);
		add(jTextFieldUserRole);
		add(jTextFieldUserName);
		add(jTextFieldUserPassword);
		add(jButtonUserDelete);
		add(jButtonUserUpdate);
		add(jButtonUserCreate);
	}

	private void bookCRUD(){
		jLabelBookId = new JLabel("Book Id: ");
		jLabelBookId.setBounds(0, 750,160, 50);
		jLabelBookTitle = new JLabel("Title: ");
		jLabelBookTitle.setBounds(133, 750,160, 50);
		jLabelBookGenre = new JLabel("Genre:");
		jLabelBookGenre.setBounds(266, 750,160, 50);
		jLabelBookAuthor = new JLabel("Author");
		jLabelBookAuthor.setBounds(399, 750,160, 50);
		jLabelBookPrice = new JLabel("Price:");
		jLabelBookPrice.setBounds(532, 750,160, 50);
		jLabelBookStock = new JLabel("Stock:");
		jLabelBookStock.setBounds(665, 750,160, 50);

		jTextFieldBookId = new JTextField();
		jTextFieldBookId.setBounds(0, 800,160, 50);
		jTextFieldBookTitle = new JTextField();
		jTextFieldBookTitle.setBounds(133, 800,160, 50);
		jTextFieldBookGenre = new JTextField();
		jTextFieldBookGenre.setBounds(266, 800,160, 50);
		jTextFieldBookAuthor = new JTextField();
		jTextFieldBookAuthor.setBounds(399, 800,160, 50);
		jTextFieldBookPrice = new JTextField();
		jTextFieldBookPrice.setBounds(532, 800,160, 50);
		jTextFieldBookStock = new JTextField();
		jTextFieldBookStock.setBounds(665, 800,160, 50);

		jButtonBookDelete = new JButton("Delete");
		jButtonBookDelete.setBounds(0, 850,266, 50);
		jButtonBookUpdate = new JButton("Update");
		jButtonBookUpdate.setBounds(266, 850,266, 50);
		jButtonBookCreate = new JButton("Insert");
		jButtonBookCreate.setBounds(532, 850,266, 50);

		add(jLabelBookId);
		add(jLabelBookTitle);
		add(jLabelBookGenre);
		add(jLabelBookAuthor);
		add(jLabelBookPrice);
		add(jLabelBookStock);
		add(jTextFieldBookId);
		add(jTextFieldBookTitle);
		add(jTextFieldBookGenre);
		add(jTextFieldBookAuthor);
		add(jTextFieldBookPrice);
		add(jTextFieldBookStock);
		add(jButtonBookDelete);
		add(jButtonBookUpdate);
		add(jButtonBookCreate);
	}

	public void initComponents(){
		centerScreen();
		setResizable(false);
		setTitle("Admin View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		generateBookTable();
		generateUserTable();
		setSize(800,940);
		userCRUD();
		bookCRUD();
		setLayout(null);
		setVisible(true);
	}
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Book) {
			refreshInfoBook();
		}
		if (o instanceof User){
			refreshInfoUser();
		}
	}

	public void generateBookTable(){
		String[] column ={"Book ID","Title","Genre", "Author", "Price", "Stock"};
		bookTable=new DefaultTableModel(column,0);
		JTable jt=new JTable(bookTable);
		populateBookTable();
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 450,800, 300);
		add(sp);
	}
	public void refreshInfoBook(){
		bookTable.setRowCount(0);
		populateBookTable();
	}
	private void populateBookTable() {
		for (Model b : bookList) {
			int id = ((Book) b).getId();
			String title = ((Book) b).getTitle();
			String genre = ((Book) b).getGenre();
			String author = ((Book) b).getAuthor();
			double price = ((Book) b).getPrice();
			int stock = ((Book) b).getStock();

			Object[] data = {id,title, genre, author, price,stock};
			bookTable.addRow(data);
		}
	}

	public void generateUserTable(){
		String[] column ={"User ID","Username","Role", "Name", "Password"};
		userTable=new DefaultTableModel(column,0);
		JTable jt=new JTable(userTable);
		populateBookTable();
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 0,800, 300);
		add(sp);
	}

	public void refreshInfoUser(){
		System.out.println("IN DELETE USER REFRESH");
		userTable.setRowCount(0);
		populateUserTable();
	}
	private void populateUserTable() {
		for (Model b : userList) {
			User u=(User)b;
			int id = u.getId();
			String username = u.getUsername();
			String role = u.getRole();
			String name = u.getName();
			String password = u.getPassword();

			Object[] data = {id,username, role, name, password};
			userTable.addRow(data);
		}
	}

	private void centerScreen() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(WIDTH, HEIGHT);

		setLocation((int) (dimension.getWidth() / 2 - WIDTH / 2),
				(int) (dimension.getHeight() / 2 - HEIGHT / 2));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
