import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class CadastroVenda {

	private static Lista<Venda> listaVendas = new Lista<Venda>();
	
	public static boolean cadastrarVenda(Cliente cliente, Voo voo, String horarioCompra)
	{
		listaVendas.add(new Venda(cliente, voo, horarioCompra));
		System.out.println("Venda cadastrada com sucesso.");
		return true;
	}
	
	 public static void solicitarDados()
	 {
		 Cliente comprador;
		 String rg;
		 String horarioCompra;
		 short cod;
		 
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
			 try
			 {
				 System.out.println("Digite o código do Voo: ");
				 cod = sc.nextShort();
				 Voo voo = CadastroVoo.procurarVoo(cod);
				 if(voo == null)
				 {
					 System.out.println("Voo não encontrado.");
				 }
				 else
				 {
					 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
					 Date date = new Date();
					 horarioCompra = dateFormat.format(date).toString();
					 cadastrarVenda(comprador, voo, horarioCompra);
				 }
			 }
			 catch(InputMismatchException e)
			 {
				 System.out.println("Entrada de dados inválida!");
			 }
			 
		 }
	 }
	 
	 public static void exibeVendas(Cliente cliente)
	 {
		 System.out.println("");
			Node iter = listaVendas.getHead();
			if(iter == null)
			{
				System.out.println("Nenhuma venda cadastrado.");
			}
			else
			{			
				while (iter != null) 
				{
					if(cliente != null && ((Venda)(iter.getDados())).getCliente().getRG().equals(cliente.getRG()))
					{
						System.out.println(iter.getDados().toString());
						iter = iter.next;
						System.out.println("---------");
					}
					else if(cliente == null)
					{
						System.out.println(iter.getDados().toString());
						iter = iter.next;
						System.out.println("---------");
					}
					else
					{
						iter = iter.next;
					}
				}
			}
			System.out.println("");
	 }
	 
	 public static void procurarVendaPorCliente(Cliente cliente)
	 {
		 exibeVendas(cliente);
	 }
	 
	 public static void procurarVendaPorOrigem(String origem)
	 {
		 boolean resultado = false;
		 System.out.println("");
			Node iter = listaVendas.getHead();
			if(iter == null)
			{
				System.out.println("Nenhuma venda cadastrado.");
			}
			else
			{			
				while (iter != null) 
				{
					if(((Venda)iter.getDados()).getVoo().getOrigem().equals(origem))
					{
						System.out.println(iter.getDados().toString());
						System.out.println("---------");
						resultado = true;
					}
					iter = iter.next;
				}
				if(!resultado)
					System.out.println("Nenhuma venda encontrada com esta Origem.");
			}
			System.out.println("");
	 }
	 
	 
	 public static void procurarVendaPorDestino(String destino)
	 {
		 boolean resultado = false;
		 System.out.println("");
			Node iter = listaVendas.getHead();
			if(iter == null)
			{
				System.out.println("Nenhuma venda cadastrado.");
			}
			else
			{			
				while (iter != null) 
				{
					if(((Venda)iter.getDados()).getVoo().getDestino().equals(destino))
					{
						System.out.println(iter.getDados().toString());
						System.out.println("---------");
						resultado = true;
					}
					iter = iter.next;
				}
				if(!resultado)
					System.out.println("Nenhuma venda encontrada com este Destino.");
			}
			System.out.println("");
	 }

	public static void popular() {
		listaVendas.add(new Venda(CadastroCliente.procurarCliente("123"), CadastroVoo.procurarVoo((short) 0), "15:00"));
		listaVendas.add(new Venda(CadastroCliente.procurarCliente("123"), CadastroVoo.procurarVoo((short) 2), "17:45"));
		listaVendas.add(new Venda(CadastroCliente.procurarCliente("456"), CadastroVoo.procurarVoo((short) 2), "08:15"));
		listaVendas.add(new Venda(CadastroCliente.procurarCliente("654"), CadastroVoo.procurarVoo((short) 1), "12:00"));
		listaVendas.add(new Venda(CadastroCliente.procurarCliente("888"), CadastroVoo.procurarVoo((short) 3), "21:20"));
		
	}
}
