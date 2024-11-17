package bg.managers;

import app.entities.User;
import bg.constants.Gender;
import bg.constants.UserType;
import bg.dao.UserDao;

import java.util.List;

public class UserManager {
	
	private static UserManager instance=  new UserManager();
	private static UserDao userDao = new UserDao ();
	
	

	
	private UserManager() {
	}

	
	public static UserManager getInstance() {
		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}


	public User createUser(long id, String email, String password, String firstName, 
			String lastName, Gender gender,
			UserType userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setfName(firstName);
		user.setlName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		return user;
	}
	
	public List<User> getUsers(){
		return userDao.getUsers ();
	}
	
	
}
