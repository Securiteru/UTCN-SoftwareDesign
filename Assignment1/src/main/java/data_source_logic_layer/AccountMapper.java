package data_source_logic_layer;

import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountMapper extends DataMapper{
	/*
		CREATE TABLE account_table (
		account_id INT(6) UNSIGNED AUTO_INCREMENT,
		client_id INT(6) UNSIGNED NOT NULL,
		account_type VARCHAR(15) NOT NULL,
		amount FLOAT(6) NOT NULL,
		currency_code VARCHAR(3) NOT NULL,
		account_status TINYINT,
		PRIMARY KEY (account_id),
		FOREIGN KEY (client_id) REFERENCES client_table(client_id)
		);
	 */


	public AccountMapper(DBConnection conexiune) {
		super(conexiune);
		System.out.println(conexiune);
	}

	public synchronized Account findByAccountId(int id) throws DataMapperException {
		try {
			Connection db = this.conexiune.connection;
			String statement = "SELECT `account_id`, `client_id`, `account_type`, `amount`, `currency_code`, `account_status` FROM `account_table` where `account_id`=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, id);
			ResultSet rs = dbStatement.executeQuery();
			while(rs.next()) {
				return getAccount(rs);
			}
			return null;
		} catch (SQLException e) {
			throw new DataMapperException("Error occurred while reading Account from the data source.", e);
		}
	}
	public synchronized void insertFixed(Account account) throws DataMapperException {
		try {
			Connection db = this.conexiune.connection;
			String statement = "INSERT INTO `account_table` (`client_id`, `account_type`, `amount`, `currency_code` , `account_status`,`account_id`) VALUES (?, ?, ?, ?, ?,?)";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, account.getClient_id());
			dbStatement.setString(2, account.getAccount_type());
			dbStatement.setFloat(3, account.getAmount());
			dbStatement.setString(4, account.getCurrency_code());
			dbStatement.setInt(5, account.getAccount_status());
			dbStatement.setInt(6, account.getAccount_id());
			dbStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataMapperException("Error occurred while inserting Account from the data source.", e);
		}
	}

	public synchronized void update(Account account) throws DataMapperException {
		try {
			Connection db = this.conexiune.connection;
			String statement = "UPDATE `account_table` SET `client_id`=?, `account_type`=?, `amount`=? , `currency_code`=?, `account_status`=? where `account_id`=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, account.getClient_id());
			dbStatement.setString(2, account.getAccount_type());
			dbStatement.setFloat(3, account.getAmount());
			dbStatement.setString(4, account.getCurrency_code());
			dbStatement.setInt(5, account.getAccount_status());
			dbStatement.setInt(6, account.getAccount_id());
			dbStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataMapperException("Error occurred while updating Account from the data source.", e);
		}
	}
	public synchronized void insert(Account account) throws DataMapperException {
		try {
			Connection db = this.conexiune.connection;
			String statement = "INSERT INTO `account_table` (`client_id`, `account_type`, `amount`, `currency_code` , `account_status`) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, account.getClient_id());
			dbStatement.setString(2, account.getAccount_type());
			dbStatement.setFloat(3, account.getAmount());
			dbStatement.setString(4, account.getCurrency_code());
			dbStatement.setInt(5, account.getAccount_status());
			dbStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataMapperException("Error occurred while inserting Account from the data source.", e);
		}
	}
	public synchronized void delete(Account account) throws DataMapperException {
		try {
			Connection db = this.conexiune.connection;
			String statement = "DELETE FROM `account_table` where `account_id`=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, account.getAccount_id());
			dbStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DataMapperException("Error occurred while deleting Account from the data source.", e);
		}
	}

	public synchronized void transferBetweenAccounts(Account to,Account from, float amount) throws DataMapperException {
		try {
			Connection db = this.conexiune.connection;
			db.setAutoCommit(false);

			float total=to.getAmount()+amount;
			float withdraw=from.getAmount()-amount;
			System.out.println("WITHDRAWING FROM 'TO':"+to.getAccount_id()+" transfering 'FROM' "+from.getAccount_id()+" total to have: "+total+" TOTAL TO WITHDRAW"+withdraw);
			String statement = "UPDATE `account_table` SET `amount`=? where `account_id`=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setFloat(1, total);
			dbStatement.setInt(2, to.getAccount_id());
			dbStatement.executeUpdate();
			String statement2 = "UPDATE `account_table` SET `amount`=? where `account_id`=?";
			PreparedStatement dbStatement2 = db.prepareStatement(statement2);
			dbStatement2.setFloat(1, from.getAmount()-amount);
			dbStatement2.setInt(2, from.getAccount_id());
			dbStatement2.executeUpdate();
			db.commit();
			db.setAutoCommit(true);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	public synchronized List<Account> getAllAccounts(Client client) throws DataMapperException {
		System.out.println("GET ALL ACOUNTS WITH ID: "+client.getClient_id());
		List<Account> accountList=new ArrayList<Account>();
		try {
			Connection db = this.conexiune.connection;
			String statement = "SELECT `account_id`, `client_id`, `account_type`, `amount`, `currency_code`, `account_status` FROM `account_table` where `client_id`=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, client.getClient_id());
			ResultSet rs = dbStatement.executeQuery();
			while(rs.next()) {
				accountList.add(getAccount(rs));
			}
		} catch (SQLException e) {
			throw new DataMapperException("Error occurred while reading all Accounts for a Client from the data source.", e);
		}
		return accountList;
	}

	public synchronized List<Account> getAllAccountsForAll() throws DataMapperException {
		List<Account> accountList=new ArrayList<Account>();
		try {
			Connection db = this.conexiune.connection;
			String statement = "SELECT `account_id`, `client_id`, `account_type`, `amount`, `currency_code`, `account_status` FROM `account_table`";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();
			while(rs.next()) {
				accountList.add(getAccount(rs));
			}
		} catch (SQLException e) {
			throw new DataMapperException("Error occurred while reading all Accounts from the data source.", e);
		}
		return accountList;
	}

	private Account getAccount(ResultSet rs) throws SQLException {
		int account_id = rs.getInt("account_id");
		int client_id = rs.getInt("client_id");
		String account_type = rs.getString("account_type");
		float amount = rs.getFloat("amount");
		String currency_code = rs.getString("currency_code");
		int account_status = rs.getInt("account_status");
		Account account = new Account(account_id);
		account.setClient_id(client_id);
		account.setAccount_type(account_type);
		account.setAmount(amount);
		account.setCurrency_code(currency_code);
		account.setAccount_status(account_status);
		return account;
	}
}
