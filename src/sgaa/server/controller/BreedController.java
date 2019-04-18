package sgaa.server.controller;

import sgaa.server.dao.BreedDAO;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.BreedDTO;

public class BreedController<T>
{
	private BreedDAO<T> dao;
	
	public BreedController() 
	{
		dao	= new BreedDAO<T>();
	}
	
	public boolean insert(int id, String species, String breed) 
	{
		BreedDTO dato = new BreedDTO(id, species, breed);
		return dao.insert(dato);
	}

	public boolean update(int id, String species, String breed) 
	{
		BreedDTO dato = new BreedDTO(id, species, breed);
		return dao.update(dato);
	}

	public boolean delete(int id) 
	{
		BreedDTO dato = new BreedDTO();
		dato.setId(id);
		return dao.delete(dato);
	}

	public BreedDTO findById(int id) 
	{
		BreedDTO dato = new BreedDTO();
		dato.setId(id);
		return (BreedDTO) dao.findById(dato);
	}
	
	public IStackArray<BreedDTO>findAll()
	{
		BreedDTO dato = new BreedDTO();
		return dao.findAll(dato);
	}
}
