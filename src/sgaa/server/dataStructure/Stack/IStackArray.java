package sgaa.server.dataStructure.Stack;

public class IStackArray<T> {

	private IObjectStack<T> head;
	
	public IStackArray() {
		head = null;
	}
	
	public void add(T pObject) {	
		if(head == null) {
			IObjectStack<T> obj = new IObjectStack<T>(pObject);
			head = obj;
		}else
		{
			IObjectStack<T> obj = new IObjectStack<T>(pObject);
			getTheLastObject().setNextObject(obj);
		}
	}
	
	public void remove(T object)
	{
		IObjectStack<T> travel = head;
		if(head != null)
		{
			if(head.getObject() == object)
			{
				if(head.getNextObject() != null)
				{
					head = head.getNextObject();
				}else
				{
					head = null;
				}
			}
			while(travel != null && travel.getNextObject() != null)
			{
				IObjectStack<T> nextObject = travel.getNextObject();
				
				if(nextObject.getObject() == object)
				{
					if(nextObject.getNextObject() != null) {
						
						travel.setNextObject(nextObject.getNextObject());
						nextObject.setNextObject(null);
					}
					else if(nextObject.getNextObject() == null)
					{
						travel.setNextObject(null);
						break;
					}
					
				}else
				{
					travel = travel.getNextObject();
				}
			}
		}
	}
	
	public void clear()
	{
		head = null;
	}
	
	public T get(int pNumber)
	{
		IObjectStack<T> travel = head;
		int count = 0;
		if(head != null)
		{
			while(travel != null)
			{
				if(count == pNumber)
				{
					break;
				}
				travel = travel.getNextObject();
				count++;
			}
		}
		return travel.getObject();
	}
	
	public int size()
	{
		IObjectStack<T> travel = head;
		int count = 0;
		if(head != null)
		{
			while(travel != null)
			{
				travel = travel.getNextObject();
				count++;
			}
		}
		return count;
	}
	
	public  void viewConsoleObjects()
	{
		IObjectStack<T> travel = head;
		while(travel != null)
		{
			System.out.println(travel.getObject());
			travel = travel.getNextObject();
		}
	}
	
	private IObjectStack<T> getTheLastObject()
	{
		IObjectStack<T> travel = head;
		while(travel.getNextObject() != null)
		{
			travel = travel.getNextObject();
		}
		return travel;
	}
	

}
