package model.user;

import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import system.Config;

public class User {
	private long userId;
	private String name;
	private String email;
	private String password;
	private String facebookId;
	private String photoUrl;
	private String photoSize;
	private String remark; //better have this
	private Date createDate; //better have this
	
	
	public User(){
		
	}
	
	public User(String name, String email, String password, String facebookId, String photoUrl, String photoSize, String remark){
		this.name = name;
		this.email = email;
		this.password = password;
		this.facebookId = facebookId;
		this.photoUrl = photoUrl;
		this.photoSize = photoSize;
		this.remark = remark;
		try{
			this.createDate = Config.SDF.parse(Config.SDFLOCAL.format(new Date()));
		}catch(Exception e){
			this.createDate = new Date();
			e.printStackTrace();
		}
	}
	
	// vary important. Each parameter must have a get and a set function.
	public long getUserId(){
		return this.userId;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getFacebookId(){
		return this.facebookId;
	}
	
	public String getPhotoUrl(){
		return this.photoUrl;
	}
	
	public String getPhotoSize(){
		return this.photoSize;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public Date getCreateDate(){
		return this.createDate;
	}
	
	public void setUserId(long userId){
		this.userId = userId;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setFacebookId(String facebookId){
		this.facebookId = facebookId;
	}
	
	public void setPhotoUrl(String photoUrl){
		this.photoUrl = photoUrl;
	}
	
	public void setPhotoSize(String photoSize){
		this.photoSize = photoSize;
	}
	
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
	//method
	public JSONObject toJson(){
		JSONObject returnJson = new JSONObject();
		
		returnJson.put(Config.USERID, this.userId);
		returnJson.put(Config.NAME, this.name);
		returnJson.put(Config.EMAIL, this.email);
		returnJson.put(Config.FACEBOOKID, this.facebookId);
		returnJson.put(Config.PHOTOURL, this.photoUrl);
		returnJson.put(Config.PHOTOSIZE, this.photoSize);
		returnJson.put(Config.REMARK, this.remark);
		returnJson.put(Config.CREATEDATE, Config.SDFLOCAL.format(this.createDate));
		
		return returnJson;
	}
	
}
