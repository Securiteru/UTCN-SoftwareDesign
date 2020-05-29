package ProjectFinal.model;

import ProjectFinal.utilities.XmlParser;

import java.util.ArrayList;

public class UserStore extends ModelStore{
	private static ArrayList<User> userRepo;
	private static boolean isListset=false;


	public UserStore(){
		if(!isListset) {
			userRepo = XmlParser.getUsersFromXml();
			isListset=true;
		}
	}

	public boolean insertInStore(User u){
		userRepo.add(u);
		return true;
	}

	public boolean deleteFromStore(User u){
		System.out.println("Delete from Store");
		int contor=0;
		for (User user : userRepo) {
			if(user.getId()==u.getId()){
				userRepo.remove(contor);
				System.out.println("remove index: "+contor);
				return true;
			}
			contor++;
		}
		return false;
	}

	public boolean updateInStore(User u){
		for (User user : userRepo) {
			if(user.getId()==u.getId()){
				user.setUsername(u.getUsername());
				user.setRole(u.getRole());
				user.setName(u.getName());
				user.setPassword(u.getPassword());
				return true;
			}
		}
		return false;
	}

	public User matchUserByCombination(String username, String password, String role) {
		for (User u : userRepo) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password) && u.getRole().equals(role)){
				return u;
			}
		}
		return new User();
	}

	@Override
	public ArrayList<User> getStoreList() {
		return userRepo;
	}
}
