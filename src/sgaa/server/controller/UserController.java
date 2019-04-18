package sgaa.server.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import sgaa.server.dao.UserDAO;
import sgaa.server.dataStructure.Stack.StackArray;
import sgaa.server.dto.UserDTO;


public class UserController<T> {

	private UserDAO<T> dao;

	public UserController()
	{
		dao = new UserDAO<T>();
	}

	public boolean insert(String mail ,String password, String name, String address, long phone, java.util.Date fecha, java.util.Date fecha2)
	{
		UserDTO dato = new UserDTO(mail, password, name, address, phone, fecha, fecha2);
		return dao.insert(dato);
	}
	
	public boolean update(String mail ,String password, String name, String address, int phoneNumber, Date birthdate, Date registrationDate)
	{
		UserDTO dato = new UserDTO(mail, password, name, address, phoneNumber, birthdate, registrationDate);
		
		return dao.update(dato);
	}

	public boolean delete(String mail)
	{
		UserDTO dato = new UserDTO();
		dato.setMail(mail);
		return dao.delete(dato);
	}

	public UserDTO findById(String mail)
	{
		UserDTO dato = new UserDTO();
		dato.setMail(mail);
		
		return (UserDTO) dao.findById(dato);
	}

	public StackArray<UserDTO>findAll()
	{
		UserDTO dato = new UserDTO();
		return dao.findAll(dato);
	}

}
