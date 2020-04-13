package presentation_layer;

import data_source_logic_layer.exceptions.DataMapperException;
import data_source_logic_layer.LoginMapper;
import domain_logic_layer.Login;
import data_source_logic_layer.DBConnection;

import java.util.Scanner;

public class LoginWindowCLI extends ConsoleViewCLI {
	public static Scanner scanner;
	public static DBConnection conexiune;

	public void receiveLogin(Scanner scanner) {
		System.out.println(
				"*****Welcome to the Login Menu*****\n"
		);

		boolean loginTry = true;
		while (loginTry) {
			String username = scanner.nextLine();
			System.out.println("Thank you, now please input your password\n");
			String password = scanner.nextLine();
			LoginMapper mappy=new LoginMapper(conexiune);
			Login login = null;
			try {
				login = mappy.findByUsernamePasswordCombination(username, password);

				if (login != null) {
					if (login.getUser_role().equals("admin")) {
						AdminWindowCLI adminWindowCLI = new AdminWindowCLI();
						adminWindowCLI.loginCorrect(login);
					} else if (login.getUser_role().equals("client")) {
						ClientWindowCLI clientWindowCLI = new ClientWindowCLI();
						clientWindowCLI.loginCorrect(login);
					} else {
						System.out.println(
								"Unfortunately that username-password combination does not match anything on record, would you like to try again? Type Yes or No\n");
						String retry = scanner.nextLine();
						if (retry.equals("No")) {
							loginTry = false;
						}
					}
				}
			} catch (DataMapperException dataMapper) {
				dataMapper.printStackTrace();
			} finally {
				System.out.println(
						"Please come again! Thank You!\n*********************************\n"
				);
			}
		}
	}
}