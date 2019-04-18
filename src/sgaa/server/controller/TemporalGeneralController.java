package sgaa.server.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.postgresql.util.PSQLException;

public class TemporalGeneralController<T> 
{
	private AdoptionController<T> adoption;
	private BreedController<T> breed;
	private OrganizationController<T> organization;
	private PetController<T> pet;
	private UserController<T> user;
	
	public TemporalGeneralController() 
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
	
	//TODO
	public static void main(String[] args) 
	{
		TemporalGeneralController<TemporalGeneralController> obj = new TemporalGeneralController<TemporalGeneralController>();
		
		String mail = "losanadsojadsadssdaja@gmail.com";
		long phone =  3183769455L;
		Calendar fechaActual = Calendar.getInstance();
		fechaActual.set(2019, 01-1, 8);
		Date dateR = fechaActual.getTime();
		System.out.println(dateR);
		
		boolean fe = false;
		fe = obj.getUser().insert(mail, "123", "Felipe", "Calle 3*23", phone, dateR, dateR);
		System.out.println(fe);
		if(fe == true)
		{
			System.out.println("Se registro correctamente el usuario");
		}else
		{
			System.out.println("¡Al parecer ya existe ese correo en nuestra base de datos o hay un error en la base de datos!");
		}
		
		//System.out.println("¡Se registro el usuario correctamente en la base de datos!");
		
		
		//System.out.println(obj.getUser().findById(mail).getName());
		//System.out.println(obj.getUser().findById(mail).getPassword());
		//System.out.println(obj.getOrganization().findById(mail).getName());
		//System.out.println(obj.getOrganization().findById(mail).getName());
		
	}
}
