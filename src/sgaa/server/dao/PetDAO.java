package sgaa.server.dao;

import sgaa.server.dto.PetDTO;

public class PetDAO<T> extends GenericDAO<PetDTO>
{
	public PetDAO() 
	{	
		super(PetDTO.class);
	}
}
