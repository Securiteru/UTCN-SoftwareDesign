package presentation_layer;

import business_layer.LoginAccountManagement;
import data_source_logic_layer.DBConnection;
import data_source_logic_layer.LoginMapper;
import domain_logic_layer.Login;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
	private JPanel panel1;
	public JButton loginButton;
	public JTextField userName;
	public JPasswordField password;
	public JRadioButton Admin;
	public JRadioButton User;
	public JButton registerButton;
	private boolean mock;

	public LoginScreen(boolean mock){
		this.mock=mock;
		ButtonGroup btny=new ButtonGroup();
		btny.add(User);
		btny.add(Admin);
		setResizable(false);
		add(panel1);
		setTitle("Login Screen");
		setSize(600,500);

		registerButton.addActionListener(e -> {
			registerAction();
		});

		loginButton.addActionListener(e -> {
			loginAction();
		});

		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}


	private void createUIComponents() {
	}

	public void registerAction(){
		Register reg = new Register();
		reg.setVisible(true);
		Point currentLoc = new Point();
		currentLoc = this.getLocation();
		reg.setLocation(currentLoc);
	}

	public void loginAction(){
		if(!Admin.isSelected() && !User.isSelected()){
			if(!this.mock) {
				JOptionPane.showMessageDialog(panel1, "Please select one of the buttons");
			}
		}else {
			Login correctLogin = LoginAccountManagement.getLoginByRole(userName.getText(), new String(password.getPassword()), Admin.isSelected() ? "admin" : "user");
			String outputString = "Password is: '" + new String(password.getPassword()) + "' username is: '" + userName.getText()
					+ "' admin? '" + Admin.isSelected() + "' user ? '" + User.isSelected() + "' status is: " + correctLogin;
			System.out.println(outputString);
			if (correctLogin.getLogin_id() != 0) {
				outputString = "Login details correct, redirecting towards the " + (Admin.isSelected() ? "admin" : "user") + " menu.";
				if ((Admin.isSelected() ? "admin" : "user").equals("user")) {
					UserLogin usy = new UserLogin(correctLogin, false);
					usy.setVisible(true);
					Point currentLoc = new Point();
					currentLoc = this.getLocation();
					usy.setLocation(currentLoc);
				} else {
					AdminLogin usy = new AdminLogin();
					usy.setVisible(true);
					Point currentLoc = new Point();
					currentLoc = this.getLocation();
					usy.setLocation(currentLoc);
				}
				dispose();
			} else {
				outputString = "Login details incorrect, try again.";
			}
			if(!this.mock) {
				JOptionPane.showMessageDialog(panel1, outputString);
			}
		}
	}
}
