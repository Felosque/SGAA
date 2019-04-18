package sgaa.server.controller;

import java.sql.Date;

import sgaa.server.dao.OrganizationDAO;
import sgaa.server.dataStructure.Stack.StackArray;
import sgaa.server.dto.OrganizationDTO;

public class OrganizationController<T> 
{
	private OrganizationDAO<T> dao;

	public OrganizationController()
	{
		dao = new OrganizationDAO<T>();
	}

	public boolean insert(String mail ,String password, String name, String address, int phoneNumber, Date birthdate, Date registrationDate)
	{
		OrganizationDTO dato = new OrganizationDTO(mail, password, name, address, phoneNumber, registrationDate);
		return dao.insert(dato);
	}

	public boolean update(String mail ,String password, String name, String address, int phoneNumber, Date birthdate, Date registrationDate)
	{
		OrganizationDTO dato = new OrganizationDTO(mail, password, name, address, phoneNumber, registrationDate);
		return dao.update(dato);
	}

	public boolean delete(String mail)
	{
		OrganizationDTO dato = new OrganizationDTO();
		dato.setMail(mail);
		return dao.delete(dato);
	}

	public OrganizationDTO findById(String mail)
	{
		OrganizationDTO dato = new OrganizationDTO();
		dato.setMail(mail);
		return (OrganizationDTO) dao.findById(dato);
	}

	public StackArray<OrganizationDTO>findAll()
	{
		OrganizationDTO dato = new OrganizationDTO();
		return dao.findAll(dato);
	}
}
