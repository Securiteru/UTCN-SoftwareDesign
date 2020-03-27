import presentation_layer.LoginWindow;
import data_source_logic_layer.DBConnection;

import java.util.Scanner;


public class Application {
	public static Scanner scanner;

	public static void main(String[] args) {
		DBConnection conexiune = DBConnection.getConnection();

		scanner = new Scanner(System.in);
		System.out.println(
				"*****Meniu selectie operatie*****\n" +
						"*1.LOGIN* \n" +
						"*2.EXIT* \n" +
						"*********************************\n"
		);
		int opcode=scanner.nextInt();
		switch(opcode){
			case 1:
				printy("You have chosen login");
				LoginWindow Login=new LoginWindow();
				Login.receiveLogin(scanner);
				break;
			case 2:
				printy("Please come again! Thank You!\n*********************************\n");
				System.exit(0);;
				break;

		}
	}
	public static void printy(String message){
		System.out.println(message);
	}
}
