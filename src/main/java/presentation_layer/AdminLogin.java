package presentation_layer;

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
	/*
	The administrator user can perform the following operations:
	- CRUD on clients information (name, identity card number, personal numerical code, address, etc.).
	- Create/update/delete/view clients' accounts.
	*/


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Screen");
		JButton gg=new JButton("Show Accounts list");
		gg.setBounds(0,0,798,30);
		add(gg);
		gg.addActionListener(e -> {
			showAllAccountsTable();
		});

		JButton g=new JButton("Show Customer list");
		g.setBounds(0,490,798,30);
		add(g);
		g.addActionListener(e->{
			setClientsTableAndButtons();
		});

		setSize(800,1000);
		setLayout(null);
		setVisible(true);
	}

	public void showAllAccountsTable(){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			List<Account> accountList=mappy.getAllAccountsForAll();
			String[] column ={"Account ID","Client ID","Account Status","Account Type", "Amount", "Curreny Code"};
			DefaultTableModel tabby=new DefaultTableModel(column,0);
			for (Account account : accountList) {
				int id = account.getAccount_id();
				int client_id=account.getClient_id();
				int status = account.getAccount_status();
				String acc_type = account.getAccount_type();
				float amount = account.getAmount();
				String currency = account.getCurrency_code();

				Object[] data = {id, client_id,status, acc_type, amount, currency};
				System.out.println("PRINTING LOOP ARRAY" + data.toString());
				tabby.addRow(data);
			}
			JTable jt=new JTable(tabby);
			jt.setBounds(0, 30,798, 200);
			JScrollPane sp=new JScrollPane(jt);
			sp.setBounds(0, 30,798, 200);
			add(sp);
		} catch (DataMapperException e) {
			e.printStackTrace();
		}

		JButton insertButtonAccount = new JButton("Perform Insert Operation on Account");
		insertButtonAccount.setBounds(0, 300, 798, 30);
		add(insertButtonAccount);
		insertButtonAccount.addActionListener(e -> {

		});

		JButton updateButtonAccount=new JButton("Perform Update Operation on Account");
		updateButtonAccount.setBounds(0,390,798,30);
		add(updateButtonAccount);
		updateButtonAccount.addActionListener(e -> {

		});

		JButton deleteButtonAccount=new JButton("Perform Delete Operation on Account");
		deleteButtonAccount.setBounds(0,460,798,30);
		add(deleteButtonAccount);
		deleteButtonAccount.addActionListener(e -> {

		});
		showAccountsCrud();
	}

	public void showAccountsCrud(){
		this.AccountIdUpdate =new JTextField();
		this.ClientIdUpdate=new JTextField();
		this.AccountStatusUpdate =new JTextField();
		this.AmountUpdate =new JTextField();
		this.CurrencyCodeUpdate =new JTextField();
		this.AccountTypeUpdate =new JTextField();

		JLabel AccountIdLabel=new JLabel("AccountId:");
		JLabel ClientIdLabel=new JLabel("ClientId:");
		JLabel AccountStatusLabel=new JLabel("AccountStatus:");
		JLabel AccountTypeLabel=new JLabel("Account Type:");
		JLabel AmountLabel=new JLabel("Amount:");
		JLabel CurrencyCodeLabel=new JLabel("CurrencyCode:");

		AccountIdLabel.setBounds(0,330, 133,30);
		ClientIdLabel.setBounds(133,330, 133,30);
		AccountStatusLabel.setBounds(266,330, 133,30);
		AccountTypeLabel.setBounds(399,330, 133,30);
		AmountLabel.setBounds(532,330, 133,30);
		CurrencyCodeLabel.setBounds(665,330, 133,30);

		AccountIdUpdate.setBounds(0,360, 130,30);
		ClientIdUpdate.setBounds(133,360, 130,30);
		AccountStatusUpdate.setBounds(266,360, 130,30);
		AccountTypeUpdate.setBounds(399,360, 130,30);
		AmountUpdate.setBounds(532,360, 130,30);
		CurrencyCodeUpdate.setBounds(665,360, 130,30);

		add(AccountIdUpdate);
		add(ClientIdUpdate);
		add(AccountStatusUpdate);
		add(AccountTypeUpdate);
		add(AmountUpdate);
		add(CurrencyCodeUpdate);

		add(AccountIdLabel);
		add(ClientIdLabel);
		add(AccountStatusLabel);
		add(AccountTypeLabel);
		add(AmountLabel);
		add(CurrencyCodeLabel);

		JTextField AccountIdInsert=new JTextField();
		JTextField ClientIdInsert=new JTextField();
		JTextField AccountStatusInsert=new JTextField();
		JTextField AmountInsert=new JTextField();
		JTextField CurrencyCodeInsert=new JTextField();
		JTextField AccountTypeInsert=new JTextField();

		JLabel AccountIdLabelInsert=new JLabel("AccountId:");
		JLabel ClientIdLabelInsert=new JLabel("ClientId:");
		JLabel AccountStatusLabelInsert=new JLabel("AccountStatus:");
		JLabel AccountTypeLabelInsert=new JLabel("Account Type:");
		JLabel AmountLabelInsert=new JLabel("Amount:");
		JLabel CurrencyCodeLabelInsert=new JLabel("CurrencyCode:");

		AccountIdLabelInsert.setBounds(0,240, 133,30);
		ClientIdLabelInsert.setBounds(133,240, 133,30);
		AccountStatusLabelInsert.setBounds(266,240, 133,30);
		AccountTypeLabelInsert.setBounds(399,240, 133,30);
		AmountLabelInsert.setBounds(532,240, 133,30);
		CurrencyCodeLabelInsert.setBounds(665,240, 133,30);

		AccountIdInsert.setBounds(0,270, 130,30);
		ClientIdInsert.setBounds(133,270, 130,30);
		AccountStatusInsert.setBounds(266,270, 130,30);
		AccountTypeInsert.setBounds(399,270, 130,30);
		AmountInsert.setBounds(532,270, 130,30);
		CurrencyCodeInsert.setBounds(665,270, 130,30);

		add(AccountIdInsert);
		add(ClientIdInsert);
		add(AccountStatusInsert);
		add(AccountTypeInsert);
		add(AmountInsert);
		add(CurrencyCodeInsert);

		add(AccountIdLabelInsert);
		add(ClientIdLabelInsert);
		add(AccountStatusLabelInsert);
		add(AccountTypeLabelInsert);
		add(AmountLabelInsert);
		add(CurrencyCodeLabelInsert);

		JTextField AccountIdToDelete=new JTextField();
		JLabel AccountIdToDeleteLabel=new JLabel("Account Id to delete:");
		AccountIdToDeleteLabel.setBounds(100,430, 200,30);
		AccountIdToDelete.setBounds(500,430, 200,30);
		add(AccountIdToDelete);
		add(AccountIdToDeleteLabel);
	}

	public void setClientsTableAndButtons(){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			List<Client> clientList=mappy.getAllClients();
			String[] column ={"Client ID","Full name","Address", "CNP", "Login ID"};
			DefaultTableModel tabby=new DefaultTableModel(column,0);
			for (Client client : clientList) {
				int client_id = client.getClient_id();
				String full_name = client.getFull_name();
				String adress = client.getAddress();
				String cnp = client.getCNP();
				int login_Id=client.getLogin_id();
				Object[] data = {client_id, full_name, adress, cnp,login_Id};
				System.out.println("PRINTING LOOP ARRAY" + data.toString());
				tabby.addRow(data);
			}
			JTable jt=new JTable(tabby);
			jt.setBounds(0, 520,800, 200);
			JScrollPane sp=new JScrollPane(jt);
			sp.setBounds(0, 520,800, 200);
			add(sp);
		} catch (DataMapperException e) {
			e.printStackTrace();
		}

		JButton gg=new JButton("Perform Update Operation on Client");
		gg.setBounds(0,720,800,30);
		add(gg);
		gg.addActionListener(e -> { });

		JButton ggg=new JButton("Perform Insert Operation on Client");
		ggg.setBounds(0,870,800,30);
		add(ggg);
		ggg.addActionListener(e -> { });

		JButton gggg=new JButton("Perform Delete Operation on Client");
		gggg.setBounds(0,930,800,30);
		add(gggg);
		gggg.addActionListener(e -> { });
		showClientsCrud();
	}

	public void showClientsCrud(){
		JTextField ClientIdInsert=new JTextField();
		JTextField LoginIdInsert=new JTextField();
		JTextField FullNameInsert=new JTextField();
		JTextField AddressInsert=new JTextField();
		JTextField CNPInsert=new JTextField();

		JLabel ClientIdLabelInsert=new JLabel("Client ID:");
		JLabel LoginIdLabelInsert=new JLabel("Login ID:");
		JLabel FullNameLabelInsert=new JLabel("Full name");
		JLabel AddressLabelInsert=new JLabel("Address");
		JLabel CNPLabelInsert=new JLabel("CNP");

		ClientIdLabelInsert.setBounds(0,750, 160,30);
		LoginIdLabelInsert.setBounds(160,750, 160,30);
		FullNameLabelInsert.setBounds(320,750, 160,30);
		AddressLabelInsert.setBounds(480,750, 160,30);
		CNPLabelInsert.setBounds(640,750, 160,30);

		ClientIdInsert.setBounds(0,780, 160,30);
		LoginIdInsert.setBounds(160,780, 160,30);
		FullNameInsert.setBounds(320,780, 160,30);
		AddressInsert.setBounds(480,780, 160,30);
		CNPInsert.setBounds(640,780, 160,30);

		add(ClientIdLabelInsert);
		add(LoginIdLabelInsert);
		add(FullNameLabelInsert);
		add(AddressLabelInsert);
		add(CNPLabelInsert);

		add(ClientIdInsert);
		add(LoginIdInsert);
		add(FullNameInsert);
		add(AddressInsert);
		add(CNPInsert);

		JTextField ClientIdUpdate=new JTextField();
		JTextField LoginIdUpdate=new JTextField();
		JTextField FullNameUpdate=new JTextField();
		JTextField AddressUpdate=new JTextField();
		JTextField CNPUpdate=new JTextField();

		JLabel ClientIdLabelUpdate=new JLabel("Client ID:");
		JLabel LoginIdLabelUpdate=new JLabel("Login ID:");
		JLabel FullNameLabelUpdate=new JLabel("Full name");
		JLabel AddressLabelUpdate=new JLabel("Address");
		JLabel CNPLabelUpdate=new JLabel("CNP");

		ClientIdLabelUpdate.setBounds(0,810, 160,30);
		LoginIdLabelUpdate.setBounds(160,810, 160,30);
		FullNameLabelUpdate.setBounds(320,810, 160,30);
		AddressLabelUpdate.setBounds(480,810, 160,30);
		CNPLabelUpdate.setBounds(640,810, 160,30);

		ClientIdUpdate.setBounds(0,840, 160,30);
		LoginIdUpdate.setBounds(160,840, 160,30);
		FullNameUpdate.setBounds(320,840, 160,30);
		AddressUpdate.setBounds(480,840, 160,30);
		CNPUpdate.setBounds(640,840, 160,30);

		add(ClientIdLabelUpdate);
		add(LoginIdLabelUpdate);
		add(FullNameLabelUpdate);
		add(AddressLabelUpdate);
		add(CNPLabelUpdate);

		add(ClientIdUpdate);
		add(LoginIdUpdate);
		add(FullNameUpdate);
		add(AddressUpdate);
		add(CNPUpdate);

		JTextField ClientIdToDelete=new JTextField();
		JLabel ClientIdToDeleteLabel=new JLabel("Client Id to delete:");
		ClientIdToDeleteLabel.setBounds(100,900, 200,30);
		ClientIdToDelete.setBounds(500,900, 200,30);
		add(ClientIdToDeleteLabel);
		add(ClientIdToDelete);

	}
}
