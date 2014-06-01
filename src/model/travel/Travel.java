package model.travel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import model.deal.Deal;
import model.user.User;

import org.json.simple.JSONObject;

import system.Config;

public class Travel {

	private long travelId; // Primary key. Generated unique id
	private User user; // Foreign key. Generated unique id for user table
	private Set<Deal> deals;// Deal objects
	private String visitingCountry; // User input visiting country aided by// google maps
	private String visitingCity; // User input visiting city aided by google	// maps
	private String visitingState;
	private String visitingGeoCode;
	private String returnCountry; // User input returning country aided by
									// google maps
	private String returnCity; // User input returning country aided by google
								// maps
	private String returnState;
	private String returnGeoCode;
	private Date departureTime; // User input datetime for departure date
	private Date arrivalTime; // User input datetime for arrival date
	private String remarks; // Standard utility variables
	private Date createDate;// Standard utility variables

	public Travel() {

	}

	public Travel(User user, Set<Deal> deals, String visitingCountry,
			String visitingCity, String visitingState, String visitingGeoCode,
			String returnCountry, String returnCity, String returnState,
			String returnGeoCode, Date departureTime, Date arrivalTime,
			String remarks) {
		super();
		this.user = user;
		this.deals = deals;
		this.visitingCountry = visitingCountry;
		this.visitingCity = visitingCity;
		this.visitingState = visitingState;
		this.visitingGeoCode = visitingGeoCode;
		this.returnCountry = returnCountry;
		this.returnCity = returnCity;
		this.returnState = returnState;
		this.returnGeoCode = returnGeoCode;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
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

		returnJson.put(Config.TRAVELID, this.travelId);
		returnJson.put(Config.USERID, this.user.getUserId());
		returnJson.put(Config.VISITINGCOUNTRY, this.visitingCountry);
		returnJson.put(Config.VISITINGCITY, this.visitingCity);
		returnJson.put(Config.VISITINGSTATE, this.visitingState);
		returnJson.put(Config.VISITINGGEOCODE, this.visitingGeoCode);
		returnJson.put(Config.RETURNCOUNTRY, this.returnCountry);
		returnJson.put(Config.RETURNCITY, this.returnCity);
		returnJson.put(Config.RETURNSTATE, this.returnState);
		returnJson.put(Config.RETURNGEOCODE, this.returnGeoCode);
		returnJson.put(Config.DEPARTURETIME,
				Config.SDFLOCAL.format(this.departureTime));
		returnJson.put(Config.ARRIVALTIME,
				Config.SDFLOCAL.format(this.arrivalTime));
		returnJson.put(Config.REMARKS, this.remarks);
		returnJson.put(Config.CREATEDATE,
				Config.SDFLOCAL.format(this.createDate));

		return returnJson;
	}

	public long getTravelId() {
		return travelId;
	}

	public void setTravelId(long travelId) {
		this.travelId = travelId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Deal> getDeals() {
		return deals;
	}

	public void setDeals(Set<Deal> deals) {
		this.deals = deals;
	}

	public String getVisitingCountry() {
		return visitingCountry;
	}

	public void setVisitingCountry(String visitingCountry) {
		this.visitingCountry = visitingCountry;
	}

	public String getVisitingCity() {
		return visitingCity;
	}

	public void setVisitingCity(String visitingCity) {
		this.visitingCity = visitingCity;
	}

	public String getVisitingState() {
		return visitingState;
	}

	public void setVisitingState(String visitingState) {
		this.visitingState = visitingState;
	}

	public String getVisitingGeoCode() {
		return visitingGeoCode;
	}

	public void setVisitingGeoCode(String visitingGeoCode) {
		this.visitingGeoCode = visitingGeoCode;
	}

	public String getReturnCountry() {
		return returnCountry;
	}

	public void setReturnCountry(String returnCountry) {
		this.returnCountry = returnCountry;
	}

	public String getReturnCity() {
		return returnCity;
	}

	public void setReturnCity(String returnCity) {
		this.returnCity = returnCity;
	}

	public String getReturnState() {
		return returnState;
	}

	public void setReturnState(String returnState) {
		this.returnState = returnState;
	}

	public String getReturnGeoCode() {
		return returnGeoCode;
	}

	public void setReturnGeoCode(String returnGeoCode) {
		this.returnGeoCode = returnGeoCode;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
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
