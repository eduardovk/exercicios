import java.util.Scanner;

public class Principal {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opt;
		
		System.out.println("\nSelecione uma opção: \n");
		
		
		Menu menuPrincipal = new Menu(6);
		Menu menuClientes = new Menu(3);
		Menu menuAvioes = new Menu(3);
		Menu menuVoos = new Menu(3);
		Menu menuVendas = new Menu(3);
		Menu menuRelatorio = new Menu(4);
		
		menuPrincipal.options[0] = new Option("Clientes", "", menuClientes);
		menuPrincipal.options[1] = new Option("Aviões", "", menuAvioes);
		menuPrincipal.options[2] = new Option("Voos", "", menuVoos);
		menuPrincipal.options[3] = new Option("Vendas", "", menuVendas);
		menuPrincipal.options[4] = new Option("Relatório", "", menuRelatorio);
		menuPrincipal.options[5] = new Option("Sair", "sair", null);
		
		
		menuClientes.options[0] = new Option("Cadastrar Novo Cliente ", "cadastrarCliente", null);
		menuClientes.options[1] = new Option("Exibir Clientes ", "exibeClientes", null);
		menuClientes.options[2] = new Option("Voltar", "", menuPrincipal);
		
		menuAvioes.options[0] = new Option("Cadastrar Novo Avião ", "cadastrarAviao", null);
		menuAvioes.options[1] = new Option("Exibir Aviões ", "exibeAvioes", null);
		menuAvioes.options[2] = new Option("Voltar", "", menuPrincipal);
		
		menuVoos.options[0] = new Option("Cadastrar novo Voo ", "cadastrarVoo", null);
		menuVoos.options[1] = new Option("Exibir Voos ", "exibeVoos", null);
		menuVoos.options[2] = new Option("Voltar", "", menuPrincipal);
		
		menuVendas.options[0] = new Option("Cadastrar Nova Venda ", "cadastrarVenda", null);
		menuVendas.options[1] = new Option("Exibir Vendas", "exibeVendas", null);
		menuVendas.options[2] = new Option("Voltar", "", menuPrincipal);
		
		menuRelatorio.options[0] = new Option("Gerar Relatório de Vendas por Cliente ", "relatorioPorCliente", null);
		menuRelatorio.options[1] = new Option("Gerar Relatório de Vendas por Origem ", "relatorioPorOrigem", null);
		menuRelatorio.options[2] = new Option("Gerar Relatório de Vendas por Destino ", "relatorioPorDestino", null);
		menuRelatorio.options[3] = new Option("Voltar", "", menuPrincipal);
		popular();
		
		menuPrincipal.show();
		
	}
	
	public static void popular()
	{
		CadastroCliente.popular();
		CadastroAviao.popular();
		CadastroVoo.popular();
		CadastroVenda.popular();
	}

}
