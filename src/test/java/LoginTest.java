import business_layer.LoginAccountManagement;
import data_source_logic_layer.AccountMapper;
import data_source_logic_layer.ClientMapper;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.LoginMapper;
import data_source_logic_layer.exceptions.DataMapperException;

import domain_logic_layer.Login;
import org.junit.BeforeClass;
import org.junit.Test;
import presentation_layer.LoginScreen;
import presentation_layer.UserLogin;

import static org.junit.Assert.*;

public class LoginTest {

	@Test
	public void loginCorrect(){
		String username="username";
		String password="password";
		String role="admin";
		Login correctLogin = LoginAccountManagement.getLoginByRole(username, password, role);
		assertNotEquals(correctLogin.getLogin_id(),0);
	}

	@Test
	public void loginIncorrect(){
		String username="username";
		String password="password";
		String role="user";
		Login correctLogin = LoginAccountManagement.getLoginByRole(username, password, role);
		assertEquals(correctLogin.getLogin_id(),0);
	}

	@Test
	public void loginFlowCorrect(){
		LoginScreen screeny=new LoginScreen(true);
		screeny.userName.setText("username");
		screeny.password.setText("password");
		screeny.Admin.setSelected(true);
		screeny.loginButton.doClick();
//		System.out.println("VALID "+screeny.isValid());
//		System.out.println("DISPLAYABLE "+screeny.isDisplayable());
//		System.out.println("ACTIVE "+screeny.isActive());
//		System.out.println("FOCUSED "+screeny.isFocused());
//		System.out.println("VISIBLE "+screeny.isVisible());

		assertFalse(screeny.isVisible());
	}

	@Test
	public void loginFlowIncorrect(){
		LoginScreen screeny=new LoginScreen(true);
		screeny.userName.setText("username");
		screeny.password.setText("password");
		screeny.Admin.setSelected(false);
		screeny.loginButton.doClick();
		assertTrue(screeny.isVisible());
		screeny.dispose();
	}
}
