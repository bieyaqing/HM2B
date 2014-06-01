package persistance.travel;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.travel.Travel;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.Config;

public class TravelDAO {
	public static ArrayList<Travel> getAllTravels(){
		ArrayList<Travel> travels = new ArrayList<Travel>();
		DetachedCriteria dc = DetachedCriteria.forClass(Travel.class);
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(dc);
		for(Object o: list){
			travels.add((Travel)o);
		}
		return travels;
	}
	
	public static Travel getTravelById(long id){
		return (Travel)HibernateUtil.get(Travel.class, id);
	}
	
	public static void addTravel(Travel travel){
		HibernateUtil.save(travel);
	}
	
	public static void modifyTravel(Travel modifiedTravel){
		HibernateUtil.update(modifiedTravel);
	}
	
	public static void deleteTravel(Travel travel){
		HibernateUtil.delete(travel);
	}
	
	//featured method
}
