package business_layer;

import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.ClientMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;

public class DBCrud {
	public static String insertOnAccount(Account aci){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		String status="Success";
		try {
			mappy.insert(aci);
			return status;
		} catch (DataMapperException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static String updateOnAccount(Account aci){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		String status="Success";
		try {
			mappy.update(aci);
			return status;
		} catch (DataMapperException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static String deleteOnAccount(Account aci){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		String status="Success";
		try {
			mappy.delete(aci);
			return status;
		} catch (DataMapperException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static String insertOnClient(Client cli){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		String status="Success";
		try {
			mappy.insert(cli);
			return status;
		} catch (DataMapperException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static String updateOnClient(Client cli){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		String status="Success";
		try {
			mappy.update(cli);
			return status;
		} catch (DataMapperException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static String deleteOnClient(Client cli){
		DBConnection conexiune = DBConnection.getConnection();
		ClientMapper mappy=new ClientMapper(conexiune);
		String status="Success";
		try {
			mappy.delete(cli);
			return status;
		} catch (DataMapperException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
