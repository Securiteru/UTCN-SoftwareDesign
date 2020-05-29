package ProjectFinal;


import ProjectFinal.controller.AdminController;
import ProjectFinal.controller.UserController;
import ProjectFinal.controller.LoginController;
import ProjectFinal.model.Book;
import ProjectFinal.model.User;
import ProjectFinal.model.UserStore;
import ProjectFinal.view.AdminView;
import ProjectFinal.view.LoginView;
import ProjectFinal.view.UserView;

import java.awt.geom.GeneralPath;

public class App {
	public static void main(String[] args) {
		///mai multe login-uri odata
		///ori fara login
		//deschide mai multe view-uri sa se vada observable.
		///amandoua ----user si book din XML

		User u=new User();
		Book b=new Book();
		UserView uv=new UserView(b, b.getBookStore());
		UserController g=new UserController(uv,b);

		LoginView lv=new LoginView(u,u.getUserStore());
		LoginController lc=new LoginController(lv,u);

		AdminView av=new AdminView((UserStore)u.getUserStore(),u,b.getBookStore(), b);
		AdminController ac=new AdminController(av,u);
//
//		UserView uView = new UserView(b,b.getBookStore());
//		LoginView lView = new LoginView(u,u.getUserStore());
//		AdminView aView = new AdminView(b,b.getBookStore());

	}
}
