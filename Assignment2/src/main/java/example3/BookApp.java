package example3;

import example3.model.Book;
import example3.view.*;
import example3.controller.*;


public class BookApp {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Book model = new Book(1, "Omul in cautarea sensului vietii", "Frankl", 2006, 70, 14);

//		RegularView rView = new RegularView(model);
//		AdminView aView = new AdminView(model);
//		AdminView aView2 = new AdminView(model);
//
//		new AdminController(aView, model);
//		new AdminController(aView2, model);
//		rView.setVisible(true);
//		aView.setVisible(true);
//		aView2.setVisible(true);
	}
}