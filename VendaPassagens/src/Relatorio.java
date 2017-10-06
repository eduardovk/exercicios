import java.util.Scanner;

public final class Relatorio {
	
	public static void vendasPorCliente()
	{
		Cliente comprador;
		String rg;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Digite o RG do Comprador: ");
		 rg = sc.nextLine();
		 comprador = CadastroCliente.procurarCliente(rg);
		 if(comprador == null)
		 {
			 System.out.println("Cliente não encontrado.");
		 }
		 else
		 {
			 CadastroVenda.procurarVendaPorCliente(comprador);
		 }
	}
	
	public static void vendasPorOrigem()
	{
		String origem;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Digite a Origem do Voo: ");
		 origem = sc.nextLine();
			 CadastroVenda.procurarVendaPorOrigem(origem);
	}
	
	public static void vendasPorDestino()
	{
		String destino;
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Digite o Destino do Voo: ");
		 destino = sc.nextLine();
		 CadastroVenda.procurarVendaPorDestino(destino);
	}
	
	
}
