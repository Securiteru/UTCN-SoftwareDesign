package presentation_layer;

import business_layer.LoginAccountManagement;
import domain_logic_layer.Client;
import domain_logic_layer.Login;

import javax.swing.*;

public class Register extends  JFrame{
	private JTextField username;
	private JTextField password;
	private JRadioButton Admin;
	private JRadioButton User;
	private JButton Register;
	private JPanel Panel;

	public Register(){
		ButtonGroup btny=new ButtonGroup();
		btny.add(User);
		btny.add(Admin);
		setResizable(false);
		setTitle("Register Screen");
		setSize(600,500);
		Register.addActionListener(e->{
			boolean status=false;
			Login l=new Login( username.getText(),password.getText(),Admin.isSelected() ? "admin" : "user");
			Login ll=LoginAccountManagement.createLogin(l);
			if(ll.getLogin_id() !=0){
				Client c=new Client();
				c.setLogin_id(ll.getLogin_id());
				c.setAddress("");
				c.setCNP("");
				c.setFull_name("");
				LoginAccountManagement.createClient(c);
				status=true;
			}
			JOptionPane.showMessageDialog(Panel, status ? "Account created successful." : "Account creation failed.");
		});
		this.add(Panel);
		this.setVisible(true);
	}
}
