import java.io.File;
import java.util.Scanner;

import com.senac.SimpleJava.Console;

public class Principal {
	public void run()
	{
		Scanner sc = new Scanner(System.in);
		ListaSala listaSalas = new ListaSala();
		CarregarSalas("rooms.txt", listaSalas); 
		PrintaModelo();
		while(true)
		{
			Console.print("\nDigite o numero da sala, ou 0 para encerrar: ");
			
			try
			{
				int numeroSala = Integer.parseInt(sc.nextLine());
				if(numeroSala == 0)
					break;
				listaSalas.GetSalaByNumber(numeroSala).PrintaDados();
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				Console.println("\nNúmero de sala não encontrada.");
			}
			catch(Exception e)
			{
				Console.println("\nErro! Tente novamente. ");
			}
		}
		sc.close();
		Console.println("\nPrograma Encerrado.");
	}
	
	private void CarregarSalas(String arquivo, ListaSala lista)
	{
		File file = new File(arquivo);
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				Sala sala = new Sala(sc.nextLine());
				lista.Add(sala);
			}
			sc.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	private void PrintaModelo()
	{
		Console.println("\n----North----");
		Console.println("|    Up     |");
		Console.println("West     East     <-- Modelo de Sala");
		Console.println("|   Down    |");
		Console.println("----South----");
	}
}
