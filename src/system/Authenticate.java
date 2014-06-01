package system;

import model.user.User;
import persistance.user.UserDAO;

public class Authenticate {
	public static boolean authenticateUser(String email, String password){
		boolean authenticate = false;
		User user = UserDAO.getUserByEmail(email);
		String compareHash = Encrypt.generateSaltedHash(password, user.getPasswordSalt());
		if(compareHash.equals(user.getPasswordHash())){
			authenticate = true;
		}
		
		return authenticate;
	}
}
