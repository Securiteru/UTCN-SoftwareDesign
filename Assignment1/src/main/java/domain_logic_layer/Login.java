package domain_logic_layer;

public class Login {

	public Login(){
		this.login_id=0;
	}

	public Login(int login_id) {
		this.login_id = login_id;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	int login_id;
	String username;
	String password;
	String user_role;

	public Login(int login_id, String username, String password, String user_role) {
		this.login_id = login_id;
		this.username = username;
		this.password = password;
		this.user_role = user_role;
	}

	public Login(String username, String password, String user_role) {
		this.username = username;
		this.password = password;
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "Login{" +
				"login_id=" + login_id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", user_role='" + user_role + '\'' +
				'}';
	}

	/***************************************************************
	 * Domain Logic Methods
	 ***************************************************************/
}
