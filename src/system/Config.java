package system;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.json.simple.parser.JSONParser;

public class Config {
	public static final JSONParser JPARSER = new JSONParser();

	public static final SimpleDateFormat SDFLOCAL = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");
	public static final SimpleDateFormat SDF = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");
	public static final TimeZone SGZONE = TimeZone.getTimeZone("Singapore");

	public static final void SETTIMEZONE() {
		SDF.setTimeZone(SGZONE);
	}

	public static final long SUCCESSVAL = 1;
	public static final long FAILVAL = 0;
	public static final Object MESSAGE = "Error encounted.";

	// User
	public static final String USERID = "userId";
	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";
	public static final String PASSWORD = "password";
	public static final String GENDER = "gender";
	public static final String BIRTHDATE = "birthDate";
	public static final String CONTACT = "contact";
	public static final String COUNTRYCODE = "countryCode";
	public static final String EMAIL = "email";
	public static final String ADDRESS = "address";
	public static final String FACEBOOKID = "facebookId";
	public static final String REMARKS = "remarks";
	public static final String CREATEDATE = "createDate";
	public static final String CONTACTCONFIRMED = "contactConfirmed";
	public static final String EMAILCONFIRMED = "emailConfirmed";
	
	// Travel
	public static final String TRAVELID = "travelId";
	public static final String STARTDATE = "startDate";
	public static final String ENDDATE = "endDate";
	public static final String VISITINGCOUNTRY = "visitingCountry";
	public static final String VISITINGCITY = "visitingCity";
	public static final String VISITINGSTATE = "visitingState";
	public static final String VISITINGGEOCODE = "visitingGeoCode";
	public static final String RETURNCOUNTRY = "returnCountry";
	public static final String RETURNCITY = "returnCity";
	public static final String RETURNSTATE = "returnState";
	public static final String RETURNGEOCODE = "returnGeoCode";
	public static final String DEPARTURETIME = "departureTime";
	public static final String ARRIVALTIME = "arrivalTime";
	
	// Offer
	public static final String OFFERID = "offerId";
	public static final String ITEMID = "itemId";
	public static final String STATUS = "status";
	public static final String PRICE = "price";
	public static final String OFFEREDBYID = "offeredById";
	
	// Item
	public static final String ITEMNAME = "itemname";
	public static final String PHOTOURL1 = "photoURL1";
	public static final String PHOTOURL2 = "photoURL2";
	public static final String PHOTOURL3 = "photoURL3";
	public static final String RECEIPTURL = "receiptURL";
	public static final String COSTPRICE = "costPrice";
	public static final String SHIPPINGFEE = "shippingFee";

	// Deal
	public static final String DEALID = "dealId";
	public static final String TRAVELLERID = "travellerId";
	public static final String BUYERID = "buyerId";
	public static final String OFFEREDBY = "offeredBy";
	
	// Credit
	public static final String CREDITID = "creditId";
	public static final String PAYPALKEY = "paypalKey";
	public static final String CREDITNAME = "creditName";
	public static final String CREDITEXPIRY = "creditExpiry";
	public static final String CREDITNUMBER = "creditNumber";
	
	// Chat
	public static final String CHATID = "chatId";
	public static final String TEXT = "text";

}
