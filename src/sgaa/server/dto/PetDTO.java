package sgaa.server.dto;

import java.sql.Date;

import javax.swing.ImageIcon;

import sgaa.server.interfaces.Crud;

public class PetDTO implements Crud
{
	private int id;
	private String name;
	private String color;
	private String address;
	private Date birthdate;
	private boolean state;
	private int breed;
	private String mail;
	private ImageIcon image;
	
	/**
	 * 
	 */
	public PetDTO() 
	{
		super();
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param color
	 * @param address
	 * @param birthdate
	 * @param state
	 * @param breed
	 * @param mail
	 * @param image
	 */
	public PetDTO(int id, String name, String color, String address, Date birthdate, boolean state, int breed, String mail, ImageIcon image) 
	{
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.address = address;
		this.birthdate = birthdate;
		this.state = state;
		this.breed = breed;
		this.mail = mail;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getBreed() {
		return breed;
	}

	public void setBreed(int breed) {
		this.breed = breed;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ImageIcon getImg() {
		return image;
	}

	public void setImg(ImageIcon image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "PetDTO [id=" + id + ", name=" + name + ", color=" + color + ", address=" + address + ", birthdate="
				+ birthdate + ", state=" + state + ", breed=" + breed + ", mail=" + mail + ", image=" + image + "]";
	}

	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return "INSERT INTO public.pet(id, name, color, address, date_birth, state, breed, mail, img)"+
				" VALUES ('"+id+"','"+name+"' , '"+color+"', '"+address+"', '"+birthdate+"', '"+state+"', '"+breed+"', '"+mail+"', '"+image+"');";
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return "UPDATE public.pet SET id='"+id+"', name='"+name+"', color='"+color+"', address='"+address+"', date_birth='"+birthdate+"', state='"+state+"', breed='"+breed+"', mail='"+mail+"', img='"+image+"'" + 
				"	WHERE id='"+id+"';";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "DELETE FROM public.pet WHERE id='"+id+"';";
	}

	@Override
	public String findById() {
		// TODO Auto-generated method stub
		return "SELECT id, name, color, address, birthdate, state, breed, mail, img FROM public.pet WHERE id='"+id+"';";
	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return "SELECT id, name, color, address, birthdate, state, breed, mail, img FROM public.pet;";
	}
}
