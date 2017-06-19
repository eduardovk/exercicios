package applications;

public class RoomList {
	
	private Room head;
	private Room tail;
	private int totalElementos = 0;
	
	public void Add(Room room)
	{
		if(totalElementos == 0)
			this.head = room;
		else
			this.tail.setProxima(room);			
		this.tail = room;
		totalElementos++;
	}
		
	public int GetTamanho()
	{
		return totalElementos;
	}
	
	public Room GetRoomByNumber(int number) throws ArrayIndexOutOfBoundsException
	{
		Room atual = head;
		for(int i = 0; i < totalElementos; i++)
		{
			if(atual.getNumero() == number)
				return atual;
			atual = atual.getProxima();
		}
		throw new ArrayIndexOutOfBoundsException();
	}
	
}
