package sgaa.server.dataStructure.Stack;

public interface Stack<T> 
{
	public void push(T item) throws StackFull;

	public T pop() throws StackEmpty;
}
