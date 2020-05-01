package business_layer;

import business_layer.exceptions.AccountDisactivatedException;
import business_layer.exceptions.AmountMissMatchException;
import business_layer.exceptions.BusinessLogicException;
import business_layer.exceptions.CurrencyMissmatchException;
import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;

import java.util.List;

public class AccountOperations {
	public static String transferMoneyBetweenAccounts(Account to, Account from, float sum){
		try {
			DBConnection conexiune = DBConnection.getConnection();
			AccountMapper accy=new AccountMapper(conexiune);
			from=accy.findByAccountId(from.getAccount_id());
			to=accy.findByAccountId(to.getAccount_id());
			System.out.println("Sending money from account id: "+from.getAccount_id()+" to: "+to.getAccount_id());
			if(!from.getCurrency_code().equals(to.getCurrency_code())){
				throw new CurrencyMissmatchException();
			}
			if(to.getAccount_status() != 1 || from.getAccount_status() != 1){
				throw new AccountDisactivatedException();
			}
			if (from.getAmount() < sum) {
				throw new AmountMissMatchException();
			}
			accy.transferBetweenAccounts(to, from, sum);
			return "Operation Successful! Transfered " + sum + " to account: " + to.getAccount_id() + " from account: " + from.getAccount_id();
		} catch (DataMapperException | BusinessLogicException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public static void getAllAccounts(){
		DBConnection conexiune = DBConnection.getConnection();
		AccountMapper mappy=new AccountMapper(conexiune);
		Client c=new Client(1);
		try {
			List<Account> accountList=mappy.getAllAccounts(c);
			accountList.forEach(account -> System.out.println(account.toString()));
		} catch (DataMapperException e) {
			e.printStackTrace();
		}
	}

	public static List<Account> getAllAccountsForAllUsers(){
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
