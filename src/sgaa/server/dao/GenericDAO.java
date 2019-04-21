package sgaa.server.dao;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import sgaa.server.dataStructure.Stack.IStackArray;
import sgaa.server.infrastructure.Conexion;
import sgaa.server.interfaces.Crud;

public class GenericDAO<T>
{
	private Class<T> entityClass;
	private Method[] daoMethods;
	protected Conexion con;

	public GenericDAO(Class<T> entityClass) 
	{
		this.entityClass = entityClass;
		this.daoMethods = entityClass.getMethods();
		this.con = Conexion.getInstance();
	}

	public boolean insert(Crud dato) 
	{
		return con.executeQuery(dato.insert());
	}

	public boolean update(Crud dato) 
	{
		return con.executeQuery(dato.update());
	}

	public boolean delete(Crud dato) 
	{
		return con.executeQuery(dato.delete());
	}

	public Crud findById(Crud dato) 
	{
		ResultSet rs = con.getQuery(dato.findById());
		return getQuerySingle(rs);
	}

	protected Crud getQuerySingle(ResultSet rs) 
	{
		T newObjet = null;

		try 
		{
			ResultSetMetaData rsMD = rs.getMetaData();
			while (rs.next())
			{
				newObjet = entityClass.getDeclaredConstructor().newInstance();
				for(int i = 1; i <= rsMD.getColumnCount(); i++)
				{
					Method methodToInvoked = methodToInvoked(nameMethod(rsMD.getColumnName(i)));
					if(methodToInvoked == null) 
					{
						throw new Exception("Metodo no encontrado");
					}
					else {
						//System.out.println(methodToInvoked.toString());
						methodToInvoked.invoke(newObjet, rs.getObject(i));
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return (Crud) newObjet;
	}

	public IStackArray<T> findAll(Crud dato) 
	{
		ResultSet rs = con.getQuery(dato.findAll());
		IStackArray<T> list = getQueryList(rs);
		return list;
	}

	//TODO 	Se puede elminar el código comentado
	protected IStackArray<T> getQueryList(ResultSet rs) 
	{
		T newObjet = null;

		//	List<T> dates = new LinkedList<T>();
		IStackArray<T> dates =  new IStackArray<T>();
		try 
		{
			ResultSetMetaData rsMD = rs.getMetaData();
			while(rs.next())
			{
				newObjet = entityClass.getDeclaredConstructor().newInstance();
				for(int i = 1; i <= rsMD.getColumnCount(); i++)
				{
					Method methodToInvoked =  methodToInvoked(nameMethod(rsMD.getColumnName(i)));
					if(methodToInvoked == null) 
					{
						throw new Exception("Metodo no encontrado");
					}
					else {
						//System.out.println(methodToInvoked.toString());
						methodToInvoked.invoke(newObjet, rs.getObject(i));
					}
				}
				//	dates.add(newObjet);
				dates.add(newObjet);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		//	return new ArrayList<T>(dates);
		return dates;
	}

	//Retorna el método que se va a ejecutar
	private Method methodToInvoked(String nameMethod) 
	{
		for (int i = 0; i < daoMethods.length; i++) {
			if(daoMethods[i].getName().equals(nameMethod))
			{
				return daoMethods[i];
			}
		}
		return null;
	}

	//Construye el nombre del método
	private String nameMethod(String columnName) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("set");

		if(columnName.indexOf("_") >= 1) {
			String[] subStrings = columnName.split("_");
			
			for(int i = 0; i < subStrings.length; i++)
			{
				buffer.append(subStrings[i].substring(0, 1).toUpperCase()+subStrings[i].substring(1, subStrings[i].length()).toLowerCase());
			}
			//System.out.println(buffer.toString());		
		}else 
		{
			buffer.append(columnName.substring(0, 1).toUpperCase()+ columnName.substring(1).toLowerCase());
			//System.out.println(buffer.toString());
		}
		return buffer.toString();
	}
}
