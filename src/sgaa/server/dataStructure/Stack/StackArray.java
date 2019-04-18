package sgaa.server.dataStructure.Stack;

public class StackArray<T> implements Stack<T> 
{
	private int top;
	private int size;
	private T data[];
	
	public StackArray(int size) 
	{
		this.size = size;
		this.top = -1;
		data = (T[]) new Object[size];
	}

	public StackArray() 
	{
		this(5);
	}
	
	public int length()
	{
		return size;
	}
	
	public T getObject(int pValue)
	{
		return (T)data[pValue];
	}

	@Override
	public void push(T item) throws StackFull 
	{
		if(top == size -1) {
			throw new StackFull("Stack Full");
		}
		data[++top] = item;
	}

	@Override
	public T pop() throws StackEmpty 
	{
		if(top == -1) {
			throw new StackEmpty("Stack is empty");
		}
		return data[top--];
	}
}
