package bg.dao;

import com.semsq.app.DataStore;
import app.entities.User;

import java.util.List;

public class UserDao {


	public List<User> getUsers(){
		return DataStore.getUsers ();
	}


}
