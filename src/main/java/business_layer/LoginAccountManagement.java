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
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			return mappy.findClientByLoginId(correctLogin.getLogin_id());
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return null;
	}
	static public Login getLoginByRole(String user, String password, String role){
		DBConnection conexiune = DBConnection.getConnection();
		LoginMapper mappy=new LoginMapper(conexiune);
		return mappy.getLoginByRole(user, password, role);
	}

	static public List<Client> getAllClients(){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		try {
			return mappy.getAllClients();
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return null;
	}

	static public List<Account> getAllAccount(){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		try {
			return mappy.getAllAccountsForAll();
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
		return null;
	}
}
