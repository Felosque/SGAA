package sgaa.server.dto;

import sgaa.server.interfaces.Crud;

public class BreedDTO implements Crud
{
	private int id;
	private String species;
	private String breed;
	/**
	 * 
	 */
	public BreedDTO() {
		super();
	}
	/**
	 * @param id
	 * @param species
	 * @param breed
	 */
	public BreedDTO(int id, String species, String breed) {
		super();
		this.id = id;
		this.species = species;
		this.breed = breed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return "INSERT INTO public.breed(id, species, breed) VALUES ('"+id+"', '"+species+"', '"+breed+"');";
	}
	@Override
	public String update() {
		// TODO Auto-generated method stub
		return "UPDATE public.breed SET id= '"+id+"', species= '"+species+"', breed= '"+breed+"' where id = "+id+";";
	}
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "DELETE from public.user where id = "+id+";";
	}
	@Override
	public String findById() {
		// TODO Auto-generated method stub
		return "SELECT id, species, breed FROM public.breed where id = "+id+";";
	}
	@Override
	public String findAll() {
		// TODO Auto-generated method stub
		return "SELECT id, species, breed FROM public.breed;";
	}
	
	
}
