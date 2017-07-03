
public class ListaEncadeada<T> {
	private Node<T> head;
	private Node<T> tail;
	private int totalElementos = 0;
	
	public void append(T valor)
	{
		Node<T> node = new Node<T>(valor);
		if(totalElementos == 0)
			this.head = node;
		else
		{
			this.tail.next = node;	
			node.previous = this.tail;
		}
		this.tail = node;
		totalElementos++;
	}
	
	public void addFirst(T valor)
	{
			Node<T> node = new Node<T>(valor);
	    	Node<T> tempNode = this.getFirst();
	    	this.head = node;
	    	tempNode.previous = this.head;
	    	this.head.next = tempNode;
	    	totalElementos++;
	}
	
	public void remove(Node<T> node)
	{
		
		try
		{
			if(this.head != node)
			{
				Node<T> itemAnterior = node.previous();
				Node<T> proxItem = node.next();
				itemAnterior.next = proxItem;
				
				if(this.tail != node)
				{
					proxItem.previous = itemAnterior;
				}
				else
				{
					tail = itemAnterior;
				}				
			}
			else
			{
				this.head = node.next();
				this.head.previous = null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		totalElementos--;
	}
	
	public Node<T> getFirst()
	{
		return head;
	}
	
	public Node<T> getLast()
	{
		return tail;
	}
    
    public boolean hasObject(Node<T> node)
    {
    	Node<T> atual = getFirst();

    	while(atual != null)
    	{
    		if(node.equals(atual))
    		{
    			return true;
    		}
    		atual = atual.next();
    	}
    	return false;
    }
	
}
