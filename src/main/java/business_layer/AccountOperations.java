package business_layer;

import business_layer.business_exceptions.AccountDisactivatedException;
import business_layer.business_exceptions.AmountMissMatchException;
import business_layer.business_exceptions.BusinessLogicException;
import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.LoginMapper;
import data_source_logic_layer.exceptions.DataMapperException;
import domain_logic_layer.Account;
import domain_logic_layer.Client;
import domain_logic_layer.Login;

import java.util.List;

public class AccountOperations {
	public static boolean transferMoneyBetweenAccounts(Account to, Account from, float sum){
		try {
			DBConnection conexiune = DBConnection.getConnection();
			AccountMapper accy=new AccountMapper(conexiune);
			Account to2=new Account();
			Account from2=new Account();
			to=accy.findByAccountId(to.getAccount_id());
			System.out.println("FOUND ACCOUNT WITH ID: "+to.getAccount_id());
			from=accy.findByAccountId(from.getAccount_id());
			System.out.println(to.toString());
			System.out.println(from.toString());
			if(to.getAccount_status() != 1 || from.getAccount_status() != 1){
				throw new AccountDisactivatedException();
			}
			if (to.getAmount() < sum) {
				throw new AmountMissMatchException();
			}
			accy.transferBetweenAccounts(to, from, sum);
			to2=accy.findByAccountId(to.getAccount_id());
			from2=accy.findByAccountId(from.getAccount_id());
			System.out.println(to2.toString());
			System.out.println(from2.toString());
		} catch (DataMapperException e) {
			e.printStackTrace();
		}catch (BusinessLogicException e2){
			System.out.println(e2.getMessage());
		}

		return true;
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
}
