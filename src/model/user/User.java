//contact to string
package model.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import model.chat.Chat;
import model.credit.Credit;
import model.deal.Deal;
import model.travel.Travel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.Config;
import system.Encrypt;

public class User {
	private long userId; // Primary key. Generated unique id
	private Credit credit;
	private String passwordHash; // Stored hash of user input password
	private String passwordSalt; // Stored randomly generated String, used in
									// generating password hash
	private String firstName; // User input first name
	private String lastName; // User input last name
	private char gender; // User input gender, "m" ,"f" ,"o"
	private Date birthDate; // User input date of birth
	private String contact; // User input phone number
	private String countryCode; // phone number preceded by "+", country code
	private boolean contactConfirmed; // Defaults false, true if sms is
										// confirmed
	private String email; // User input email address
	private boolean emailConfirmed; // Defaults false, true if email is
									// confirmed
	private String address; // User input delivery address
	private String facebookId; // User input facebook login
	private Set<Travel> travels; // Travel objects for user trips
	private Set<Deal> travellerDeals;// Deal objects with user as
										// traveller
	private Set<Deal> buyerDeals;// Deal objects with user as buyer
	private Set<Chat> chats;// Just in case need it in the future
	private String remarks; // better have this
	private Date createDate; // better have this

	public User() {

	}

	public User(Credit credit, String passwordHash, String passwordSalt,
			String firstName, String lastName, char gender, Date birthDate,
			String contact, String countryCode, boolean contactConfirmed,
			String email, boolean emailConfirmed, String address,
			String facebookId, Set<Travel> travels, Set<Deal> travellerDeals,
			Set<Deal> buyerDeals, String remarks, Date createDate) {
		super();
		this.credit = credit;
		this.passwordHash = passwordHash;
		this.passwordSalt = passwordSalt;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.contact = contact;
		this.countryCode = countryCode;
		this.contactConfirmed = contactConfirmed;
		this.email = email;
		this.emailConfirmed = emailConfirmed;
		this.address = address;
		this.facebookId = facebookId;
		this.travels = travels;
		this.travellerDeals = travellerDeals;
		this.buyerDeals = buyerDeals;
		this.remarks = remarks;
		this.createDate = createDate;
	}

	// method
	public JSONObject toJson() {
		JSONObject returnJson = new JSONObject();

		returnJson.put(Config.USERID, this.userId);
		returnJson.put(Config.FIRSTNAME, this.firstName);
		returnJson.put(Config.LASTNAME, this.lastName);
		returnJson.put(Config.GENDER, this.gender);
		returnJson.put(Config.BIRTHDATE, this.birthDate);
		returnJson.put(Config.CONTACT, this.contact);
		returnJson.put(Config.COUNTRYCODE, this.countryCode);
		returnJson.put(Config.EMAIL, this.email);
		returnJson.put(Config.ADDRESS, this.address);
		returnJson.put(Config.FACEBOOKID, this.facebookId);
		returnJson.put(Config.REMARKS, this.remarks);
		returnJson.put(Config.CREATEDATE,
				Config.SDFLOCAL.format(this.createDate));

		return returnJson;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isContactConfirmed() {
		return contactConfirmed;
	}

	public void setContactConfirmed(boolean contactConfirmed) {
		this.contactConfirmed = contactConfirmed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public Set<Travel> getTravels() {
		return travels;
	}

	public void setTravels(Set<Travel> travels) {
		this.travels = travels;
	}

	public Set<Deal> getTravellerDeals() {
		return travellerDeals;
	}

	public void Set(Set<Deal> travellerDeals) {
		this.travellerDeals = travellerDeals;
	}

	public Set<Deal> getBuyerDeals() {
		return buyerDeals;
	}

	public void setBuyerDeals(Set<Deal> buyerDeals) {
		this.buyerDeals = buyerDeals;
	}
	
	public Set<Chat> getChats(){
		return chats;
	}
	
	public void setChats(Set<Chat> chats){
		this.chats = chats;
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
