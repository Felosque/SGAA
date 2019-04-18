package sgaa.client.estructures;

import java.util.Date;

import sgaa.server.dto.UserDTO;

public class UserSession {

	private String name, mail, house;
	private long phone;
	private Date birthDate;
	
	
	public UserSession(UserDTO pUser)
	{
		name = pUser.getName();
		mail = pUser.getMail();
		phone = pUser.getPhoneNumber();
		house = pUser.getAddress();
		birthDate = pUser.getBirthdate();
	}


	public String getName() {
		return name;
	}


	public String getMail() {
		return mail;
	}


	public String getHouse() {
		return house;
	}


	public long getPhone() {
		return phone;
	}


	public Date getBirthDate() {
		return birthDate;
	}
	
}
