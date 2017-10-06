
public class Lista<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int totalElementos = 0;
	
	public Node<T> getHead() {
		return head;
	}
	public Node<T> getTail() {
		return tail;
	}
	
	public boolean hasNode(Node<T> node)
	{
		return false;
	}
	
	
	public void add(T valor)
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
	
	public void remove(Node<T> node)
	{
		try
		{
			if(this.head != node)
			{
				Node<T> itemAnterior = node.previous;
				Node<T> proxItem = node.next;
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
				this.head = node.next;
				this.head.previous = null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		totalElementos--;
	}
	
}
