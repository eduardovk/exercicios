import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	Option[] options;
	int opt;
	Scanner sc = new Scanner(System.in);
	
	public Menu(int size)
	{
		options = new Option[size];
	}
	
	public void show()
	{
		for(int i = 0; i < options.length; i++)
		{
			if(options[i] != null)
			{
				System.out.println(i + 1 + " - " + options[i].texto);
			}
		}
		do{
			try
			{
				sc = new Scanner(System.in);
				opt = sc.nextInt();
				if(opt < 1 || opt > (options.length))
					System.out.print("Opção Inválida. Tente novamente: ");	
			}
			catch(InputMismatchException e)
			{
				System.out.println("Opção Inválida. Tente novamente: ");
				opt = -1;
			}
		}while(opt < 1 || opt > (options.length));
		selectOption(opt - 1);
	}
	
	public void selectOption(int opt)
	{
		if(options[opt].action.equals(""))
		{
			options[opt].menu.show();
		}
		else if(options[opt].action.equals("sair"))
		{
			System.out.println("Programa Encerrado.");
			return;
		}
		else
		{
			Action.executeAction(options[opt].action);
			show();
		}
	}
}
