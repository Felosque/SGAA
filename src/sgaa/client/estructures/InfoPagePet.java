package sgaa.client.estructures;

import java.util.Date;

public class InfoPagePet {

	private int id, id_organization, raza;
	private String color, name, acquisition_place, description;
	private Date birth_date;
	
	
	public InfoPagePet(int id, int id_organization, int raza, String color, String name, String acquisition_place, String description) {
		super();
		this.id = id;
		this.id_organization = id_organization;
		this.raza = raza;
		this.color = color;
		this.name = name;
		this.acquisition_place = acquisition_place;
		this.description = description;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_organization() {
		return id_organization;
	}


	public void setId_organization(int id_organization) {
		this.id_organization = id_organization;
	}


	public int getRaza() {
		return raza;
	}


	public void setRaza(int raza) {
		this.raza = raza;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAcquisition_place() {
		return acquisition_place;
	}


	public void setAcquisition_place(String acquisition_place) {
		this.acquisition_place = acquisition_place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	
	
	
}
