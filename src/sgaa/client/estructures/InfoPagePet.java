package sgaa.client.estructures;

import java.util.Date;

import sgaa.server.dto.PetDTO;

public class InfoPagePet {

	private int id, raza;
	private String color, name, acquisition_place, description, id_organization;
	private Date birth_date;
	
	
	public InfoPagePet(PetDTO pPetDto) {
		super();
		this.id = pPetDto.getId();
		this.id_organization = pPetDto.getMail();
		this.raza = pPetDto.getBreed();
		this.color = pPetDto.getColor();
		this.name = pPetDto.getName();
		this.acquisition_place = pPetDto.getAddress();
		this.description = pPetDto.getDescription();
	}

	public int getId() {
		return id;
	}

	public String getId_organization() {
		return id_organization;
	}

	public int getRaza() {
		return raza;
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public String getAcquisition_place() {
		return acquisition_place;
	}

	public String getDescription() {
		return description;
	}

	public Date getBirth_date() {
		return birth_date;
	}
	
	
}
