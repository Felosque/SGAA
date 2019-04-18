package sgaa.server.dao;

import sgaa.server.dto.OrganizationDTO;

public class OrganizationDAO<T> extends GenericDAO<OrganizationDTO>{

	public OrganizationDAO() {	
		super(OrganizationDTO.class);
	}
	
}
