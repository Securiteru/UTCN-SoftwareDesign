package presentation_layer;

import business_layer.LoginAccountManagement;
import data_source_logic_layer.*;
import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;
import domain_logic_layer.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static business_layer.AccountOperations.transferMoneyBetweenAccounts;

public class UserLogin extends JFrame{
	private JLabel TitleLabel;
	private JPanel originalPanel;
	private JButton showUserDetailsButton;
	private JButton showAllAccountsButton;
	private JScrollBar scrollBar1;
	private JButton back;
	private DefaultTableModel accountsTable;
	private List<Account> userAccounts;
	private int loggedClientId;

	public int getLoggedClientId() {
		return loggedClientId;
	}

	public void setLoggedClientId(int loggedClientId) {
		this.loggedClientId = loggedClientId;
	}

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

	public UserLogin(Login correctLogin) {
		this.setLoggedClientId(Objects.requireNonNull(LoginAccountManagement.getClientFromLogin(correctLogin)).getClient_id());
		centerScreen();
		setResizable(false);
		setTitle("User Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		showTable();
		showTransfer();

		setSize(400,500);
		setLayout(null);
		setVisible(true);
	}
	public void showTable(){
		userAccounts= LoginAccountManagement.getAllAccountsFromClient(this.getLoggedClientId());
		String[] column ={"Account ID","Account Type","Amount", "Currency Code", "Account Status"};
		accountsTable=new DefaultTableModel(column,0);
		populateAccountsTable();
		JTable jt=new JTable(accountsTable);
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 0,400, 300);
		add(sp);
	}

	public void showTransfer(){
		System.out.println("IN SHOW TRANSFER");
		JTextField accountFrom=new JTextField();
		JTextField accountTo=new JTextField();
		JTextField amount=new JTextField();

		JLabel accountFromLabel=new JLabel("Account From:");
		JLabel accountToLabel=new JLabel("Account To:");
		JLabel amountLabel=new JLabel("Account Amount:");


		accountFrom.setBounds(150,310, 250,30);
		accountTo.setBounds(150,350, 250,30);
		amount.setBounds(150,390, 250,30);

		accountFromLabel.setBounds(0,310, 150,30);
		accountToLabel.setBounds(0,350, 150,30);
		amountLabel.setBounds(0,390, 150,30);

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
		gg.setBounds(0,430,400,30);
		add(gg);
		gg.addActionListener(e->{
			Account to=new Account(Integer.parseInt(accountTo.getText()));
			Account from=new Account(Integer.parseInt(accountFrom.getText()));
			float sum=Float.parseFloat(amount.getText());
			System.out.println("SUM IS "+sum);
			String success=transferMoneyBetweenAccounts(to, from,sum);
			updateAccountTable();
			JOptionPane.showMessageDialog(this, success);
		});
	}

	private void updateAccountTable() {
		accountsTable.setRowCount(0);
		userAccounts= LoginAccountManagement.getAllAccountsFromClient(this.getLoggedClientId());
		populateAccountsTable();
	}

	private void populateAccountsTable() {
		for (Account account : this.userAccounts) {
			int status = account.getAccount_status();
			int id = account.getAccount_id();
			String acc_type = account.getAccount_type();
			float amount = account.getAmount();
			String currency = account.getCurrency_code();
			Object[] data = {id, status, acc_type, amount, currency};
			System.out.println("PRINTING LOOP ARRAY" + Arrays.toString(data));
			accountsTable.addRow(data);
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
