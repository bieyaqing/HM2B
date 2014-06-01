package persistance.chat;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.chat.Chat;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.Config;

public class ChatDAO {
	public static ArrayList<Chat> getAllChats(){
		ArrayList<Chat> chats = new ArrayList<Chat>();
		DetachedCriteria dc = DetachedCriteria.forClass(Chat.class);
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(dc);
		for(Object o: list){
			chats.add((Chat)o);
		}
		return chats;
	}
	
	public static Chat getChatById(long id){
		return (Chat)HibernateUtil.get(Chat.class, id);
	}
	
	public static void addChat(Chat chat){
		HibernateUtil.save(chat);
	}
	
	public static void modifyChat(Chat modifiedChat){
		HibernateUtil.update(modifiedChat);
	}
	
	public static void deleteChat(Chat chat){
		HibernateUtil.delete(chat);
	}
	
	//featured method
	
}
