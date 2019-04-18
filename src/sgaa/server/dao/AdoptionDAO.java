package sgaa.server.dao;

import sgaa.server.dto.AdoptionDTO;


public class AdoptionDAO<T> extends GenericDAO<AdoptionDTO>
{
	public AdoptionDAO() 
	{	
		super(AdoptionDTO.class);
	}
}
