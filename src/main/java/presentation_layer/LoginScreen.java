package presentation_layer;

import business_layer.LoginAccountManagement;
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
		setResizable(false);
		add(panel1);
		centerScreen();
		setTitle("Login Screen");
		setSize(600,500);

		loginButton.addActionListener(e -> {
			loginAction();
		});
	}

	private void centerScreen() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(WIDTH, HEIGHT);

		setLocation((int) (dimension.getWidth() / 2 - WIDTH / 2),
				(int) (dimension.getHeight() / 2 - HEIGHT / 2));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void createUIComponents() {
	}

	public void loginAction(){
		if(!Admin.isSelected() && !User.isSelected()){
			JOptionPane.showMessageDialog(panel1, "Please select one of the buttons");
		}else {
			Login correctLogin = LoginAccountManagement.getLoginByRole(userName.getText(), new String(password.getPassword()), Admin.isSelected() ? "admin" : "user");
			String outputString = "Password is: '" + new String(password.getPassword()) + "' username is: '" + userName.getText()
					+ "' admin? '" + Admin.isSelected() + "' user ? '" + User.isSelected() + "' status is: " + correctLogin;
			System.out.println(outputString);
			if (correctLogin.getLogin_id() != 0) {
				outputString = "Login details correct, redirecting towards the " + (Admin.isSelected() ? "admin" : "user") + " menu.";
				if ((Admin.isSelected() ? "admin" : "user").equals("user")) {
					UserLogin usy = new UserLogin(correctLogin);
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
			JOptionPane.showMessageDialog(panel1, outputString);
		}
	}
}
