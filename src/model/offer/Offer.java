package model.offer;

import java.util.Date;
import java.util.Set;

import model.deal.Deal;
import model.item.Item;
import model.user.User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.Config;

public class Offer {
	private long offerId; //Primary key. Generated unique id
	private Deal deal;
	private Item item;
	private int status; //System input status for deal status
	private float price; //User input item price
	private User offeredBy; //Foreign key. System input for user who made offer
	private String remarks; //Standard utility variables
	private Date createDate; //Standard utility variables
	
	
	public Offer(){
		
	}
	
	public Offer(Deal deal, Item item, int status, float price,
			User offeredBy, String remarks) {
		super();
		this.deal = deal;
		this.item = item;
		this.status = status;
		this.price = price;
		this.offeredBy = offeredBy;
		this.remarks = remarks;
		try{
			this.createDate = Config.SDF.parse(Config.SDFLOCAL.format(new Date()));
		}catch(Exception e){
			this.createDate = new Date();
			e.printStackTrace();
		}
	}
	
	//method
	public JSONObject toJson(){
		JSONObject returnJson = new JSONObject();

		returnJson.put(Config.OFFERID, this.offerId);
		returnJson.put(Config.DEALID, this.deal.getDealId());
		returnJson.put(Config.ITEMID, this.item.getItemId());
		returnJson.put(Config.STATUS, this.status);
		returnJson.put(Config.PRICE, this.price);
		returnJson.put(Config.OFFEREDBY, this.offeredBy);
		returnJson.put(Config.REMARKS, this.remarks);
		returnJson.put(Config.CREATEDATE, Config.SDFLOCAL.format(this.createDate));
		
		return returnJson;
	}

	public long getOfferId() {
		return offerId;
	}

	public void setOfferId(long offerId) {
		this.offerId = offerId;
	}
	
	public Deal getDeal(){
		return deal;
	}
	
	public void setDeal(Deal deal){
		this.deal = deal;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public User getofferedBy() {
		return offeredBy;
	}

	public void setofferedBy(User offeredBy) {
		this.offeredBy = offeredBy;
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
