import java.util.InputMismatchException;
import java.util.Scanner;

public final class CadastroVoo {
	
	private static Lista<Voo> listaVoos = new Lista<Voo>();
	private static short cod = 0; //MUDAR
	
	private static boolean cadastrarVoo(String origem, String destino, Aviao aviao, String horario)
	{
		Voo novoVoo = new Voo(origem, destino, aviao, cod, horario);
		listaVoos.add(novoVoo);
		cod++;
		return true;
	}
	
	public static void solicitarDados()
	{
		Scanner sc = new Scanner(System.in);
		short codAviao = -1;
		String origem, destino, horario;
		try
		{
			System.out.println("Digite o código do Avião utilizado neste voo: ");
			codAviao = sc.nextShort();
			Aviao aviao = CadastroAviao.procurarAviao(codAviao);
			if(aviao == null)
			{
				System.out.println("Avião não encontrado.");
			}
			else
			{
				sc = new Scanner(System.in);
				System.out.println("Digite a origem do voo: ");
				origem = sc.nextLine();
				System.out.println("Digite o destino do voo: ");
				destino = sc.nextLine();
				System.out.println("Digite o horário do voo: ");
				horario = sc.nextLine();
				if(cadastrarVoo(origem, destino, aviao, horario))
					System.out.println("\nVoo cadastrado com sucesso. \n");
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Entrada de dados inválida!");
		}
	}
	
	public static Voo procurarVoo(short codigo)
	{
		Node iter = listaVoos.getHead();
		if(iter == null)
		{
			System.out.println("Nenhum Voo cadastrado.");
		}
		else
		{
			while (iter != null) 
			{
				if(((Voo)iter.getDados()).getCodigo() == codigo)
				{
					return (Voo) iter.getDados();
				}
				iter = iter.next;
			}
		}
		return null;
	}
	
	public static void exibeVoos()
	{

		System.out.println("");
		Node iter = listaVoos.getHead();
		if(iter == null)
		{
			System.out.println("Nenhum voo cadastrado.");
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
	
	public static void popular()
	{
		Aviao aviao1 = CadastroAviao.procurarAviao((short)0);
		cadastrarVoo( "Marte",  "Terra",  aviao1,  "15:30");
		Aviao aviao2 = CadastroAviao.procurarAviao((short)1);
		cadastrarVoo( "Paris",  "Berlim",  aviao2,  "00:55");
		Aviao aviao3 = CadastroAviao.procurarAviao((short)1);
		cadastrarVoo( "Berlim",  "Milão",  aviao3,  "05:00");
		Aviao aviao4 = CadastroAviao.procurarAviao((short)2);
		cadastrarVoo( "Rio de Janeiro",  "Buenos Aires",  aviao4,  "21:30");
		Aviao aviao5 = CadastroAviao.procurarAviao((short)3);
		cadastrarVoo( "Porto Alegre",  "Miami",  aviao5,  "02:40");
		Aviao aviao6 = CadastroAviao.procurarAviao((short)3);
		cadastrarVoo( "São Paulo",  "Tóquio",  aviao6,  "10:00");
	}
	
	
	
}
