package presentation_layer.cli_login;

import domain_logic_layer.Login;

public class AdminWindowCLI extends ConsoleViewCLI {
	public void loginCorrect(Login login) {
		System.out.println(
				"*****Welcome to the Admin Menu*****\n"
		);
	}
}
