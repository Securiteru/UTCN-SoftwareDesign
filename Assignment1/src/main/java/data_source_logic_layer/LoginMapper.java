package data_source_logic_layer;

import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Login;
import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  LoginMapper extends DataMapper {

	public LoginMapper(DBConnection conexiune) {
		super(conexiune);
	}

	public synchronized Login findByLoginId(int id) throws DataMapperException {
			try {
				Connection db = this.conexiune.connection;
				String statement = "SELECT `login_id`, `username`, `password`, `user_role` FROM `login_table` where `login_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, id);
				ResultSet rs = dbStatement.executeQuery();
				while(rs.next()) {
					int login_id = rs.getInt("login_id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String user_role = rs.getString("user_role");
					Login login = new Login(login_id);
					login.setUsername(username);
					login.setPassword(password);
					login.setUser_role(user_role);
					return login;
				}
				return null;
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Login from the data source.", e);
			}
		}

		public synchronized Login findByUsernamePasswordCombination(String username, String password) throws DataMapperException{
			try {
				Connection db = this.conexiune.connection;
				String statement = "SELECT `login_id`, `username`, `password`, `user_role` FROM `login_table` where `username` =? and `password` =?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setString(1, username);
				dbStatement.setString(2, password);
				ResultSet rs = dbStatement.executeQuery();
				while(rs.next()) {
					int login_id = rs.getInt("login_id");
					String returned_username = rs.getString("username");
					String returned_password = rs.getString("password");
					String user_role = rs.getString("user_role");
					Login login = new Login(login_id);
					login.setUsername(returned_username);
					login.setPassword(returned_password);
					login.setUser_role(user_role);
					return login;
				}
				return null;
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Login from the data source.", e);
			}
		}

		public synchronized void update(Login login) throws DataMapperException {
			try {
				Connection db = this.conexiune.connection;
				String statement = "UPDATE `login_table` SET `user_role`=?, `username`=?, `password`=? where `login_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setString(1, login.getUser_role());
				dbStatement.setString(2, login.getUsername());
				dbStatement.setString(3, login.getUsername());
				dbStatement.setInt(4, login.getLogin_id());
				dbStatement.executeUpdate();
			} catch (SQLException e) {
				throw new DataMapperException("Error occured updating Login from the data source.", e);
			}
		}
		public synchronized Login insert(Login login) throws DataMapperException {
			try {
				Connection db = this.conexiune.connection;
				String statement = "INSERT INTO `login_table` (`login_id`, `username`, `password`, `user_role`) VALUES (?, ?, ?, ?)";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, login.getLogin_id());
				dbStatement.setString(2, login.getUsername());
				dbStatement.setString(3, login.getPassword());
				dbStatement.setString(4, login.getUser_role());
				dbStatement.executeUpdate();

				return this.findByUsernamePasswordCombination(login.getUsername(), login.getPassword());
			} catch (SQLException e) {
				throw new DataMapperException("Error occured inserting Login from the data source.", e);
			}
		}
		public synchronized void delete(Login login) throws DataMapperException {
			try {
				Connection db = this.conexiune.connection;
				String statement = "DELETE FROM `login_table` where `login_id`=?";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				dbStatement.setInt(1, login.getLogin_id());
				dbStatement.executeUpdate();
			} catch (SQLException e) {
				throw new DataMapperException("Error occured deleting Login from the data source.", e);
			}
		}

		public synchronized List<Login> getAllLogins() throws DataMapperException {
		List<Login> loginList=new ArrayList<Login>();
			try {
				Connection db = this.conexiune.connection;
				String statement = "SELECT `login_id`, `username`, `password`, `user_role` FROM `login_table`";
				PreparedStatement dbStatement = db.prepareStatement(statement);
				ResultSet rs = dbStatement.executeQuery();
				while(rs.next()) {
					int login_id = rs.getInt("login_id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String user_role = rs.getString("user_role");
					Login login = new Login(login_id);
					login.setUsername(username);
					login.setPassword(password);
					login.setUser_role(user_role);
					loginList.add(login);
				}
			} catch (SQLException e) {
				throw new DataMapperException("Error occured reading Login from the data source.", e);
			}
		return loginList;
		}

	public synchronized Login getLoginByRole(String username, String password, String role_wanted) {

		try {
			Connection db = this.conexiune.connection;

			String sql = "SELECT `login_id`,`user_role` FROM login_table WHERE (username = ? and password = ?)";
			PreparedStatement prepSt = db.prepareStatement(sql);

			prepSt.setString(1, username);
			prepSt.setString(2, password);

			ResultSet rs = prepSt.executeQuery();

			String role = "";
			if (rs.next()) {
				role = rs.getString("user_role");
				int login_id = rs.getInt("login_id");
				Login loggy=new Login(login_id);
				loggy.setUser_role(role);
				loggy.setLogin_id(login_id);
				if (role.equals(role_wanted)) {
					return loggy;
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Login();
	}

}
