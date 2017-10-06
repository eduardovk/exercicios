
public class Node<T> {
	
	public Node<T> previous;
	public Node<T> next;
	private T dados;
	
	public Node(T valor)
	{
		this.dados = valor;
	}
	
	public T getDados()
	{
		return this.dados;
	}
	
	public boolean hasNext()
	{
		if(this.next != null)
    	{
    		return true;
    	}
    	return false;
	}
	
	public boolean hasPrevious()
	{
		if(this.previous != null)
    	{
    		return true;
    	}
    	return false;
	}
	
	public Node<T> getNext()
	{
		return this.next;
	}
	
	public boolean insertAfter(T valor)
	{
		Node<T> novo = new Node<T>(valor);
    	if(hasNext())
    	{
    		Node<T> tempNode = next;
    		this.next = novo;
    		this.next.previous = this;
    		this.next.next = tempNode;
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
