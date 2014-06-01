package persistance.credit;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.credit.Credit;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.Config;

public class CreditDAO {
	public static ArrayList<Credit> getAllCredits(){
		ArrayList<Credit> credits = new ArrayList<Credit>();
		DetachedCriteria dc = DetachedCriteria.forClass(Credit.class);
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(dc);
		for(Object o: list){
			credits.add((Credit)o);
		}
		return credits;
	}
	
	public static Credit getCreditById(long id){
		return (Credit)HibernateUtil.get(Credit.class, id);
	}
	
	public static void addCredit(Credit credit){
		HibernateUtil.save(credit);
	}
	
	public static void modifyCredit(Credit modifiedCredit){
		HibernateUtil.update(modifiedCredit);
	}
	
	public static void deleteCredit(Credit credit){
		HibernateUtil.delete(credit);
	}
	
	//featured method
	
}
