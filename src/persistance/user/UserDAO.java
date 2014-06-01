package persistance.user;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.user.User;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.Config;

public class UserDAO {
	public static ArrayList<User> getAllUsers(){
		ArrayList<User> users = new ArrayList<User>();
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(dc);
		for(Object o: list){
			users.add((User)o);
		}
		return users;
	}
	
	public static User getUserById(long id){
		return (User)HibernateUtil.get(User.class, id);
	}
	
	public static void addUser(User user){
		HibernateUtil.save(user);
	}
	
	public static void modifyUser(User modifiedUser){
		HibernateUtil.update(modifiedUser);
	}
	
	public static void deleteUser(User user){
		HibernateUtil.delete(user);
	}
	
	//featured method
	//userbyuemail
	public static User getUserByEmail(String email){
		User user = null;
		User tempUser = null;
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		if(email != null){
			detachedCriteria.add(Restrictions.eq(Config.EMAIL, email));
		}
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(detachedCriteria);
		
		for(Object o : list){
			user = (User)o;
			if(user.getEmail().equals(email)){
				user = tempUser;
				break;
			}
		}
		return user;
	}
	
	public static User getUserByName(String lastName, String firstName){
		User user = null;
		User tempUser = null;
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		if(lastName != null){
			detachedCriteria.add(Restrictions.eq(Config.LASTNAME, lastName));
		}
		if(firstName != null){
			detachedCriteria.add(Restrictions.eq(Config.FIRSTNAME, firstName));
		}
		
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(detachedCriteria);
		
		for(Object o : list){
			user = (User)o;
			if(user.getLastName().equals(lastName) || user.getFirstName().equals(firstName)){
				user = tempUser;
				break;
			}
		}
		return user;
	}
	
}
