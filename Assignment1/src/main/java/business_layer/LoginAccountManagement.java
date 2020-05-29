package business_layer;

import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.ClientMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.LoginMapper;
import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;
import domain_logic_layer.Login;

import java.util.List;

public class LoginAccountManagement {
	static public List<Account> getAllAccountsFromClient(int client_id){
		Client cly=new Client();
		cly.setClient_id(client_id);
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			return mappy.getAllAccounts(cly);
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return null;
	}

	static public Client getClientFromLogin(Login correctLogin){
		System.out.println("in get client from login");
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			System.out.println("LOGIN ID "+correctLogin.getLogin_id());
			return mappy.findClientByLoginId(correctLogin.getLogin_id());
		} catch (DataMapperException e) {
			System.out.println(e.toString());
		}
		return null;
	}
	static public Login getLoginByRole(String user, String password, String role){
		DBConnection conexiune = DBConnection.getConnection();
		LoginMapper mappy=new LoginMapper(conexiune);
		return mappy.getLoginByRole(user, password, role);
	}

	static public List<Client> getAllClientsForAll(){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			return mappy.getAllClients();
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return null;
	}

	static public List<Account> getAllAccountsForAll(){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			return mappy.getAllAccountsForAll();
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return null;
	}

	static public boolean createLogin(String password, String username, String role){
		DBConnection conexiune = DBConnection.getConnection();
		LoginMapper mappy=new LoginMapper(conexiune);
		Login log=new Login();
		log.setPassword(password);
		log.setUsername(username);
		log.setUser_role(role);
		try {
			mappy.insert(log);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}

	static public Login createLogin(Login l){
		DBConnection conexiune = DBConnection.getConnection();
		LoginMapper mappy=new LoginMapper(conexiune);
		try {
			return mappy.insert(l);
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return new Login();
	}

	static public boolean createAccount(Account a){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			mappy.insert(a);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}

	static public boolean createAccountFixed(Account a){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			mappy.insertFixed(a);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}


	static public boolean createClient(Client c){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			mappy.insert(c);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}
	static public boolean createClientFixed(Client c){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			mappy.insertFixed(c);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}



	static public boolean deleteClient(Client c){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			mappy.delete(c);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}

	static public boolean deleteAccount(Account a){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			mappy.delete(a);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}

	static public boolean deleteLogin(Login l){
		DBConnection conexiune = DBConnection.getConnection();
		LoginMapper mappy=new LoginMapper(conexiune);
		try {
			mappy.delete(l);
			return true;
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return false;
	}
}
