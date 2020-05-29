package example3.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import example3.model.Book;
import example3.view.AdminView;


public class AdminController {
	private AdminView view;
	private Book model;

	public AdminController(AdminView view, Book model) {
		this.view = view;
		this.model = model;

		this.view.addUpdateBookListener(new UpdateBookListener());
	}

	class UpdateBookListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			model.updateBook(view.getId(),
					view.getTitle(),
					view.getAuthor(),
					view.getYear(),
					view.getPrice(),
					view.getState());
		}
	}
}
