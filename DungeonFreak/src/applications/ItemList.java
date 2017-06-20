package applications;

public class ItemList {
	
	private Item head;
	private Item tail;
	private int totalElementos = 0;
	
	public Item getHead()
	{
		return head;
	}
	
	public void Add(Item item)
	{
		if(totalElementos == 0)
			this.head = item;
		else
		{
			this.tail.setProximo(item);	
			item.setAnterior(this.tail);

		}
		this.tail = item;
		totalElementos++;
	}
	
	public void Remove(Item item)
	{
		
		try
		{
			if(this.head != item)
			{
				Item itemAnterior = item.getAnterior();
				Item proxItem = item.getProximo();
				itemAnterior.setProximo(proxItem);
				
				if(this.tail != item)
				{
					proxItem.setAnterior(itemAnterior);
				}
				else
				{
					tail = itemAnterior;
				}
				
			}
			else
			{
				this.head = item.getProximo();
				this.head.setAnterior(null);
			}
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		totalElementos--;
	}
		
	public int GetTamanho()
	{
		return totalElementos;
	}
	
}
