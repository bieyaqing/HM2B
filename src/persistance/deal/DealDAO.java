package persistance.deal;

import hibernate.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.deal.Deal;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import system.Config;

public class DealDAO {
	public static ArrayList<Deal> getAllDeals() {
		ArrayList<Deal> deals = new ArrayList<Deal>();
		DetachedCriteria dc = DetachedCriteria.forClass(Deal.class);
		List<Object> list = HibernateUtil.detachedCriteriaReturnList(dc);
		for (Object o : list) {
			deals.add((Deal) o);
		}
		return deals;
	}

	public static Deal getUserById(long id) {
		return (Deal) HibernateUtil.get(Deal.class, id);
	}

	public static void addDeal(Deal deal) {
		HibernateUtil.save(deal);
	}

	public static void modifyDeal(Deal modifiedDeal) {
		HibernateUtil.update(modifiedDeal);
	}

	public static void deleteDeal(Deal deal) {
		HibernateUtil.delete(deal);
	}

	// featured method
	public static ArrayList<Deal> getDealByUser(long travellerId, long buyerId) {
		ArrayList deals = new ArrayList<Deal>();
		Deal tempDeal = null;

		DetachedCriteria detachedCriteria = DetachedCriteria
				.forClass(Deal.class);
		if (travellerId != 0) {
			detachedCriteria.add(Restrictions.eq(Config.TRAVELLERID,
					travellerId));
		}

		if (buyerId != 0) {
			detachedCriteria.add(Restrictions.eq(Config.BUYERID, buyerId));
		}

		List<Object> list = HibernateUtil
				.detachedCriteriaReturnList(detachedCriteria);

		if (travellerId == 0) {
			for (Object o : list) {
				tempDeal = (Deal) o;
				if (tempDeal.getBuyer().getUserId() == buyerId) {
					deals.add(tempDeal);
					break;
				}
			}
		}
		if (buyerId == 0) {
			for (Object o : list) {
				tempDeal = (Deal) o;
				if (tempDeal.getTraveller().getUserId() == travellerId) {
					deals.add(tempDeal);
					break;
				}
			}
		}

		if (travellerId != 0 && buyerId != 0) {
			for (Object o : list) {
				tempDeal = (Deal) o;
				if (tempDeal.getTraveller().getUserId() == travellerId
						&& tempDeal.getBuyer().getUserId() == buyerId) {
					deals.add(tempDeal);
					break;
				}
			}
		}

		return deals;
	}
}
