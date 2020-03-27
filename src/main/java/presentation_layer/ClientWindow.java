package presentation_layer;

import domain_logic_layer.Login;

public class ClientWindow  extends ConsoleView{
	public void loginCorrect(Login login) {
		System.out.println(
				"*****Welcome to the Client Menu*****\n"
		);
	}
}
