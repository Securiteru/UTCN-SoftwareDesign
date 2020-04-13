import data_source_logic_layer.DBConnection;
import domain_logic_layer.Account;
import presentation_layer.AdminLogin;
import presentation_layer.LoginScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static business_layer.AccountOperations.getAllAccounts;
import static business_layer.AccountOperations.transferMoneyBetweenAccounts;


public class Application {
	public static Scanner scanner;


	public static void main(String[] args) {
//		DBConnection conexiune = DBConnection.getConnection();
//		Account acc1=new Account();
//		Account acc2=new Account();
//		getAllAccounts();
//		boolean t= transferMoneyBetweenAccounts(acc1, acc2, 15);
//
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		AdminLogin login=new AdminLogin();
		login.setLocationRelativeTo(null);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	public static void printy(String message){
		System.out.println(message);
	}
}
