package ProjectFinal.model;

import java.util.Objects;

public class User extends Model{
	private int id;
	private String username;
	private String password;
	private String role;
	private String name;
	private ModelStore userStore;

	public User(int id, String username, String password, String role, String name) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
	}

	public User() {
		this.id=0;
	}

	public ModelStore getUserStore() {
		userStore=new UserStore();
		return userStore;
	}

	public User setUserStore(ModelStore userStore) {
		this.userStore = userStore;
		return this;
	}

	public int getId() {
		return id;
	}

	public User setId(int id) {
		this.id = id;
		setChanged();
		notifyObservers();
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		setChanged();
		notifyObservers();
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		setChanged();
		notifyObservers();
		return this;
	}

	public String getRole() {
		return role;
	}

	public User setRole(String role) {
		this.role = role;
		setChanged();
		notifyObservers();
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers();
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return getId() == user.getId() &&
				Objects.equals(getUsername(), user.getUsername()) &&
				Objects.equals(getPassword(), user.getPassword()) &&
				Objects.equals(getRole(), user.getRole()) &&
				Objects.equals(getName(), user.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getUsername(), getPassword(), getRole(), getName());
	}

	@Override
	public Model updateModel(Model x) {
		this.setId(((User)x).getId());
		this.setName(((User)x).getName());
		this.setPassword(((User)x).getPassword());
		this.setRole(((User)x).getRole());
		this.setUsername(((User)x).getUsername());
		setChanged();
		notifyObservers();
		return this;
	}

	@Override
	public <T extends ModelStore> T returnStore() {
		return (T) userStore;
	}
}
