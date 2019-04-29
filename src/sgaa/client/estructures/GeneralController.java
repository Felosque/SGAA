package sgaa.client.estructures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.postgresql.util.PSQLException;

import sgaa.server.controller.AdoptionController;
import sgaa.server.controller.BreedController;
import sgaa.server.controller.OrganizationController;
import sgaa.server.controller.PetController;
import sgaa.server.controller.UserController;

public class GeneralController<T> 
{
	private AdoptionController<T> adoption;
	private BreedController<T> breed;
	private OrganizationController<T> organization;
	private PetController<T> pet;
	private UserController<T> user;
	
	public GeneralController() 
	{
		setAdoption(new AdoptionController<T>());
		setBreed(new BreedController<T>());
		setOrganization(new OrganizationController<T>());
		setPet(new PetController<T>());
		setUser(new UserController<T>());
	}

	public BreedController<T> getBreed() {
		return breed;
	}

	public void setBreed(BreedController<T> breed) {
		this.breed = breed;
	}

	public AdoptionController<T> getAdoption() {
		return adoption;
	}

	public void setAdoption(AdoptionController<T> adoption) {
		this.adoption = adoption;
	}

	public OrganizationController<T> getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationController<T> organization) {
		this.organization = organization;
	}

	public PetController<T> getPet() {
		return pet;
	}

	public void setPet(PetController<T> pet) {
		this.pet = pet;
	}

	public UserController<T> getUser() {
		return user;
	}

	public void setUser(UserController<T> user) {
		this.user = user;
	}
}
