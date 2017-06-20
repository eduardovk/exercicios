package applications;
public class Room {
	
	private String north, south;
	private String east, west;
	private String up, down;
	private int numero;
	private Room proxima;
	private ItemList itemList;
	public String lastDoor = "";
	
	public ItemList getItemList() {
		return itemList;
	}
	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
	}
	public Room getProxima() {
		return proxima;
	}
	public void setProxima(Room proxima) {
		this.proxima = proxima;
	}

	public Room(String linha)
	{
		CriarSala(linha);
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	private void CriarSala(String linha)
	{
		north = south = "-";
		east = west = "-";
		up = down = "-";
		linha = linha.replace("  ", " ");
		String[] dados = linha.split(" ");
		for(int i = 0; i < dados.length; i++)
		{
			if(dados[i].equals("room"))
				numero = Integer.parseInt(dados[i+1]);
			else if(dados[i].equals("north"))
				north = dados[i+1];
			else if(dados[i].equals("south"))
				south = dados[i+1];
			else if(dados[i].equals("east"))
				east = dados[i+1];
			else if(dados[i].equals("west"))
				west = dados[i+1];
			else if(dados[i].equals("up"))
				up = dados[i+1];
			else if(dados[i].equals("down"))
				down = dados[i+1];
		}
		
		CreateItems();
	}
	
	public boolean CreateMonster(String Door, Door porta)
	{
		int num = (int) (Math.random() * 100);
		if(num <= 80)
		{
			return false;
		}
		else if (num <= 85)
		{
			itemList.Add(new Monster("Orc", "Monster", Door, porta, 83, 109));
			return true;
		}
		else if(num <= 90)
		{
			itemList.Add(new Monster("Troll", "Monster", Door, porta, 79, 138));
			return true;
		}
		else if(num <= 95)
		{
			itemList.Add(new Monster("Goblin", "Monster", Door, porta, 52, 100 ));
			return true;
		}
		else
		{
			itemList.Add(new Monster("Goblin", "Monster", Door, porta, 52, 100 ));
			return true;
		}
	}
	public void CreateItems()
	{
		itemList = new ItemList();
		if(!north.equals("-"))
		{
			Door door = new Door("North", "Door", Integer.parseInt(north), 230, 9, 110, 64, this.lastDoor);		
			door.bloqueada = CreateMonster("North", door);
			itemList.Add(door);
		}
		if(!south.equals("-"))
		{
			Door door = new Door("South", "Door", Integer.parseInt(south), 230, 500, 110, 64, this.lastDoor);
			door.bloqueada = CreateMonster("South", door);
			itemList.Add(door);
		}
		if(!east.equals("-"))
		{
			Door door = new Door("East", "Door", Integer.parseInt(east), 500, 230, 63, 110, this.lastDoor);
			door.bloqueada = CreateMonster("East", door);
			itemList.Add(door);
		}
		if(!west.equals("-"))
		{
			Door door = new Door("West", "Door", Integer.parseInt(west), 9, 230, 63, 110, this.lastDoor);
			door.bloqueada = CreateMonster("West", door);
			itemList.Add(door);
		}
		if(!up.equals("-"))
		{
			itemList.Add(new Door("Up", "Door", Integer.parseInt(up), 404, 89, 76, 70, this.lastDoor ));
		}
		if(!down.equals("-"))
		{
			itemList.Add(new Door("Down", "Door", Integer.parseInt(down), 99, 412, 62, 63, this.lastDoor ));
		}
		
		int num = (int)(Math.random() * 200);
		if(num <= 60)
		{
			
		}
		else if( num <= 70)
		{
			itemList.Add(new Key("Red", "Key", 378, 428, 86, 27));
		}
		else if(num <= 80)
		{
			itemList.Add(new Key("Blue", "Key", 378, 428, 86, 27));
		}
		else if(num <= 90)
		{
			itemList.Add(new Key("Green", "Key", 378, 428, 86, 27));
		}
		else if(num <= 100)
		{
			itemList.Add(new Key("Yellow", "Key", 378, 428, 86, 27));
		}
		else if(num <= 110)
		{
			itemList.Add(new Arma("Adaga", "Arma", 378, 428, 54, 49));
		}
		else if(num <= 120)
		{
			itemList.Add(new Arma("Faca", "Arma", 378, 428, 49, 52));
		}
		else if(num <= 130)
		{
			itemList.Add(new Arma("Espada", "Arma", 378, 428, 60, 60));
		}
		else if(num <= 140)
		{
			itemList.Add(new Arma("EspadaLonga", "Arma", 378, 428, 65, 65));
		}
		else if(num <=150)
		{
			itemList.Add(new Armadura("Escudo", "Escudo", 378, 428, 60, 60 ));
		}
		else if(num <= 160)
		{
			itemList.Add(new Armadura("ArmaduraCouro", "Armadura", 378, 428, 73, 53));
		}
		else if(num <= 170)
		{
			itemList.Add(new Armadura("ArmaduraMetal", "Armadura", 378, 428, 73, 53));
		}
		else if(num <= 180)
		{
			itemList.Add(new Armadura("ArmaduraMithril", "Armadura", 378, 428, 73, 53));
		}
	
	}
	
}