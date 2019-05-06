package sgaa.server.dto;

import java.util.Date;

import sgaa.server.interfaces.Crud;

public class OrganizationDTO implements Crud
{
	private String mail;
	private String password;
	private String name;
	private String address;
	private long phoneNumber;
	private Date registrationDate;
	
	/**
	 * 
	 */
	public OrganizationDTO() {
		super();
	}
	
	/**
	 * 
	 * @param mail
	 * @param password
	 * @param name
	 * @param address
	 * @param phoneNumber
	 * @param registationDate
	 */
	public OrganizationDTO(String mail, String password, String name, String address, long phoneNumber, Date registationDate) {
		super();
		this.mail = mail;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registationDate;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registationDate) {
		this.registrationDate = registationDate;
	}

	@Override
	public String toString() {
		return "OrganizationDTO [mail=" + mail + ", password=" + password + ", name=" + name + ", address=" + address
				+ ", phone_number=" + phoneNumber + ", registration_date=" + registrationDate + "]";
	}

	@Override
	public String insert() 
	{
		return "INSERT INTO public.organization( mail, password, name, address, phone_number, registration_date)"+
				"VALUES ('"+mail+"','"+password+"','"+name+"','"+address+"','"+phoneNumber+"','"+registrationDate+"');";
	}

	@Override
	public String update() 
	{
		return "UPDATE public.organization SET mail='"+mail+"', password="+password+"', name='"+name+"', address='"+address+"', "
				+ "phone_number='"+phoneNumber+"', registration_date='"+registrationDate+"' WHERE mail = '"+mail+"';";
	}

	@Override
	public String delete() 
	{
		return "DELETE FROM public.organization WHERE mail = '"+mail+"';";
	}

	@Override
	public String findById() 
	{
		return "SELECT mail, password, name, address, phone_number, registration_date FROM public.organization WHERE mail = '"+mail+"';";
	}

	@Override
	public String findAll() 
	{
		return "SELECT mail, password, name, address, phone_number, registration_date FROM public.organization;";
	}

	@Override
	public String findByAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

}
