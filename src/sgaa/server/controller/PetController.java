package sgaa.server.controller;

import java.sql.Date;

import javax.swing.ImageIcon;

import sgaa.server.dao.PetDAO;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.PetDTO;

public class PetController<T>
{
	private PetDAO<T> dao;
	
	public PetController() 
	{
		dao = new PetDAO<T>();
	}
	
	public boolean insert(int id, String name, String color, String address, Date birthdate, boolean state, int breed, String mail, ImageIcon image, String pDescription) 
	{
		PetDTO dato = new PetDTO(id, name, color, address, birthdate, state, breed, mail, image, pDescription);
		return dao.insert(dato);
	}

	public boolean update(int id, String name, String color, String address, Date birthdate, boolean state, int breed, String mail, ImageIcon image, String pDescription) 
	{
		PetDTO dato = new PetDTO(id, name, color, address, birthdate, state, breed, mail, image, pDescription);
		return dao.update(dato);
	}

	public boolean delete(int id) 
	{
		PetDTO dato = new PetDTO();
		dato.setId(id);
		return dao.delete(dato);
	}

	public PetDTO findById(int id) 
	{
		PetDTO dato = new PetDTO();
		dato.setId(id);
		return (PetDTO) dao.findById(dato);
	}
	
	public IStackArray<PetDTO>findAll(String mail)
	{
		PetDTO dato = new PetDTO(0, null, null, null, new java.util.Date(), false, 0, mail, null, null);
		return dao.findAll(dato);
	}
}
