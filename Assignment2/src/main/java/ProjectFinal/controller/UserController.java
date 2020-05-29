package ProjectFinal.controller;

import ProjectFinal.model.Book;
import ProjectFinal.model.BookStore;
import ProjectFinal.model.Model;
import ProjectFinal.model.ModelStore;
import ProjectFinal.view.UserView;
import ProjectFinal.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserController {
	private View view;
	private Model model;

	public UserController(View view, Model model) {
		this.view = view;
		this.model = model;

		((UserView)view).addSellBookListener(new sellBookListener());
		((UserView)view).addSearchBookListener(new searchBookListener());
	}

	class sellBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Selling Book");
			for (Book book : ((UserView)view).bookList) {
				if(book.getId()==((UserView)view).getId()){
					System.out.println("Found book");
					if(book.getStock()>0){
						book.sellBook();
						JOptionPane.showMessageDialog(((UserView)view), "Book sold!");
					}else{
						JOptionPane.showMessageDialog(((UserView)view), "Book couldn't be sold! Stock is 0.");
					}
				}
			}
		}
	}

	class searchBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ModelStore ms=((UserView)view).modelStore;
			System.out.println("Size pre search: "+((UserView)view).bookList.size());
			((UserView)view).bookList= ((BookStore)ms).searchBook(((UserView)view).searchString.getText());
			System.out.println("Size post search: "+((UserView)view).bookList.size());
			((UserView)view).refreshInfo();
		}
	}
}
