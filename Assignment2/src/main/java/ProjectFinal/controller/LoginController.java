package ProjectFinal.controller;

import ProjectFinal.model.*;
import ProjectFinal.view.LoginView;
import ProjectFinal.view.UserView;
import ProjectFinal.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
	private View view;
	private Model model;

	public LoginController(View view, Model model) {
		this.view = view;
		this.model = model;

		((LoginView)view).addLoginCheckListener(new checkLoginListener());
	}

	class checkLoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			LoginView v=(LoginView)view;
			ModelStore ms=v.modelStore;
			if(!v.Admin.isSelected() && !v.User.isSelected() ){
				JOptionPane.showMessageDialog(v.panel1, "Please select one of the buttons");
				return ;
			}
			User u=((UserStore)ms).matchUserByCombination(
					v.userName.getText(),
					v.password.getText(),
					v.Admin.isSelected() ? "admin" : "user"
			);
			if(u.getId()!= 0){
				JOptionPane.showMessageDialog(v.panel1, "Authentification Successful");
			}else{
				JOptionPane.showMessageDialog(v.panel1, "Combination of username-password-role not found");
			}
		}
	}
}
