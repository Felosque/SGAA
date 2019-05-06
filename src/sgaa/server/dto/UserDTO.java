package sgaa.server.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

import sgaa.server.interfaces.Crud;

public class UserDTO implements Crud{

	private String mail;
	private String password;
	private String name;
	private String address;
	private long phoneNumber;
	private java.util.Date birthdate;
	private java.util.Date registrationDate;
	
	
	/**
	 * 
	 */
	public UserDTO() 
	{
		
	}
	

	/**
	 * @param mail
	 * @param password
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param birthdate
	 * @param registrationDate
	 */
	public UserDTO(String mail, String password, String name, String address, long phoneNumber, java.util.Date birthDate,
			java.util.Date registrationDate) {
		super();
		this.mail = mail;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.birthdate = birthDate;
		this.registrationDate = registrationDate;
	}
	

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public java.util.Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthDate) {
		this.birthdate = birthDate;
	}


	public java.util.Date getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	

	@Override
	public String toString() {
		return "UserDAO [mail=" + mail + ", password=" + password + ", name=" + name + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", birthdate=" + birthdate + ", registrationDate=" + registrationDate
				+ "]";
	}


	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return "INSERT INTO public.user(mail, password, name, address, phone_number, birthdate, registration_date) "
		+ "VALUES ('"+ mail + "', '" + password +"', '" + name + "', '" + address + "', '" + phoneNumber + "', '" + birthdate + "', '" +registrationDate + "');";

	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return "UPDATE public.user set mail = '"+ mail +"', password = '" + password + "', name = '" + name + "', address = '" + address + "'"
				+ ", phone_number = '" + phoneNumber + "', birthdate = '" + birthdate + "', registration_date = '" + registrationDate + "' where mail = '"+mail+"';";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "DELETE from public.user where mail = '"+mail+"';";
	}

	@Override
	public String findById() {
		// TODO Auto-generated method stub
		return "SELECT mail, password, name, address, phone_number, birthdate, registration_date from public.user where mail = '" + mail +"';";

	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return "SELECT mail, password, name, address, phone_number, birthdate, registration_date from public.user;";
	}


	@Override
	public String findByAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

}
