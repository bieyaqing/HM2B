package model.item;

import java.util.Date;
import java.util.Set;

import model.offer.Offer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.Config;

public class Item {
	private Long itemId; // System generated unique identifier
	private Offer offer;
	private String itemname; // User input for item name
	private String photoURL1; // System generated uploaded image name
	private String photoURL2;
	private String photoURL3;
	private String receiptURL; // System generated for uploaded receipt image
	private double costPrice;
	private double shippingFee;
	private String remarks; // Standard utility variables
	private Date createDate; // Standard utility variables

	public Item() {

	}

	public Item(Offer offer, String itemname, String photoURL1, String photoURL2,
			String photoURL3, String receiptURL, double costPrice,
			double shippingFee, String remarks) {
		super();
		this.offer = offer;
		this.itemname = itemname;
		this.photoURL1 = photoURL1;
		this.photoURL2 = photoURL2;
		this.photoURL3 = photoURL3;
		this.receiptURL = receiptURL;
		this.costPrice = costPrice;
		this.shippingFee = shippingFee;
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

		returnJson.put(Config.ITEMID, this.itemId);
		returnJson.put(Config.OFFERID, this.offer.getOfferId());
		returnJson.put(Config.ITEMNAME, this.itemname);
		returnJson.put(Config.PHOTOURL1, this.photoURL1);
		returnJson.put(Config.PHOTOURL2, this.photoURL2);
		returnJson.put(Config.PHOTOURL3, this.photoURL3);
		returnJson.put(Config.RECEIPTURL, this.receiptURL);
		returnJson.put(Config.COSTPRICE, this.costPrice);
		returnJson.put(Config.SHIPPINGFEE, this.shippingFee);
		returnJson.put(Config.REMARKS, this.remarks);
		returnJson.put(Config.CREATEDATE,
				Config.SDFLOCAL.format(this.createDate));

		return returnJson;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	public Offer getOffer(){
		return offer;
	}
	
	public void setOffer(Offer offer){
		this.offer = offer;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getPhotoURL1() {
		return photoURL1;
	}

	public void setPhotoURL1(String photoURL1) {
		this.photoURL1 = photoURL1;
	}

	public String getPhotoURL2() {
		return photoURL2;
	}

	public void setPhotoURL2(String photoURL2) {
		this.photoURL2 = photoURL2;
	}

	public String getPhotoURL3() {
		return photoURL3;
	}

	public void setPhotoURL3(String photoURL3) {
		this.photoURL3 = photoURL3;
	}

	public String getReceiptURL() {
		return receiptURL;
	}

	public void setReceiptURL(String receiptURL) {
		this.receiptURL = receiptURL;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
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
