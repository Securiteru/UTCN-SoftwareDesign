package data_source_logic_layer;

import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Client;
import domain_logic_layer.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper extends DataMapper{
		/*
		CREATE TABLE client_table (
		client_id INT(6) UNSIGNED AUTO_INCREMENT,
		full_name VARCHAR(30) NOT NULL,
		address VARCHAR(30) NOT NULL,
		CNP VARCHAR(10) NOT NULL,
		login_id INT(6) UNSIGNED NOT NULL,
		PRIMARY KEY (client_id),
		FOREIGN KEY (login_id) REFERENCES login_table(login_id)
		);
	 */

	public ClientMapper(DBConnection conexiune) {
		super(conexiune);
		System.out.println(conexiune);
	}

		public synchronized Client findByClientId(int client_id_to_search) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
				String statement = "SELECT `full_name`, `address`, `CNP`, `login_id` FROM `client_table` where `client_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, client_id_to_search);
				ResultSet rs = dbStatement.executeQuery();
				while(rs.next()) {
					String full_name = rs.getString("full_name");
					String address = rs.getString("address");
					String CNP = rs.getString("CNP");
					int login_id = rs.getInt("login_id");
					int client_id=rs.getInt("client_id");
					Client client = new Client(client_id);
					client.setFull_name(full_name);
					client.setAddress(address);
					client.setCNP(CNP);
					client.setLogin_id(login_id);
					return client;
				}
				return null;
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}

	public synchronized Client findClientByLoginId(int login_id_to_search) throws DataMapperException {
		try {
			Connection db = conexiune.connection;
			String statement = "SELECT  `login_id`,`client_id`,`full_name`, `address`, `CNP`, `login_id` FROM `client_table` where `login_id`=?";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			dbStatement.setInt(1, login_id_to_search);
			ResultSet rs = dbStatement.executeQuery();
			while(rs.next()) {
				String full_name = rs.getString("full_name");
				String address = rs.getString("address");
				String CNP = rs.getString("CNP");
				int login_id = rs.getInt("login_id");
				int client_id=rs.getInt("client_id");
				Client client = new Client(client_id);
				client.setFull_name(full_name);
				client.setAddress(address);
				client.setCNP(CNP);
				client.setLogin_id(login_id);
				return client;
			}
			return null;
		} catch (SQLException e) {
			throw new DataMapperException("Error occured reading Students from the data source.", e);
		}
	}
		public synchronized void update(Client client) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
				String statement = "UPDATE `client_table` SET `full_name`=?, `address`=?, `CNP`=?, `login_id`=? where `client_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setString(1, client.getFull_name());
				dbStatement.setString(2, client.getAddress());
				dbStatement.setString(3, client.getCNP());
				dbStatement.setInt(4, client.getLogin_id());
				dbStatement.executeUpdate();
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}
		public synchronized void insert(Client client) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
				String statement = "INSERT INTO `client_table` (`client_id`,`full_name`, `address`, `CNP`, `login_id`) VALUES (?,?, ?, ?, ?)";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, client.getClient_id());
				dbStatement.setString(2, client.getFull_name());
				dbStatement.setString(3, client.getAddress());
				dbStatement.setString(4, client.getCNP());
				dbStatement.setInt(5, client.getLogin_id());
				dbStatement.executeUpdate();
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}
		public synchronized void delete(Client client) throws DataMapperException {
			try {
				Connection db = conexiune.connection;
				String statement = "DELETE FROM `client_table` where `client_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, client.getClient_id());
				dbStatement.executeUpdate();
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Students from the data source.", e);
			}
		}

	public synchronized List<Client> getAllClients() throws DataMapperException {
		List<Client> clientList=new ArrayList<Client>();
		try {
			Connection db = conexiune.connection;
			String statement = "SELECT `full_name`, `address`, `CNP`, `login_id` FROM `client_table`";
			PreparedStatement dbStatement = db.prepareStatement(statement);
			ResultSet rs = dbStatement.executeQuery();
			while(rs.next()) {
				String full_name = rs.getString("full_name");
				String address = rs.getString("address");
				String CNP = rs.getString("CNP");
				int login_id = rs.getInt("login_id");
				Client client = new Client(login_id);
				client.setFull_name(full_name);
				client.setAddress(address);
				client.setCNP(CNP);
				client.setLogin_id(login_id);
				clientList.add(client);
			}
		} catch (SQLException e) {
			throw new DataMapperException("Error occured reading Students from the data source.", e);
		}
		return clientList;
	}

}
