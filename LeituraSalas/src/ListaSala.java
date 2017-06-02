
public class ListaSala {
	
	private Sala head;
	private Sala tail;
	private int totalElementos = 0;
	
	public void Add(Sala sala)
	{
		if(totalElementos == 0)
			this.head = sala;
		else
			this.tail.setProxima(sala);			
		this.tail = sala;
		totalElementos++;
	}
	
	public Sala GetSalaByNumber(int number) throws ArrayIndexOutOfBoundsException
	{
		Sala atual = head;
		for(int i = 0; i < totalElementos; i++)
		{
			if(atual.getNumero() == number)
				return atual;
			atual = atual.getProxima();
		}
		throw new ArrayIndexOutOfBoundsException();
	}
		
	public int GetTamanho()
	{
		return totalElementos;
	}
	
}
