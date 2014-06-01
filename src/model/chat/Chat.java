package model.chat;

import java.util.Date;
import java.util.Set;

import model.deal.Deal;
import model.user.User;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.Config;

public class Chat {
	private long chatId;
	private Deal deal;
	private User user;
	private String text;
	private String remarks; // Standard utility variables
	private Date createDate; // Standard utility variables

	public Chat() {

	}

	public Chat(Deal deal, User user, String text, String remarks) {
		super();
		this.deal = deal;
		this.user = user;
		this.text = text;
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

		returnJson.put(Config.CHATID, this.chatId);
		returnJson.put(Config.DEALID, this.deal.getDealId());
		returnJson.put(Config.USERID, this.user.getUserId());
		returnJson.put(Config.TEXT, this.text);
		returnJson.put(Config.REMARKS, this.remarks);
		returnJson.put(Config.CREATEDATE,
				Config.SDFLOCAL.format(this.createDate));

		return returnJson;
	}

	public long getChatId() {
		return chatId;
	}

	public void setChatId(long chatId) {
		this.chatId = chatId;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
