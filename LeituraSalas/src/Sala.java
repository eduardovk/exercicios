import com.senac.SimpleJava.Console;

public class Sala {
	
	private String north, south;
	private String east, west;
	private String up, down;
	private int numero;
	private Sala proxima;
	
	public Sala getProxima() {
		return proxima;
	}
	public void setProxima(Sala proxima) {
		this.proxima = proxima;
	}

	public Sala(String linha)
	{
		CriarSala(linha);
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	
	
	private void CriarSala(String linha)
	{
		north = south = "--";
		east = west = "|";
		up = down = "  ";
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
	}
	
	public void PrintaDados()
	{
		Console.println("\nNumero da Sala: " + numero);
		if(!north.equals("--"))
			Console.println("North: " + north);
		if(!south.equals("--"))
			Console.println("South: " + south);
		if(!east.equals("|"))
			Console.println("East: " + east);
		if(!west.equals("|"))
			Console.println("West: " + west);
		if(!up.equals("  "))
			Console.println("Up: " + up);
		if(!down.equals("  "))
			Console.println("Down: " + down);
		
		Console.println("\n----"+north+"----");
		Console.println("|   "+up+"   |");
		Console.println(west+"        "+east);
		Console.println("|   "+down+"   |");
		Console.println("----"+south+"----");
	}
	
}
