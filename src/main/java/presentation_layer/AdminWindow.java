package presentation_layer;

import domain_logic_layer.Login;

public class AdminWindow extends ConsoleView{
	public void loginCorrect(Login login) {
		System.out.println(
				"*****Welcome to the Admin Menu*****\n"
		);
	}
}
