package testing;

import persistance.user.UserDAO;
import model.user.User;

public class UserTesting {
	public static void main(String[] args){
		User user = new User();
		
		UserDAO.addUser(user);
	}
}
