package presentation_layer;

import business_layer.LoginAccountManagement;
import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.ClientMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AdminLogin extends JFrame{
	private JPanel originalPanel;
	private JLabel TitleLabel;

	private JTextField AccountIdUpdate;
	private JTextField AmountUpdate;
	private JTextField CurrencyCodeUpdate;
	private JTextField AccountStatusUpdate;
	private JTextField ClientIdUpdate;
	private JTextField AccountTypeUpdate;
	private DefaultTableModel clientTable;
	private List<Client> clientList;
	private Object[][] accountElements=new Object[13][4];
	private Object[][] clientElements=new Object[13][4];

	private DefaultTableModel accountTable;
	private List<Account> accountList;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try{
					AdminLogin loginFrame= new AdminLogin();
					loginFrame.setVisible(true);
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		});
	}

	public AdminLogin(){
		for(int x=0; x<accountElements.length; x++){
			accountElements[x][0]=new Integer(1);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Screen");
		setResizable(false);
		centerScreen();
		setAccountsTableAndButtons();
		setClientsTableAndButtons();

		setSize(800,1000);
		setLayout(null);
		setVisible(true);
		for(int x=0; x<accountElements.length; x++){
			System.out.println(accountElements[x][3].toString());
		}
	}

	public void setAccountsTableAndButtons(){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			JScrollPane sp = generateTableAccount(mappy);
			add(sp);
		} catch (DataMapperException e) {
			e.printStackTrace();
		}

		JButton insertButtonAccount = generateWidthHeightXFixedButton("Perform Insert Operation on Account",0, 300, 798, 30, this);
		insertButtonAccount.addActionListener(e -> {
//			insertOnAccount((JTextField)accountElements[0][1]).getText(),
//					((JTextField)accountElements[1][1]).getText(),
//					((JTextField)accountElements[2][1]).getText(),
//					((JTextField)accountElements[3][1]).getText(),
//					((JTextField)accountElements[4][1]).getText(),
//					((JTextField)accountElements[5][1]).getText();
		});

		JButton updateButtonAccount= generateWidthHeightXFixedButton("Perform Update Operation on Account",0, 390, 798, 30, this);
		updateButtonAccount.addActionListener(e -> {
//			updateOnAccount((JTextField)accountElements[6][1]).getText(),
//							((JTextField)accountElements[7][1]).getText(),
//							((JTextField)accountElements[8][1]).getText(),
//							((JTextField)accountElements[9][1]).getText(),
//							((JTextField)accountElements[10][1]).getText(),
//							((JTextField)accountElements[11][1]).getText();
		});

		JButton deleteButtonAccount= generateWidthHeightXFixedButton("Perform Delete Operation on Account",0, 460, 798, 30, this);
		deleteButtonAccount.addActionListener(e -> {
//			deleteOnAccount(((JTextField)accountElements[12][1]).getText());
		});

		showAccountsCrud();
	}

	private JScrollPane generateTableAccount(AccountMapper mappy) throws DataMapperException {
		String[] column ={"Account ID","Client ID","Account Status","Account Type", "Amount", "Curreny Code"};
		accountList=mappy.getAllAccountsForAll();
		accountTable=new DefaultTableModel(column,0);
		populateAccountTable();
		JTable jt=new JTable(accountTable);
		jt.setBounds(0, 30,798, 200);
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 30,798, 200);
		return sp;
	}

	public void showAccountsCrud(){
		String[] columns ={"Account ID","Client ID","Account Status","Account Type", "Amount", "Curreny Code"};
		int xCounter=0;
		for(int x=0; x<columns.length; x++){
			generateFieldAndLabel(columns[x], xCounter, 240, 133,30,xCounter,270,133, 30, "account_insert");
			xCounter += 133;
		}
		//330 ylabel ----360 ---yfield
		//240 ylabel ----270 ---yfield
		xCounter=0;
		for(int x=0; x<columns.length; x++){
			generateFieldAndLabel(columns[x], xCounter, 330, 133,30,xCounter,360,133, 30, "account_update");
			xCounter += 133;
		}
		generateFieldAndLabel("Account Id to delete:", 100,430, 200,30, 500,430, 200,30, "account_delete");
	}

	public void setClientsTableAndButtons(){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			JScrollPane sp = generateTableClients(mappy);
			add(sp);
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		JButton updateButtonClient= generateWidthHeightXFixedButton("Perform Update Operation on Client",0, 780, 798, 30, this);
		updateButtonClient.addActionListener(e -> {
//			insertOnClient((JTextField)accountElements[0][1]).getText(),
//					((JTextField)accountElements[1][1]).getText(),
//					((JTextField)accountElements[2][1]).getText(),
//					((JTextField)accountElements[3][1]).getText(),
//					((JTextField)accountElements[4][1]).getText(),
//					((JTextField)accountElements[5][1]).getText();
		});

		JButton insertButtonClient= generateWidthHeightXFixedButton("Perform Insert Operation on Client",0, 870, 798, 30, this);
		insertButtonClient.addActionListener(e -> {
//			updateOnClient((JTextField)accountElements[6][1]).getText(),
//					((JTextField)accountElements[7][1]).getText(),
//					((JTextField)accountElements[8][1]).getText(),
//					((JTextField)accountElements[9][1]).getText(),
//					((JTextField)accountElements[10][1]).getText(),
//					((JTextField)accountElements[11][1]).getText();
		});

		JButton deleteButtonClient= generateWidthHeightXFixedButton("Perform Delete Operation on Client",0, 930, 798, 30, this);
		deleteButtonClient.addActionListener(e -> {
//			deleteOnClient(((JTextField)accountElements[12][1]).getText());
		});

		showClientsCrud();
	}

	private JScrollPane generateTableClients(ClientMapper mappy) throws DataMapperException {
		String[] column ={"Client ID","Full name","Address", "CNP", "Login ID"};
		clientTable =new DefaultTableModel(column,0);
		clientList= LoginAccountManagement.getAllClients();
		populateClientTable();
		JTable jt=new JTable(clientTable);
		jt.setBounds(0, 520,800, 200);
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 520,800, 200);
		return sp;
	}

	private void updateClientTable() {
		clientTable.setRowCount(0);
		clientList= LoginAccountManagement.getAllClients();
		populateClientTable();
	}

	private void populateClientTable(){
		for (Client client : clientList) {
			int client_id = client.getClient_id();
			String full_name = client.getFull_name();
			String adress = client.getAddress();
			String cnp = client.getCNP();
			int login_Id=client.getLogin_id();
			Object[] data = {client_id, full_name, adress, cnp,login_Id};
			System.out.println("PRINTING LOOP ARRAY" + data.toString());
			clientTable.addRow(data);
		}
	}

	private void updateAccountTable() {
		accountTable.setRowCount(0);
		accountList= LoginAccountManagement.getAllAccount();
		populateClientTable();
	}

	private void populateAccountTable(){
		for (Account account : accountList) {
			int id = account.getAccount_id();
			int client_id=account.getClient_id();
			int status = account.getAccount_status();
			String acc_type = account.getAccount_type();
			float amount = account.getAmount();
			String currency = account.getCurrency_code();
			Object[] data = {id, client_id,status, acc_type, amount, currency};
			accountTable.addRow(data);
		}
	}

	public void showClientsCrud(){
		String[] columns ={"Client ID","Full name","Address", "CNP", "Login ID"};
		int xCounter=0;
		for(int x=0; x<columns.length; x++){
			generateFieldAndLabel(columns[x], xCounter, 720, 133,30,xCounter,750,133, 30,"client_insert");
			xCounter += 160;
		}
		xCounter=0;
		for(int x=0; x<columns.length; x++){
			generateFieldAndLabel(columns[x], xCounter, 810, 133,30,xCounter,840,133, 30, "client_update");
			xCounter += 160;
		}
		generateFieldAndLabel("Account Id to delete:", 100,430, 200,30, 500,430, 200,30,"client_delete");

		JTextField ClientIdToDelete=new JTextField();
		JLabel ClientIdToDeleteLabel=new JLabel("Client Id to delete:");
		ClientIdToDeleteLabel.setBounds(100,900, 200,30);
		ClientIdToDelete.setBounds(500,900, 200,30);
		add(ClientIdToDeleteLabel);
		add(ClientIdToDelete);

	}

	private JButton generateWidthHeightXFixedButton(String name, int x, int y, int width, int height, JFrame itemJoinedTo) {
		JButton insertButtonAccount = new JButton(name);
		insertButtonAccount.setBounds(x, y, width, height);
		itemJoinedTo.add(insertButtonAccount);
		return insertButtonAccount;
	}

	private void generateFieldAndLabel(String label, int xLabel, int yLabel, int widthLabel, int heightLabel, int xField, int yField, int widthField, int heightField, String labelToKnow) {
		JTextField genericField = new JTextField();
		JLabel genericLabel = new JLabel(label);
		genericLabel.setBounds(xLabel, yLabel, widthLabel, heightLabel);
		genericField.setBounds(xField, yField, widthField, heightField);
		if(labelToKnow.contains("account")) {
			constructObjectArray(label, labelToKnow, genericField, genericLabel, accountElements);
		}else{
			constructObjectArray(label, labelToKnow, genericField, genericLabel, clientElements);
		}
		add(genericField);
		add(genericLabel);
	}

	private void constructObjectArray(String label, String labelToKnow, JTextField genericField, JLabel genericLabel, Object[][] elementsArray) {
		for (int x = 0; x < elementsArray.length; x++) {
			if (elementsArray[x][0] instanceof Integer) {
				for (int y = 0; y < 4; y++) {
					if (y == 0) {
						elementsArray[x][y] = label;
					} else if (y == 1) {
						elementsArray[x][y] = genericField;
					} else if (y == 2) {
						elementsArray[x][y] = genericLabel;
					} else {
						elementsArray[x][y] = labelToKnow;
					}
				}
				break;
			}
		}
	}

	private void centerScreen(){
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(WIDTH, HEIGHT);
		setLocation((int) (dimension.getWidth() / 2 - WIDTH / 2),
				(int) (dimension.getHeight() / 2 - HEIGHT / 2));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
