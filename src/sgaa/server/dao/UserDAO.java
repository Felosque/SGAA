package sgaa.server.dao;

import sgaa.server.dto.UserDTO;

public class UserDAO<T> extends GenericDAO<UserDTO>
{
	public UserDAO() 
	{	
		super(UserDTO.class);
	}
}
