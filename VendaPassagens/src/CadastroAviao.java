import java.util.InputMismatchException;
import java.util.Scanner;

public final class CadastroAviao {
	
	private static Lista<Aviao> listaAvioes = new Lista<Aviao>();
	private static short cod = 0;
	
	public static boolean cadastrarAviao(String nome, short qtdAssentos)
	{
		listaAvioes.add(new Aviao(cod, nome, qtdAssentos));
		cod++;
		return true;
	}
	
	public static void solicitarDados()
	{
		String nome; 
		short qtdAssentos;
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o nome do Avião: ");
		try
		{
			nome = sc.nextLine();
			System.out.print("Digite a quantidade de assentos: ");
			qtdAssentos = sc.nextShort();
			if(cadastrarAviao(nome, qtdAssentos))
			{
				System.out.println("\nAvião cadastrado com sucesso.");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Entrada de dados inválida!");
		}
	}
	
	public static void exibeAvioes()
	{
		System.out.println("");
		Node<Aviao> iter = listaAvioes.getHead();
		if(iter == null)
		{
			System.out.println("Nenhum avião cadastrado.");
		}
		else
		{
			while (iter != null) 
			{
				System.out.println(iter.getDados().toString());
				iter = iter.next;
				System.out.println("---------");
			}
		}
		System.out.println("");
	}
	
	public static Aviao procurarAviao(short codigo)
	{
		Node<Aviao> iter = listaAvioes.getHead();
		if(iter == null)
		{
			System.out.println("Nenhum avião cadastrado.");
		}
		else
		{
			while (iter != null) 
			{
				if(((Aviao)iter.getDados()).getCodigo() ==(codigo))
				{
					return (Aviao) iter.getDados();
				}
				iter = iter.next;
			}
		}
		return null;
	}
	
	public static void popular()
	{
		cadastrarAviao("OVNI",  (short)250);
		cadastrarAviao("Boeing 747", (short)150);
		cadastrarAviao("Jatinho de Ouro", (short)40);
		cadastrarAviao("AeroJet 900", (short)320);
		
	}
}
