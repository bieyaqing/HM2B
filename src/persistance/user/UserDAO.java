package persistance.user;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

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
	public static User getUserByName(String name){
		User user = null;
		User tempUser = null;
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		if(name != null){
			detachedCriteria.add(Restrictions.eq(Config.NAME, name));
		}
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(detachedCriteria);
		
		for(Object o : list){
			tempUser = (User)o;
			if(tempUser.getName().equals(name)){
				user = tempUser;
				break;
			}
		}
		return user;
	}
}
