package persistance.item;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.item.Item;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.Config;

public class ItemDAO {
	public static ArrayList<Item> getAllItems(){
		ArrayList<Item> items = new ArrayList<Item>();
		DetachedCriteria dc = DetachedCriteria.forClass(Item.class);
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(dc);
		for(Object o: list){
			items.add((Item)o);
		}
		return items;
	}
	
	public static Item getItemById(long id){
		return (Item)HibernateUtil.get(Item.class, id);
	}
	
	public static void addItem(Item item){
		HibernateUtil.save(item);
	}
	
	public static void modifyItem(Item modifiedItem){
		HibernateUtil.update(modifiedItem);
	}
	
	public static void deleteItem(Item item){
		HibernateUtil.delete(item);
	}
	
	//featured method
	
}
