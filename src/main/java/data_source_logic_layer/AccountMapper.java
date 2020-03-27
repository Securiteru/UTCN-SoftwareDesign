package data_source_logic_layer;

import domain_logic_layer.Account;
import domain_logic_layer.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper {
	public static DBConnection conexiune;

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
		conexiune = DBConnection.getConnection();
	}
		public static synchronized Account findByAccountId(int id) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
				String statement = "SELECT `account_id`, `client_id`, `account_type`, `amount`, `currency_code`, `account_status` FROM `account_table` where `account_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, id);
				ResultSet rs = dbStatement.executeQuery();
				while(rs.next()) {
					int account_id = rs.getInt("account_id");
					int client_id = rs.getInt("client_id");
					String account_type = rs.getString("account_type");
					float amount = rs.getFloat("amount");
					String currency_code = rs.getString("currency_code");
					int account_status = rs.getInt("account_status");
					Account account = new Account(account_id);
					account.setClient_id(client_id);
					account.setAccount_type(account_type);
					account.setCurrency_code(currency_code);
					account.setAccount_status(account_status);
					return account;
				}
				return null;
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}
		public synchronized void update(Account account) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
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
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}
		public synchronized void insert(Account account) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
				String statement = "INSERT INTO `account_table` (`client_id`, `account_type`, `amount`, `currency_code` , `account_status`) VALUES (?, ?, ?, ?, ?)";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, account.getClient_id());
				dbStatement.setString(2, account.getAccount_type());
				dbStatement.setFloat(3, account.getAmount());
				dbStatement.setString(4, account.getCurrency_code());
				dbStatement.setInt(5, account.getAccount_status());
				dbStatement.executeUpdate();
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}
		public synchronized void delete(Account account) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
				String statement = "DELETE FROM `account_table` where `client_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, account.getClient_id());
				dbStatement.executeUpdate();
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}

}
