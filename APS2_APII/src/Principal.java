import java.io.File;
import java.util.Scanner;

import com.senac.SimpleJava.Console;
import java.util.InputMismatchException;
public class Principal {
	public void run()
	{
		File file = new File("rooms.txt");
		
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine())
			{
				Console.println(sc.nextLine());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		String teste = "oi como vai    voce";
		String[] arrayString = teste.split(" ");
		for(int i = 0; i < arrayString.length; i++)
		{
			Console.println(arrayString[i]);
		}
	}
}
