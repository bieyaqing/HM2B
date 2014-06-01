package controller.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.json.simple.JSONObject;

import model.credit.Credit;
import model.deal.Deal;
import model.travel.Travel;
import model.user.User;
import persistance.user.UserDAO;
import system.Config;
import system.Encrypt;

public class UserController {

	// Create User w JSON
	public static JSONObject createUser(JSONObject json) {
		JSONObject returnJson = new JSONObject();

		String passwordHash = null;
		String passwordSalt = null;
		Date createDate = null;
		Set<Travel> travels = null;
		Set<Deal> travellerDeals = null;
		Set<Deal> buyerDeals = null;

		try {
			String password = (String) json.get(Config.PASSWORD);
			String firstName = (String) json.get(Config.FIRSTNAME);
			String lastName = (String) json.get(Config.LASTNAME);
			char gender = (char) json.get(Config.GENDER);
			String birthDateString = (String) json.get(Config.BIRTHDATE);
			DateFormat df = Config.SDF;
			Date birthDate = (Date) df.parse(birthDateString);
			String contact = (String) json.get(Config.CONTACT);
			String countryCode = (String) json.get(Config.COUNTRYCODE);

			boolean contactConfirmed = (boolean) json
					.get(Config.CONTACTCONFIRMED);

			String email = (String) json.get(Config.EMAIL);
			boolean emailConfirmed = (boolean) json.get(Config.EMAILCONFIRMED);
			String address = (String) json.get(Config.ADDRESS);
			String facebookId = (String) json.get(Config.FACEBOOKID);
			String remarks = (String) json.get(Config.REMARKS);

			// create salt and hash
			passwordSalt = Encrypt.nextSalt();
			passwordHash = Encrypt.generateSaltedHash(password, passwordSalt);

			Credit credit = new Credit();

			if (UserDAO.getUserByEmail(email) == null) {
				User user = new User(credit, passwordHash, passwordSalt,
						firstName, lastName, gender, birthDate, contact,
						countryCode, contactConfirmed, email, emailConfirmed,
						address, facebookId, travels, travellerDeals,
						buyerDeals, remarks, createDate);
				// commit create user
				UserDAO.addUser(user);

				returnJson.put(Config.STATUS, Config.SUCCESSVAL);
				returnJson.put(Config.MESSAGE, user.toJson());
			} else {
				returnJson.put(Config.STATUS, Config.FAILVAL);
				returnJson.put(Config.MESSAGE, "Email already registered!");
			}
			// create user

		} catch (Exception e) {
			returnJson.put(Config.STATUS, Config.FAILVAL);
			returnJson.put(Config.MESSAGE, "UserController.addUser: " + e);
		}

		// create credit object
		Credit credit = new Credit();

		// create createDate
		try {
			createDate = Config.SDF.parse(Config.SDFLOCAL.format(new Date()));
		} catch (Exception e) {
			createDate = new Date();
			e.printStackTrace();
		}
		return returnJson;
	}

	public static JSONObject updateUser(JSONObject json) {
		JSONObject returnJson = new JSONObject();

		try {
			if (json.containsKey(Config.USERID)) {
				long userId = (long) json.get(Config.USERID);
				User user = UserDAO.getUserById(userId);

				if (json.containsKey(Config.FIRSTNAME)) {
					user.setFirstName((String) json.get(Config.FIRSTNAME));
				}

				if (json.containsKey(Config.LASTNAME)) {
					user.setLastName((String) json.get(Config.LASTNAME));
				}

				if (json.containsKey(Config.GENDER)) {
					user.setGender((char) json.get(Config.GENDER));
				}

				if (json.containsKey(Config.BIRTHDATE)) {
					String dateString = (String) json.get(Config.BIRTHDATE);
					DateFormat df = Config.SDF;
					Date birthDate = (Date) df.parse(dateString);
					user.setBirthDate(birthDate);
				}

				if (json.containsKey(Config.PASSWORD)) {
					String passwordSalt = Encrypt.nextSalt();
					String passwordHash = Encrypt.generateSaltedHash(
							(String) json.get(Config.PASSWORD), passwordSalt);
					user.setPasswordHash(passwordHash);
					user.setPasswordSalt(passwordSalt);
				}

				if (json.containsKey(Config.COUNTRYCODE)) {
					user.setCountryCode((String) json.get(Config.COUNTRYCODE));
				}
				if (json.containsKey(Config.ADDRESS)) {
					user.setAddress((String) json.get(Config.ADDRESS));
				}
				if (json.containsKey(Config.FACEBOOKID)) {
					user.setFacebookId((String) json.get(Config.FACEBOOKID));
				}
				if (json.containsKey(Config.REMARKS)) {
					user.setRemarks((String) json.get(Config.REMARKS));
				}

				UserDAO.modifyUser(user);

				returnJson.put(Config.STATUS, Config.SUCCESSVAL);
				returnJson.put(Config.MESSAGE, user.toJson());
			} else {
				returnJson.put(Config.STATUS, Config.FAILVAL);
				returnJson.put(Config.MESSAGE,
						"UserController.updateUser: No userId found!");
			}
		} catch (Exception e) {
			returnJson.put(Config.STATUS, Config.FAILVAL);
			returnJson.put(Config.MESSAGE, "UserController.updateUser: " + e);
		}

		return returnJson;
	}

	// Depreciated code

	/**
	 * // Create User w/o JSON public static void createUser(String username,
	 * String password, String firstName, String lastName, char gender, Date
	 * birthDate, String contact, String countryCode, boolean contactConfirmed,
	 * String email, boolean emailConfirmed, String address, String facebookId,
	 * String remarks) { String passwordHash = null; String passwordSalt = null;
	 * Date createDate = null; Set<Travel> travels = null; Set<Deal>
	 * travellerDeals = null; Set<Deal> buyerDeals = null;
	 * 
	 * // create credit object Credit credit = new Credit(); // create salt and
	 * hash passwordSalt = Encrypt.nextSalt(); passwordHash =
	 * Encrypt.generateSaltedHash(password, passwordSalt); // create createDate
	 * try { createDate = Config.SDF.parse(Config.SDFLOCAL.format(new Date()));
	 * } catch (Exception e) { createDate = new Date(); e.printStackTrace(); }
	 * // create user User user = new User(credit, passwordHash, passwordSalt,
	 * firstName, lastName, gender, birthDate, contact, countryCode,
	 * contactConfirmed, email, emailConfirmed, address, facebookId, travels,
	 * travellerDeals, buyerDeals, remarks, createDate); // commit create user
	 * UserDAO.addUser(user); }
	 **/

}
