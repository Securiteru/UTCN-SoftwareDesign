package presentation_layer;

import data_source_logic_layer.DBConnection;
import data_source_logic_layer.LoginMapper;
import domain_logic_layer.Login;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
	private JPanel panel1;
	private JButton loginButton;
	private JTextField userName;
	private JPasswordField password;
	private JRadioButton Admin;
	private JRadioButton User;

	public LoginScreen(){
		ButtonGroup btny=new ButtonGroup();
		btny.add(User);
		btny.add(Admin);
		add(panel1);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Login Screen");
		setSize(400,500);
		loginButton.addActionListener(e -> {
			loginAction();
		});
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
	}

	public void loginAction(){
		DBConnection conexiune = DBConnection.getConnection();
		LoginMapper mappy=new LoginMapper(conexiune);
		String passText = new String(password.getPassword());
		String loginRoute = Admin.isSelected() ? "admin" : "user";
		Login correctLogin= mappy.getLoginByRole(userName.getText(), passText, loginRoute);
		String outputString="Password is: '"+passText+ "' username is: '"+userName.getText()
				+"' admin? '"+Admin.isSelected()+"' user ? '"+User.isSelected()+"' STATUS IS: "+correctLogin;
		System.out.println(outputString);
		if(correctLogin.getLogin_id() != 0){
			outputString="Login details correct, redirecting towards the "+loginRoute+" menu.";
			if(loginRoute.equals("user")){
				UserLogin usy=new UserLogin(correctLogin);
				usy.setVisible(true);
				Point currentLoc=new Point();
				currentLoc=this.getLocation();
				usy.setLocation(currentLoc);
			}else{
				AdminLogin usy=new AdminLogin();
				usy.setVisible(true);
				Point currentLoc=new Point();
				currentLoc=this.getLocation();
				usy.setLocation(currentLoc);
			}
			dispose();
		}else{
			outputString="Login details incorrect, try again.";
		}
		JOptionPane.showMessageDialog(panel1, outputString);
	}
}
