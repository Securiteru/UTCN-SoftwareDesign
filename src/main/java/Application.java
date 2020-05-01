import data_source_logic_layer.DBConnection;
import domain_logic_layer.Account;
import presentation_layer.AdminLogin;
import presentation_layer.LoginScreen;
import presentation_layer.UserLogin;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Application {
	public static Scanner scanner;


	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		AdminLogin login=new AdminLogin();
		login.setVisible(true);
	}

	public static void printy(String message){
		System.out.println(message);
	}
}
