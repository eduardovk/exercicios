
public class Node<T> {
	public Node<T> previous, next;
	private T data;
	
	public Node(T data)
	{
		this.data = data;
	}
	
	public T getData()
	{
		return data;
	}		
 
    public boolean hasNext()
    {
    	if(this.next() != null)
    	{
    		return true;
    	}
    	return false;
    }

    public boolean hasPrevious()
    {
    	if(this.previous() != null)
    	{
    		return true;
    	}
    	return false;
    }

    public Node<T> next()
    {
    	return this.next;
    }

    public Node<T> previous()
    {
    	return this.previous;
    }
    
    public boolean insertAfter(T valor)
    {
    	Node<T> novo = new Node<T>(valor);
    	if(hasNext())
    	{
    		Node<T> tempNode = next();
    		this.next = novo;
    		this.next().previous = this;
    		this.next().next = tempNode;
    		tempNode.previous = novo;
    		return true;
    	}
    	else
    	{
    		this.next = novo;
    		novo.previous = this;
    		return true;
    	}
    	
    }
    
    public boolean insertBefore(T valor)
    {
    		Node<T> novo = new Node<T>(valor);
    		novo.previous = previous;
    		previous.next = novo;
    		this.previous = novo;
    		previous.next = this;
    	
    	return true;
    }
    
    public void remove()
    {
    	previous.next = next;
    	next.previous = previous;
    }
}
