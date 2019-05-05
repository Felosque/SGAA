package sgaa.server.controller;

import java.util.Date;

import sgaa.server.dao.AdoptionDAO;
import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.dto.AdoptionDTO;


public class AdoptionController<T> {
	
	private AdoptionDAO<T> dao;
	
	public AdoptionController()
	{
		dao = new AdoptionDAO<T>();
	}
	
	public boolean insert(String mail, int idPet, Date transactionDate)
	{
		AdoptionDTO dato = new AdoptionDTO(-1,  mail, idPet, transactionDate);
		return dao.insert(dato);
	}

	public boolean update(int id, String mail, int idPet, Date transactionDate)
	{
		AdoptionDTO dato = new AdoptionDTO(id, mail, idPet, transactionDate);
		return dao.update(dato);
	}

	public boolean delete(int id)
	{
		AdoptionDTO dato = new AdoptionDTO();
		dato.setId(id);
		return dao.delete(dato);
	}

	public AdoptionDTO findById(int id)
	{
		AdoptionDTO dato = new AdoptionDTO();
		dato.setId(id);
		return (AdoptionDTO) dao.findById(dato);
	}

	public IStackArray<AdoptionDTO>findAll(String mail)
	{
		AdoptionDTO dato = new AdoptionDTO();
		dato.setMail(mail);
		return dao.findAll(dato);
	}
	
}
