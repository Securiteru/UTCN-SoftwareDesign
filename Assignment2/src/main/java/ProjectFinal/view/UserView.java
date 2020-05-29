package ProjectFinal.view;

import ProjectFinal.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class UserView extends View implements java.util.Observer{
	public Model individualModel;
	public ModelStore modelStore;
	public JButton searchButton;
	public JButton sellButton;
	public JTextField searchString;
	public JTextField sellBookId;
	public ArrayList<Book> bookList;
	public DefaultTableModel bookTable;

//	public static void main(String[] args) {
//
////		UserView uv2=new UserView(b, b.getBookStore());
////		uv2.innerView=uv2;
//	}

	@Override
	public void update(Observable o, Object arg) {
		refreshInfo();
	}

	public void addSellBookListener(ActionListener a) {
		sellButton.addActionListener(a);
	}

	public void addSearchBookListener(ActionListener a) {
		searchButton.addActionListener(a);
	}

	public int getId(){
		return Integer.parseInt(sellBookId.getText());
	}

	public UserView(Model m, ModelStore mm){
		this.modelStore=mm;
		this.individualModel=m;
		bookList= (ArrayList<Book>) this.modelStore.getStoreList();
		initComponents();
		initObservers();
	}

	private void initObservers() {
		for (Book book : bookList) {
			book.addObserver(this);
		}
	}

	public void refreshInfo() {
		bookTable.setRowCount(0);
		populateBookTable();
	}

	private void initComponents() {
		centerScreen();
		setResizable(false);
		setTitle("Employee View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		generateTable();
		searchBookInterface();
		sellBookInterface();
		setSize(600,435);
		setLayout(null);
		setVisible(true);
	}

	private void searchBookInterface(){
		searchString=new JTextField();
		searchString.setBounds(0, 300,200, 50);
		add(searchString);

		searchButton=new JButton("Search by content");
		searchButton.setBounds(200, 300,200, 50);
		add(searchButton);
	}

	private void sellBookInterface(){
		sellBookId=new JTextField();
		sellBookId.setBounds(0, 350,200, 50);
		add(sellBookId);

		sellButton=new JButton("Sell Book");
		sellButton.setBounds(200, 350,200, 50);
		add(sellButton);
	}

	public void generateTable(){
		String[] column ={"Book ID","Title","Genre", "Author", "Price", "Stock"};
		bookTable=new DefaultTableModel(column,0);
		JTable jt=new JTable(bookTable);
		populateBookTable();
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 0,600, 300);
		add(sp);
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

	private void centerScreen() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(WIDTH, HEIGHT);

		setLocation((int) (dimension.getWidth() / 2 - WIDTH / 2),
				(int) (dimension.getHeight() / 2 - HEIGHT / 2));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
