package ProjectFinal.controller;

import ProjectFinal.model.Book;
import ProjectFinal.model.BookStore;
import ProjectFinal.model.Model;
import ProjectFinal.model.ModelStore;
import ProjectFinal.view.AdminView;
import ProjectFinal.view.UserView;
import ProjectFinal.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminController {
	private View view;
	private Model model;

	public AdminController(View view, Model model) {
		this.view = view;
		this.model = model;

		AdminView v=(AdminView)view;
		v.addUserDeleteListener(new deleteUserListener());
		v.addUserCreateListener(new createUserListener());
		v.addUserUpdateListener(new updateUserListener());

		v.addBookDeleteListener(new deleteBookListener());
		v.addBookCreateListener(new createBookListener());
		v.addBookUpdateListener(new updateBookListener());
	}

	class deleteUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdminView v=(AdminView)view;
			JOptionPane.showMessageDialog(v, v.userStore.deleteFromStore(v.getUserObject()) ? "Deletion Successful!" : "Deletion Failed!");
			v.userList=v.userStore.getStoreList();
			v.refreshInfoUser();
		}
	}

	class createUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdminView v=(AdminView)view;
			JOptionPane.showMessageDialog(v, v.userStore.insertInStore(v.getUserObject()) ? "Creation Successful!" : "Creation Failed!");
			v.userList=v.userStore.getStoreList();
			v.refreshInfoUser();
		}
	}

	class updateUserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdminView v=(AdminView)view;
			JOptionPane.showMessageDialog(v, v.userStore.insertInStore(v.getUserObject()) ? "Update Successful!" : "Update Failed!");
			v.getUserObject();
			v.userStore.updateInStore(v.getUserObject());
		}
	}

	class deleteBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdminView v=(AdminView)view;
			JOptionPane.showMessageDialog(v, v.bookStore.deleteFromStore(v.getBookObject()) ? "Delete Successful!" : "Deletion Failed!");
			v.bookList=v.bookStore.getStoreList();
			v.refreshInfoBook();
		}
	}

	class createBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdminView v=(AdminView)view;
			JOptionPane.showMessageDialog(v, v.bookStore.insertInStore(v.getBookObject()) ? "Create Successful!" : "Create Failed!");
			v.bookList=v.bookStore.getStoreList();
			v.refreshInfoBook();
		}
	}

	class updateBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			AdminView v=(AdminView)view;
			JOptionPane.showMessageDialog(v, v.bookStore.updateInStore(v.getBookObject()) ? "Update Successful!" : "Update Failed!");
		}
	}
}
