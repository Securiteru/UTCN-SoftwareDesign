package ProjectFinal.view;

import ProjectFinal.controller.LoginController;
import ProjectFinal.model.Book;
import ProjectFinal.model.Model;
import ProjectFinal.model.ModelStore;
import ProjectFinal.model.User;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class LoginView extends View implements java.util.Observer {
	public Model m;
	public ModelStore model;
	public ArrayList<User> userList;
	public JPanel panel1;
	public JButton loginButton;
	public JTextField userName;
	public JPasswordField password;
	public JRadioButton Admin;
	public JRadioButton User;
	public JButton registerButton;

	public LoginView(Model m, ModelStore mm){
		this.modelStore=mm;
		this.individualModel=m;
		userList= (ArrayList<User>) this.modelStore.getStoreList();
		initComponents();
	}

	private void initObservers() {
		for (User user : userList) {
			user.addObserver(this);
		}
	}

	private void initComponents() {
		ButtonGroup btny=new ButtonGroup();
		btny.add(User);
		btny.add(Admin);
		setResizable(false);
		add(panel1);
		setTitle("Login View");
		setSize(600,500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	private void refresh() {
	}

	public void addLoginCheckListener(ActionListener a) {
		loginButton.addActionListener(a);
	}

	@Override
	public void update(Observable o, Object arg) {
		userList= (ArrayList<User>) this.modelStore.getStoreList();
	}
}
