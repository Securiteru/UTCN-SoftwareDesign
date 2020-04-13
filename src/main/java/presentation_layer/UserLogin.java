package presentation_layer;

import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.DataMapper;
import data_source_logic_layer.LoginMapper;
import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;
import domain_logic_layer.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import static business_layer.AccountOperations.transferMoneyBetweenAccounts;

public class UserLogin extends JFrame{
	private JLabel TitleLabel;
	private JPanel originalPanel;
	private JButton showUserDetailsButton;
	private JButton showAllAccountsButton;
	private JScrollBar scrollBar1;
	private JButton back;
	private boolean tableShow=false;

	/*
	The regular user can perform the following operations:
	- View all accounts (account information: identification number, type, amount of money, date of creation).
	- Transfer money between accounts.
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

//	public UserLogin(Login correctLogin) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
////		setBounds(100, 100, 800, 900);
//		setTitle("User Screen");
//		JButton b=new JButton("Click Here to return");
//		b.setBounds(10,10,95,30);
//		add(b);
//		b.addActionListener(e -> {
//
//		});
//
////		transferMoneyBetweenAccounts(Account to, Account from, float sum);
//	}
	public UserLogin(Login correctLogin) {
		setTitle("User Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton g=new JButton("Show Transfer option");
		g.setBounds(0,330,400,30);
		add(g);
		g.addActionListener(e->{
			showTransfer();
		});

		JButton gg=new JButton("Show Accounts list");
		gg.setBounds(0,0,400,30);
		add(gg);
		gg.addActionListener(e -> {
			showTable();
		});

		setSize(400,550);
		setLayout(null);
		setVisible(true);
	}
	public void showTable(){
		Client cly=new Client();
		cly.setClient_id(1);
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			List<Account> accountList=mappy.getAllAccounts(cly);
			String[] column ={"Account ID","Account Type","Amount", "Currency Code", "Account Status"};
			DefaultTableModel tabby=new DefaultTableModel(column,0);
			for (Account account : accountList) {
				int status = account.getAccount_status();
				int id = account.getAccount_id();
				String acc_type = account.getAccount_type();
				float amount = account.getAmount();
				String currency = account.getCurrency_code();
				Object[] data = {id, status, acc_type, amount, currency};
				System.out.println("PRINTING LOOP ARRAY" + data.toString());
				tabby.addRow(data);
			}
			JTable jt=new JTable(tabby);
			jt.setBounds(0, 30,400, 300);
			JScrollPane sp=new JScrollPane(jt);
			sp.setBounds(0, 30,400, 300);

			if(!tableShow){
				tableShow=true;
				add(sp);
				System.out.println("Showing table");
			}else{
				System.out.println("Hiding table");
				tableShow=false;
				sp.setVisible(false);
				this.remove(sp);
			}

		} catch (DataMapperException e) {
			e.printStackTrace();
		}
	}
	public void showTransfer(){
		JTextField accountFrom=new JTextField();
		JTextField accountTo=new JTextField();
		JTextField amount=new JTextField();

		JLabel accountFromLabel=new JLabel("Account From:");
		JLabel accountToLabel=new JLabel("Account To:");
		JLabel amountLabel=new JLabel("Account Amount:");


		accountFrom.setBounds(150,360, 250,30);
		accountTo.setBounds(150,400, 250,30);
		amount.setBounds(150,440, 250,30);

		accountFromLabel.setBounds(0,360, 150,30);
		accountToLabel.setBounds(0,400, 150,30);
		amountLabel.setBounds(0,440, 150,30);

		add(accountFrom);
		add(accountTo);
		add(amount);

		accountFromLabel.setVisible(true);
		accountToLabel.setVisible(true);
		amountLabel.setVisible(true);

		revalidate();
		add(accountFromLabel);
		add(accountToLabel);
		add(amountLabel);

		JButton gg=new JButton("Transfer");
		gg.setBounds(0,470,400,30);
		add(gg);
		gg.addActionListener(e->{
			Account to=new Account(Integer.parseInt(accountTo.getText()));
			Account from=new Account(Integer.parseInt(accountFrom.getText()));
			float sum=Float.parseFloat(amount.getText());
			System.out.println("SUM IS "+sum);
			transferMoneyBetweenAccounts(to, from,sum);
		});
	}

}
