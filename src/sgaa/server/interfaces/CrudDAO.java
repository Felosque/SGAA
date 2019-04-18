package sgaa.server.interfaces;

import java.util.List;

public interface CrudDAO<T> {
	
	public boolean insert(Crud dato);
	
	public boolean update(Crud dato);
	
	public boolean delete(Crud dato);
	
	public Crud findById(Crud dato);
	
	public List<T> findAll();

}
