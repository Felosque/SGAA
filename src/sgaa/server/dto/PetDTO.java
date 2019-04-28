package sgaa.server.dto;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;

import sgaa.server.infrastructure.Conexion;
import sgaa.server.interfaces.Crud;

public class PetDTO implements Crud
{
	private int id;
	private String name;
	private String color;
	private String address;
	private String description;
	private java.util.Date birthdate;
	private boolean state;
	private int breed;
	private String mail;
	private ImageIcon image;
	private String pathImage;
	
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
	public PetDTO(int id, String name, String color, String address, java.util.Date birthdate, boolean state, int breed, String mail, String pPathImage, String pDescription) 
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
		this.pathImage = pPathImage;
		this.description = pDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setPathImage(String pPath)
	{
		pathImage = pPath;
	}
	
	public String getPathImage()
	{
		return pathImage;
	}

	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String pDescription)
	{
		this.description = pDescription;
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
		
		Date d = new Date(birthdate.getYear(), birthdate.getMonth(), birthdate.getDay());
		return d;
	}

	public void setBirthdate(java.util.Date birthdate) {
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
	
	//Codigo tomado de 
	//https://es.stackoverflow.com/questions/26596/como-convertir-una-imagen-a-un-array-de-bytes-en-java
	//Respectivos creditos a Migudev
	public byte[] toBinary(String path) {
	    
		int len = path.split("\\.").length;
	    String ext = path.split("\\.")[len - 1];
        BufferedImage img;
		try {
			img = ImageIO.read(new File(path));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(img, ext, baos);
	        return baos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "PetDTO [id=" + id + ", name=" + name + ", color=" + color + ", address=" + address + ", birthdate="
				+ birthdate + ", state=" + state + ", breed=" + breed + ", mail=" + mail + ", image=" + image + "]";
	}

	@Override
	public String insert() {
		return "INSERT INTO public.pet(name, color, address, birthdate, state, breed, mail, description, img)"+
				" VALUES ('"+name+"' , '"+color+"', '"+address+"', '"+birthdate+"', '"+state+"', '"+breed+"', '"+mail+"', '"+description+"', "+ image + ")";
	}

	@Override
	public String update() {
		return "UPDATE public.pet SET id='"+id+"', name='"+name+"', color='"+color+"', address='"+address+"', birthdate='"+birthdate+"', state='"+state+"', breed='"+breed+"', mail='"+mail+"'," + 
				"description='"+description+"'," +" img="+image+"" +	"WHERE id='"+id+"';";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "DELETE FROM public.pet WHERE id='"+id+"';";
	}

	@Override
	public String findById() {
		// TODO Auto-generated method stub
		return "SELECT id, name, color, address, birthdate, state, breed, mail, description, img FROM public.pet WHERE id='"+id+"';";
	}

	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return "SELECT id, name, color, address, birthdate, state, breed, mail, description, img FROM public.pet WHERE mail='"+mail+"';";
	}
}
