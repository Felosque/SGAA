package sgaa.server.dataStructure.Stack;

public class IObjectStack<T> {

	private T object;
	private IObjectStack<T> nextObject;
	
	public IObjectStack(T pObject) {
		object = pObject;
		nextObject = null;
	}

	public T getObject() {
		return object;
	}

	public IObjectStack<T> getNextObject() {
		return nextObject;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public void setNextObject(IObjectStack<T> nextObject) {
		this.nextObject = nextObject;
	}

	
}
