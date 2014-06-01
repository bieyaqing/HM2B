package persistance.offer;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.offer.Offer;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.Config;

public class OfferDAO {
	public static ArrayList<Offer> getAllOffers(){
		ArrayList<Offer> offers = new ArrayList<Offer>();
		DetachedCriteria dc = DetachedCriteria.forClass(Offer.class);
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(dc);
		for(Object o: list){
			offers.add((Offer)o);
		}
		return offers;
	}
	
	public static Offer getOfferById(long id){
		return (Offer)HibernateUtil.get(Offer.class, id);
	}
	
	public static void addOffer(Offer offer){
		HibernateUtil.save(offer);
	}
	
	public static void modifyOffer(Offer modifiedOffer){
		HibernateUtil.update(modifiedOffer);
	}
	
	public static void deleteOffer(Offer offer){
		HibernateUtil.delete(offer);
	}
	
	//featured method
	
}
