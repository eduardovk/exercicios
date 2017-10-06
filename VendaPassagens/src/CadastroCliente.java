import java.util.Scanner;

public final class CadastroCliente {
	
	private static Lista<Cliente> listaClientes = new Lista<Cliente>();
	
	public static void solicitarDados()
	{
		String RG;
		String nome;
		String telefone;
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o RG do cliente: ");
		RG = sc.nextLine();
		System.out.print("Digite o nome do cliente: ");
		nome = sc.nextLine();
		System.out.print("Digite o telefone do cliente: ");
		telefone = sc.nextLine();
		if(cadastrarCliente(RG, nome, telefone))
		{
			System.out.println("\nCliente cadastrado com sucesso.");
		}
	}
	
	private static boolean cadastrarCliente(String RG, String nome, String telefone)
	{
		listaClientes.add(new Cliente(RG, nome, telefone));
		return true;
	}
	
	public static void exibeClientes()
	{
		System.out.println("");
		Node iter = listaClientes.getHead();
		if(iter == null)
		{
			System.out.println("Nenhum cliente cadastrado.");
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
	
	public static Cliente procurarCliente(String rg)
	{
		Node iter = listaClientes.getHead();
		if(iter == null)
		{
			System.out.println("Nenhum cliente cadastrado.");
		}
		else
		{
			while (iter != null) 
			{
				if(((Cliente)iter.getDados()).getRG().equals(rg))
				{
					return (Cliente) iter.getDados();
				}
				iter = iter.next;
			}
		}
		return null;
	}
	
	public static void popular()
	{
		cadastrarCliente("123", "Marcos", "33257910");
		cadastrarCliente("321", "Fernando", "95788828");
		cadastrarCliente("456", "Lucas", "95306686");
		cadastrarCliente("654", "José", "30154789");
		cadastrarCliente("888", "Jonathan", "99774587");
		cadastrarCliente("111", "Márcio", "96331020");
	}

}
