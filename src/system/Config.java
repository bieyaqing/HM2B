package system;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.json.simple.parser.JSONParser;

public class Config {
	public static final JSONParser JPARSER = new JSONParser();
	
	public static final SimpleDateFormat SDFLOCAL = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	public static final TimeZone SGZONE = TimeZone.getTimeZone("Singapore");
	public static final void SETTIMEZONE(){
		SDF.setTimeZone(SGZONE);
	}
	
	public static final long SUCCESSVAL = 1;
	public static final long FAILVAL = 0;
	
	//User
	public static final String USERID = "userId";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String PHOTOURL = "photoUrl";
	public static final String PHOTOSIZE = "photoSize";
	public static final String FACEBOOKID = "facebookId";
	public static final String REMARK = "remark";
	public static final String CREATEDATE = "createDate";
	
	
	
}
