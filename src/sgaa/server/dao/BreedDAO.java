package sgaa.server.dao;

import sgaa.server.dto.BreedDTO;

public class BreedDAO<T> extends GenericDAO<BreedDTO>
{
	public BreedDAO() 
	{
		super(BreedDTO.class);
	}
}
