package domain_logic_layer;

public class Client {
	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String CNP) {
		this.CNP = CNP;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	int client_id;
	String full_name;
	String address;
	String CNP;
	int login_id;

	@Override
	public String toString() {
		return "Client{" +
				"client_id=" + client_id +
				", full_name='" + full_name + '\'' +
				", address='" + address + '\'' +
				", CNP='" + CNP + '\'' +
				", login_id=" + login_id +
				'}';
	}

	public Client(int client_id, String full_name, String address, String CNP, int login_id) {
		this.client_id = client_id;
		this.full_name = full_name;
		this.address = address;
		this.CNP = CNP;
		this.login_id = login_id;
	}

	public Client(String full_name, String address, String CNP, int login_id) {
		this.full_name = full_name;
		this.address = address;
		this.CNP = CNP;
		this.login_id = login_id;
	}

	public Client(int client_id) {
		this.client_id = client_id;
	}
/***************************************************************
	 * Domain Logic Methods
	 ***************************************************************/


}


