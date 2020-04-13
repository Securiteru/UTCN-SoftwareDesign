package domain_logic_layer;

public class Account {
	/***************************************************************
	 * Getters and Setters
	 ***************************************************************/

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

	public int getAccount_status() {
		return account_status;
	}

	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}

	int account_id;
	int client_id;
	String account_type;
	float amount;
	String currency_code;
	int account_status;

	/***************************************************************
	 * Constructors and ToString
	 ***************************************************************/

	public Account(int account_id, int client_id, String account_type, float amount, String currency_code, int account_status) {
		this.account_id = account_id;
		this.client_id = client_id;
		this.account_type = account_type;
		this.amount = amount;
		this.currency_code = currency_code;
		this.account_status = account_status;
	}

	@Override
	public String toString() {
		return "Account{" +
				"account_id=" + account_id +
				", client_id=" + client_id +
				", account_type='" + account_type + '\'' +
				", amount=" + amount +
				", currency_code='" + currency_code + '\'' +
				", account_status=" + account_status +
				'}';
	}

	public Account(int client_id, String account_type, float amount, String currency_code, int account_status) {
		this.client_id = client_id;
		this.account_type = account_type;
		this.amount = amount;
		this.currency_code = currency_code;
		this.account_status = account_status;
	}

	public Account(int account_id) {
		this.account_id = account_id;
	}
	public Account(){}

	/***************************************************************
	 * Domain Logic Methods
	 ***************************************************************/
}
