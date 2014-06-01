package model.credit;

import java.util.Date;
import java.util.Set;

import model.user.User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.Config;

public class Credit {
	private long creditId;
	private User user;
	private String paypalKey;
	private String creditName;
	private Date creditExpiry;
	private long creditNumber;
	private String remarks;
	private Date createDate;

	public Credit() {

	}

	public Credit(User user, String paypalKey, String creditName,
			Date creditExpiry, long creditNumber, String remarks) {
		super();
		this.user = user;
		this.paypalKey = paypalKey;
		this.creditName = creditName;
		this.creditExpiry = creditExpiry;
		this.creditNumber = creditNumber;
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

		returnJson.put(Config.CREDITID, this.creditId);
		returnJson.put(Config.USERID, this.user.getUserId());
		returnJson.put(Config.PAYPALKEY, this.paypalKey);
		returnJson.put(Config.CREDITNAME, this.creditName);
		returnJson.put(Config.CREDITEXPIRY, this.creditExpiry);
		returnJson.put(Config.CREDITNUMBER, this.creditNumber);
		returnJson.put(Config.REMARKS, this.remarks);
		returnJson.put(Config.CREATEDATE,
				Config.SDFLOCAL.format(this.createDate));

		return returnJson;
	}

	public long getCreditId() {
		return creditId;
	}

	public void setCreditId(long creditId) {
		this.creditId = creditId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPaypalKey() {
		return paypalKey;
	}

	public void setPaypalKey(String paypalKey) {
		this.paypalKey = paypalKey;
	}

	public String getCreditName() {
		return creditName;
	}

	public void setCreditName(String creditName) {
		this.creditName = creditName;
	}

	public Date getCreditExpiry() {
		return creditExpiry;
	}

	public void setCreditExpiry(Date creditExpiry) {
		this.creditExpiry = creditExpiry;
	}

	public long getCreditNumber() {
		return creditNumber;
	}

	public void setCreditNumber(long creditNumber) {
		this.creditNumber = creditNumber;
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
