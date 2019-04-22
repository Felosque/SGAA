package sgaa.client.estructures;

import java.util.Date;

import sgaa.server.dto.OrganizationDTO;

public class OrganizationSession {

	private String name, mail, house;
	private long phone;
	private Date registrationDate;
	
	
	public OrganizationSession(OrganizationDTO orgDto) {

		name = orgDto.getName();
		mail = orgDto.getMail();
		house = orgDto.getAddress();
		phone = orgDto.getPhoneNumber();
		registrationDate = orgDto.getRegistrationDate();
		
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


	public Date getRegistrationDate() {
		return registrationDate;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setHouse(String house) {
		this.house = house;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	

}
