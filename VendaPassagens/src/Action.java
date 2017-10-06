
public final class Action {
	
	
	
	public static void executeAction(String action)
	{
		if(action.equals("cadastrarCliente"))
			CadastroCliente.solicitarDados();
		else if(action.equals("exibeClientes"))
			CadastroCliente.exibeClientes();
		else if(action.equals("cadastrarAviao"))
			CadastroAviao.solicitarDados();
		else if(action.equals("exibeAvioes"))
			CadastroAviao.exibeAvioes();
		else if(action.equals("cadastrarVoo"))
			CadastroVoo.solicitarDados();
		else if(action.equals("exibeVoos"))
			CadastroVoo.exibeVoos();
		else if(action.equals("cadastrarVenda"))
			CadastroVenda.solicitarDados();
		else if(action.equals("exibeVendas"))
			CadastroVenda.exibeVendas(null);
		else if(action.equals("relatorioPorCliente"))
			Relatorio.vendasPorCliente();
		else if(action.equals("relatorioPorOrigem"))
			Relatorio.vendasPorOrigem();
		else if(action.equals("relatorioPorDestino"))
			Relatorio.vendasPorDestino();

	}
}
