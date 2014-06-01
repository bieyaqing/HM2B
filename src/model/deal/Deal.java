package model.deal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import model.chat.Chat;
import model.item.Item;
import model.offer.Offer;
import model.travel.Travel;
import model.user.User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.Config;

public class Deal {
	private long dealId; // Primary key. Generated unique id
	private Item item;
	private Travel travel; // Foreign key. Generated unique id for travel table
	private User traveller; // Foreign key. Generated unique id for user table
	private User buyer; // Foreign key. Generated unique id for user table
	private Set<Offer> offers; // Offer objects with offers and prices made
	private float price; // User input item price
	private User offeredBy; // Foreign key. System input for user
	private Set<Chat> chats;
	private int status; // System input status for deal status
	private String remarks; // Standard utility variables
	private Date createDate; // Standard utility variables

	public Deal() {

	}

	public Deal(Item item, Travel travel, User traveller, User buyer,
			Set<Offer> offers, float price, User offeredBy,
			Set<Chat> chats, int status, String remarks) {
		super();
		this.item = item;
		this.travel = travel;
		this.traveller = traveller;
		this.buyer = buyer;
		this.offers = offers;
		this.price = price;
		this.offeredBy = offeredBy;
		this.chats = chats;
		this.status = status;
		this.remarks = remarks;
		try {
			this.createDate = Config.SDF.parse(Config.SDFLOCAL
					.format(new Date()));
		} catch (Exception e) {
			this.createDate = new Date();
			e.printStackTrace();
		}
	}

	// method
	public JSONObject toJson() {
		JSONObject returnJson = new JSONObject();

		returnJson.put(Config.DEALID, this.dealId);
		returnJson.put(Config.ITEMID, this.item.getItemId());
		returnJson.put(Config.TRAVELID, this.travel.getTravelId());
		returnJson.put(Config.TRAVELLERID, this.traveller.getUserId());
		returnJson.put(Config.BUYERID, this.buyer.getUserId());
		returnJson.put(Config.PRICE, this.price);
		returnJson.put(Config.OFFEREDBY, offeredBy);
		returnJson.put(Config.STATUS, status);
		returnJson.put(Config.REMARKS, this.remarks);
		returnJson.put(Config.CREATEDATE,
				Config.SDFLOCAL.format(this.createDate));

		return returnJson;
	}

	public long getDealId() {
		return dealId;
	}

	public void setDealId(long dealId) {
		this.dealId = dealId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public User getTraveller() {
		return traveller;
	}

	public void setTraveller(User traveller) {
		this.traveller = traveller;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public User getOfferedBy() {
		return offeredBy;
	}

	public void setOfferedBy(User offeredBy) {
		this.offeredBy = offeredBy;
	}

	public Set<Chat> getChats() {
		return chats;
	}

	public void setChats(Set<Chat> chats) {
		this.chats = chats;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
