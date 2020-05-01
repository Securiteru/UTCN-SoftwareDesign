package presentation_layer;

import business_layer.LoginAccountManagement;
import domain_logic_layer.Account;
import domain_logic_layer.Login;
import presentation_layer.exceptions.InputInvalidException;
import presentation_layer.exceptions.PresentationLayerException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
		accountTableShow();
		accountTransferOptionsShow();

		setSize(600,500);
		setLayout(null);
		setVisible(true);
	}
	public void accountTableShow(){
		userAccounts= LoginAccountManagement.getAllAccountsFromClient(this.getLoggedClientId());
		String[] column ={"Account ID","Account Type","Amount", "Currency Code", "Account Status"};
		accountsTable=new DefaultTableModel(column,0);
		populateAccountsTable();
		JTable jt=new JTable(accountsTable);
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(0, 0,600, 300);
		add(sp);
	}

	public void accountTransferOptionsShow(){
		JTextField accountFrom=new JTextField();
		JTextField accountTo=new JTextField();
		JTextField amount=new JTextField();

		JLabel accountFromLabel=new JLabel("Account From:");
		JLabel accountToLabel=new JLabel("Account To:");
		JLabel amountLabel=new JLabel("Account Amount:");


		accountFrom.setBounds(200,310, 300,30);
		accountTo.setBounds(200,350, 300,30);
		amount.setBounds(200,390, 300,30);

		accountFromLabel.setBounds(10,310, 200,30);
		accountToLabel.setBounds(10,350, 200,30);
		amountLabel.setBounds(10,390, 200,30);

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
		gg.setBounds(0,430,600,30);
		add(gg);
		gg.addActionListener(e->{
			String status="";
			try {
				if (accountTo.getText().equals("") || accountFrom.getText().equals("") ||
						accountTo.getText().equals(" ") || accountFrom.getText().equals(" ")) {
					throw new InputInvalidException();
				}
				Account to=new Account(Integer.parseInt(accountTo.getText()));
				Account from=new Account(Integer.parseInt(accountFrom.getText()));


				float sum = Float.parseFloat(amount.getText());
				System.out.println("In transfer between account functionality  from account id: " + to.getAccount_id() + "" +
						" to account id " + from.getAccount_id() + " sum is: " + sum);
				status = transferMoneyBetweenAccounts(to, from, sum);
				updateAccountTable();

			}catch (PresentationLayerException ex){
				status=ex.getMessage();
				ex.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, status);
		});
	}

	private void updateAccountTable() {
		accountsTable.setRowCount(0);
		userAccounts= LoginAccountManagement.getAllAccountsFromClient(this.getLoggedClientId());
		populateAccountsTable();
	}

	private void populateAccountsTable() {
		System.out.println("PRINTING LOOP ARRAY");
		for (Account account : this.userAccounts) {
			int status = account.getAccount_status();
			int id = account.getAccount_id();
			String acc_type = account.getAccount_type();
			float amount = account.getAmount();
			String currency = account.getCurrency_code();
			Object[] data = {id,acc_type, amount, currency, status};
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
