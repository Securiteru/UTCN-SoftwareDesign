import business_layer.AccountOperations;
import business_layer.LoginAccountManagement;
import domain_logic_layer.Account;
import domain_logic_layer.Client;
import domain_logic_layer.Login;
import org.junit.*;

import static org.junit.Assert.assertNotEquals;

public class TransferOperationTest {

	public static Account a=new Account();
	public static Account a2=new Account();
	public static Account a3=new Account();
	public static Login l=new Login();
	public static Client c=new Client();


	@BeforeClass
	public static void init() {
		l.setUsername("test_user");
		l.setPassword("test_password");
		l.setUser_role("user");
		l.setLogin_id(999);
		l=LoginAccountManagement.createLogin(l);

		c.setFull_name("test_name");
		c.setCNP("test_cnp");
		c.setAddress("test_address");
		c.setLogin_id(999);
		c.setClient_id(999);
		LoginAccountManagement.createClientFixed(c);

		a.setAmount(300);
		a.setAccount_id(999);
		a.setClient_id(999);
		a.setAccount_status(1);
		a.setAccount_type("Depozit");
		a.setCurrency_code("EUR");

		a2.setAmount(500);
		a2.setClient_id(999);
		a2.setAccount_id(9999);
		a2.setAccount_status(1);
		a2.setAccount_type("Depozit");
		a2.setCurrency_code("EUR");

		a3.setAmount(500);
		a3.setClient_id(999);
		a3.setAccount_id(99999);
		a3.setAccount_status(2);
		a3.setAccount_type("Depozit");
		a3.setCurrency_code("EUR");


		LoginAccountManagement.createAccountFixed(a);
		LoginAccountManagement.createAccountFixed(a2);
		LoginAccountManagement.createAccountFixed(a3);
	}

	@Test
	public void userScreenTransferMoney(){
		Assert.assertEquals(AccountOperations.transferMoneyBetweenAccounts(a,a2,300), "Operation Successful! Transfered "+ "300.0" + " to account: " + a.getAccount_id() + " from account: " + a2.getAccount_id());
	}

	@Test
	public void userScreenFailTransferMoney(){
		Assert.assertEquals(AccountOperations.transferMoneyBetweenAccounts(a,a3,300), "Error :::::: One of the required accounts is inactive.");
	}

	@AfterClass
	public static void finish() {
		LoginAccountManagement.deleteAccount(a);
		LoginAccountManagement.deleteAccount(a2);
		LoginAccountManagement.deleteAccount(a3);
		LoginAccountManagement.deleteClient(c);
		LoginAccountManagement.deleteLogin(l);
	}
}
